/*
 * Copyright 2013-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.io.file;

import com.facebook.buck.cli.bootstrapper.filesystem.BuckUnixPath;
import com.facebook.buck.core.exceptions.HumanReadableException;
import com.facebook.buck.core.util.log.Logger;
import com.facebook.buck.io.windowsfs.WindowsFS;
import com.facebook.buck.util.RichStream;
import com.facebook.buck.util.environment.Platform;
import com.facebook.buck.util.string.MoreStrings;
import com.facebook.buck.util.types.Pair;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Streams;
import com.google.common.io.ByteSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

/**
 * Common functions that are done with a {@link Path}. If a function is going to take a {@link
 * com.facebook.buck.io.filesystem.ProjectFilesystem}, then it should be in {@link
 * com.facebook.buck.io.MoreProjectFilesystems} instead.
 */
public class MorePaths {

  private static final Logger LOG = Logger.get(MorePaths.class);

  /** Utility class: do not instantiate. */
  private MorePaths() {}

  public static final Path EMPTY_PATH = Paths.get("");

  public static String pathWithUnixSeparators(String path) {
    return pathWithUnixSeparators(Paths.get(path));
  }

  public static String pathWithUnixSeparators(Path path) {
    return path.toString().replace('\\', '/');
  }

  public static String pathWithWindowsSeparators(Path path) {
    return path.toString().replace('/', '\\');
  }

  public static String pathWithPlatformSeparators(String path) {
    return pathWithPlatformSeparators(Paths.get(path));
  }

  public static String pathWithPlatformSeparators(Path path) {
    if (Platform.detect() == Platform.WINDOWS) {
      return pathWithWindowsSeparators(path);
    } else {
      return pathWithUnixSeparators(path);
    }
  }

  public static String pathWithUnixSeparatorsAndTrailingSlash(Path path) {
    return pathWithUnixSeparators(path) + "/";
  }

  public static Path getParentOrEmpty(Path path) {
    Path parent = path.getParent();
    if (parent == null) {
      parent = EMPTY_PATH;
    }
    return parent;
  }

  /**
   * Get the path of a file relative to a base directory.
   *
   * @param path must reference a file, not a directory.
   * @param baseDir must reference a directory that is relative to a common directory with the path.
   *     may be null if referencing the same directory as the path.
   * @return the relative path of path from the directory baseDir.
   */
  public static Path getRelativePath(Path path, @Nullable Path baseDir) {
    if (baseDir == null) {
      // This allows callers to use this method with "file.parent()" for files from the project
      // root dir.
      baseDir = EMPTY_PATH;
    }
    Preconditions.checkArgument(!path.isAbsolute(), "Path must be relative: %s.", path);
    Preconditions.checkArgument(!baseDir.isAbsolute(), "Path must be relative: %s.", baseDir);
    return relativize(baseDir, path);
  }

  /**
   * Get a relative path from path1 to path2, first normalizing each path.
   *
   * <p>This method is a workaround for JDK-6925169 (Path.relativize returns incorrect result if
   * path contains "." or "..").
   */
  public static Path relativize(Path path1, Path path2) {
    Preconditions.checkArgument(
        path1.isAbsolute() == path2.isAbsolute(),
        "Both paths must be absolute or both paths must be relative. (%s is %s, %s is %s)",
        path1,
        path1.isAbsolute() ? "absolute" : "relative",
        path2,
        path2.isAbsolute() ? "absolute" : "relative");

    path1 = normalize(path1);
    path2 = normalize(path2);

    // On Windows, if path1 is "" then Path.relativize returns ../path2 instead of path2 or ./path2
    if (EMPTY_PATH.equals(path1)) {
      return path2;
    }
    return path1.relativize(path2);
  }

  /**
   * Get a path without unnecessary path parts.
   *
   * <p>This method is a workaround for JDK-8037945 (Paths.get("").normalize() throws
   * ArrayIndexOutOfBoundsException).
   */
  public static Path normalize(Path path) {
    if (!EMPTY_PATH.equals(path)) {
      path = path.normalize();
    }
    return path;
  }

  /**
   * Filters out {@link Path} objects from {@code paths} that aren't a subpath of {@code root} and
   * returns a set of paths relative to {@code root}.
   */
  public static ImmutableSet<Path> filterForSubpaths(Iterable<Path> paths, Path root) {
    Path normalizedRoot = root.toAbsolutePath().normalize();
    return Streams.stream(paths)
        .filter(
            input -> {
              if (input.isAbsolute()) {
                return input.normalize().startsWith(normalizedRoot);
              } else {
                return true;
              }
            })
        .map(
            input -> {
              if (input.isAbsolute()) {
                return relativize(normalizedRoot, input);
              } else {
                return input;
              }
            })
        .collect(ImmutableSet.toImmutableSet());
  }

  /** Expands "~/foo" into "/home/zuck/foo". Returns regular paths unmodified. */
  public static Path expandHomeDir(Path path) {
    if (!path.startsWith("~")) {
      return path;
    }
    Path homePath = path.getFileSystem().getPath(System.getProperty("user.home"));
    if (path.equals(path.getFileSystem().getPath("~"))) {
      return homePath;
    }
    return homePath.resolve(path.subpath(1, path.getNameCount()));
  }

  public static ByteSource asByteSource(Path path) {
    return new ByteSource() {
      @Override
      public InputStream openStream() throws IOException {
        return Files.newInputStream(path);
      }
    };
  }

  public static String getFileExtension(Path path) {
    String name = path.getFileName().toString();
    int index = name.lastIndexOf('.');
    return index == -1 ? "" : name.substring(index + 1);
  }

  public static String getNameWithoutExtension(Path file) {
    String name = file.getFileName().toString();
    int index = name.lastIndexOf('.');
    return index == -1 ? name : name.substring(0, index);
  }

  public static String stripPathPrefixAndExtension(Path fileName, String prefix) {
    String nameWithoutExtension = getNameWithoutExtension(fileName);

    if (!nameWithoutExtension.startsWith(prefix)
        || nameWithoutExtension.length() < prefix.length()) {
      throw new HumanReadableException(
          "Invalid prefix on filename in path %s (file %s) - expecting %s",
          fileName, nameWithoutExtension, prefix);
    }

    return nameWithoutExtension.substring(prefix.length());
  }

  public static Optional<Path> stripPrefix(Path p, Path prefix) {
    if (prefix.getNameCount() > p.getNameCount()) {
      return Optional.empty();
    }
    for (int i = 0; i < prefix.getNameCount(); ++i) {
      if (!prefix.getName(i).equals(p.getName(i))) {
        return Optional.empty();
      }
    }
    return Optional.of(p.subpath(prefix.getNameCount(), p.getNameCount()));
  }

  public static Function<String, Path> toPathFn(FileSystem fileSystem) {
    return input -> fileSystem.getPath(input);
  }

  private static Path dropPathPart(Path p, int i) {
    if (i == 0) {
      return p.subpath(1, p.getNameCount());
    } else if (i == p.getNameCount() - 1) {
      return p.subpath(0, p.getNameCount() - 1);
    } else {
      return p.subpath(0, i).resolve(p.subpath(i + 1, p.getNameCount()));
    }
  }

  /**
   * Drop any "." parts (useless). Do keep ".." parts; don't normalize them away.
   *
   * <p>Note that while Path objects provide a {@link Path#normalize()} method for eliminating
   * redundant parts of paths like in {@code foo/a/../b/c}, changing its internal parts (and
   * actually using the filesystem), we don't use those methods to clean up the incoming paths; we
   * only strip empty parts, and those consisting only of {@code .} because doing so maps
   * exactly-same paths together, and can't influence where it may point to, whereas {@code ..} and
   * symbolic links might.
   */
  public static Path fixPath(Path p) {
    int i = 0;
    while (i < p.getNameCount()) {
      if (p.getName(i).toString().equals(".")) {
        p = dropPathPart(p, i);
      } else {
        i++;
      }
    }
    return p;
  }

  /**
   * Drop the cache in Path object.
   *
   * <p>Path's implementation class {@code UnixPath}, will lazily initialize a String representation
   * and store it in the object when {@code #toString()} is called for the first time. This doubles
   * the memory requirement for the Path object.
   *
   * <p>This hack constructs a new path, dropping the cached toString value.
   *
   * <p>Due to the nature of what this function does, it's very sensitive to the implementation. Any
   * calls to {@code #toString()} on the returned object would also recreate the cached string
   * value.
   */
  public static Path dropInternalCaches(Path p) {
    // This optimization does nothing for BuckUnixPath, and in fact wastes time.
    // Just bail without pessimizing in that case.
    if (p instanceof BuckUnixPath) {
      return p;
    }
    return p.getFileSystem().getPath(p.toString());
  }

  public static int commonSuffixLength(Path a, Path b) {
    int count = 0;
    while (count < a.getNameCount() && count < b.getNameCount()) {
      if (!a.getName(a.getNameCount() - count - 1)
          .equals(b.getName(b.getNameCount() - count - 1))) {
        break;
      }
      count++;
    }
    return count;
  }

  public static Pair<Path, Path> stripCommonSuffix(Path a, Path b) {
    int count = commonSuffixLength(a, b);
    return new Pair<>(
        count == a.getNameCount()
            ? a.getFileSystem().getPath("")
            : a.subpath(0, a.getNameCount() - count),
        count == b.getNameCount()
            ? b.getFileSystem().getPath("")
            : b.subpath(0, b.getNameCount() - count));
  }

  private static int getCommonPrefixLength(Iterable<Path> paths) {
    Optional<Integer> minSize =
        RichStream.from(paths).map(Path::getNameCount).min(Integer::compareTo);
    int count;
    for (count = 0; count < minSize.orElse(0); count++) {
      Path prev = null;
      for (Path path : paths) {
        if (prev != null && !prev.getName(count).equals(path.getName(count))) {
          return count;
        }
        prev = path;
      }
    }
    return count;
  }

  public static Optional<Pair<Path, ImmutableList<Path>>> splitOnCommonPrefix(
      Iterable<Path> paths) {
    int commonPrefix = getCommonPrefixLength(paths);
    return RichStream.from(paths)
        .findFirst()
        .flatMap(
            firstPath -> {
              Path root = firstPath.getRoot();
              for (Path path : paths) {
                if (!Objects.equals(path.getRoot(), root)) {
                  return Optional.empty();
                }
              }
              if (commonPrefix == 0 && root == null) {
                // TODO(cjhopman): This is odd. I think it should return Optional.empty() when
                // there's no common prefix, but this matches previous behavior.
                root = firstPath.getFileSystem().getPath("");
              }
              Path prefixPath =
                  commonPrefix == 0
                      ? root
                      : root == null
                          ? firstPath.subpath(0, commonPrefix)
                          : root.resolve(firstPath.subpath(0, commonPrefix));
              return Optional.of(
                  new Pair<>(prefixPath, getPrefixStrippedPaths(paths, commonPrefix)));
            });
  }

  private static ImmutableList<Path> getPrefixStrippedPaths(
      Iterable<Path> paths, int commonPrefix) {
    return RichStream.from(paths)
        .map(
            p ->
                commonPrefix == p.getNameCount()
                    ? p.getFileSystem().getPath("")
                    : p.subpath(commonPrefix, p.getNameCount()))
        .toImmutableList();
  }

  /**
   * Creates a symlink.
   *
   * @param winFS WindowsFS object that creates symlink on Windows using different permission level
   *     implementations.
   * @param symLink the symlink to create.
   * @param target the target of the symlink.
   * @throws IOException
   */
  public static void createSymLink(@Nullable WindowsFS winFS, Path symLink, Path target)
      throws IOException {
    if (Platform.detect() == Platform.WINDOWS) {
      Objects.requireNonNull(winFS);
      target = MorePaths.normalize(symLink.getParent().resolve(target));
      winFS.createSymbolicLink(symLink, target, isDirectory(target));
    } else {
      Files.createSymbolicLink(symLink, target);
    }
  }

  /**
   * Returns whether a path is a directory..
   *
   * @param path An absolute file name
   * @param linkOptions Link options
   * @return Whether the path is a directory.
   */
  public static boolean isDirectory(Path path, LinkOption... linkOptions) {
    return Files.isDirectory(normalize(path).toAbsolutePath(), linkOptions);
  }

  /**
   * Verify a file exists and also check the case of file path which {@link Files#exists(Path,
   * LinkOption...)} failed to do so for case-insensitive file systems. This method also works for
   * case-sensitive file systems
   *
   * @param path A path to a file
   * @param rootPath the root path to start with
   * @return A wrap contains {@link PathExistResult} and paths that actually exist but with case
   *     mismatched if the input path does not exist. See {@link PathExistResultWrapper} for more
   *     details.
   */
  public static PathExistResultWrapper pathExistsCaseSensitive(Path path, Path rootPath)
      throws IOException {
    Path absolutePath = path.isAbsolute() ? path : rootPath.resolve(path);
    boolean fileExist = Files.exists(absolutePath);

    if (path.equals(rootPath) && fileExist) {
      return new PathExistResultWrapper(PathExistResult.EXIST_CASE_MATCHED, Optional.empty());
    }

    Path relativePath = path.isAbsolute() ? rootPath.relativize(path) : path;

    List<Path> currentParentPathIgnoreCaseList = Collections.singletonList(rootPath);
    Path parentPath = rootPath;

    int nameCount = relativePath.getNameCount();

    for (Path subPath : relativePath) {
      nameCount--;
      boolean isLastSubPath = (nameCount == 0);
      Path currentPath = parentPath.resolve(subPath);
      String currentFileName = currentPath.getFileName().toString();

      List<Path> nextParentPathIgnoreCaseList = new ArrayList<>();
      boolean existCurrentPathIgnoreCase = false;
      for (Path currentParentPathIgnoreCase : currentParentPathIgnoreCaseList) {
        try (DirectoryStream<Path> stream =
            Files.newDirectoryStream(
                currentParentPathIgnoreCase,
                filePath ->
                    filePath.getFileName().toString().equalsIgnoreCase(currentFileName)
                        && (isLastSubPath || Files.isDirectory(filePath)))) {
          Iterator<Path> it = stream.iterator();
          if (it.hasNext()) {
            existCurrentPathIgnoreCase = true;
            it.forEachRemaining(nextParentPathIgnoreCaseList::add);
          }
        }
      }
      if (!existCurrentPathIgnoreCase) {
        return new PathExistResultWrapper(PathExistResult.NOT_EXIST, Optional.empty());
      }
      currentParentPathIgnoreCaseList = nextParentPathIgnoreCaseList;
      parentPath = currentPath;
    }

    boolean pathExistCaseSensitive =
        currentParentPathIgnoreCaseList
            .stream()
            .anyMatch(filePath -> filePath.toString().equals(absolutePath.toString()));

    return pathExistCaseSensitive
        ? new PathExistResultWrapper(PathExistResult.EXIST_CASE_MATCHED, Optional.empty())
        : new PathExistResultWrapper(
            PathExistResult.EXIST_CASE_MISMATCHED, Optional.of(currentParentPathIgnoreCaseList));
  }

  /**
   * A wrap contains {@link PathExistResult} and paths that actually exist but with case mismatched
   * if the input path does not exist. For the first part, {@link PathExistResult#NOT_EXIST} if the
   * file does not exist, {@link PathExistResult#EXIST_CASE_MISMATCHED} exist but case mismatched,
   * or {@link PathExistResult#EXIST_CASE_MATCHED}exist and case matched . For the second part, will
   * not be Optional.empty() only when the first part returns {@link
   * PathExistResult#EXIST_CASE_MISMATCHED}, which will give a list of paths that exist but
   * case-mismatched with the input path
   */
  public static class PathExistResultWrapper {
    private final PathExistResult result;
    private final Optional<List<Path>> pathsCaseMismatched;

    public PathExistResultWrapper(
        PathExistResult pathExistResult, Optional<List<Path>> pathsCaseMismatched) {
      this.result = pathExistResult;
      this.pathsCaseMismatched = pathsCaseMismatched;
    }

    public PathExistResult getResult() {
      return result;
    }

    public Optional<List<Path>> getCaseMismatchedPaths() {
      return pathsCaseMismatched;
    }
  }

  /**
   * The return result of a path existence check {@link PathExistResult#NOT_EXIST} if the file does
   * not exist, {@link PathExistResult#EXIST_CASE_MISMATCHED} exist but case mismatched, or {@link
   * PathExistResult#EXIST_CASE_MATCHED}exist and case matched
   */
  public enum PathExistResult {
    NOT_EXIST,
    EXIST_CASE_MATCHED,
    EXIST_CASE_MISMATCHED
  }

  /**
   * Suggest existing paths on given path based on Levenshtein distances allowed. The return result
   * will include the given path if the given path actually exists.
   *
   * <p>There are limitations on the suggestions for the performance optimization, such as it
   * couldn't search cross folder levels like : correct input: Alpha/Beta/Gamma/Delta.txt wrong
   * input: AlphaBeta/Gamma/Delta.txt
   *
   * @param path a path with potential typos
   * @param rootPath rootPath to start from
   * @param maxDistance Max Levenshtein Distance allowed
   * @return List<Pair<Path, Integer>> a list of suggested path and Levenshtein distance, the list
   *     is in ascending Levenshtein distance order.
   */
  public static List<Pair<Path, Integer>> getPathSuggestions(
      Path path, Path rootPath, int maxDistance) {

    Path relativePath = path.isAbsolute() ? rootPath.relativize(path) : path;
    List<Pair<Path, Integer>> candidates = Arrays.asList(new Pair<>(rootPath, 0));

    int nameCount = relativePath.getNameCount();
    for (Path subPath : relativePath) {
      if (candidates.isEmpty()) {
        return candidates;
      }

      String subPathString = subPath.getFileName().toString();

      nameCount--;
      boolean isLastSubPath = (nameCount == 0);

      List<Pair<Path, Integer>> nextCandidates = new ArrayList<>();
      for (Pair<Path, Integer> candidate : candidates) {
        Path candidatePath = candidate.getFirst();
        try {
          Set<String> fileNamesInFolderCandidate =
              Files.list(candidatePath)
                  .filter(
                      fileName ->
                          isLastSubPath || Files.isDirectory(fileName, LinkOption.NOFOLLOW_LINKS))
                  .map(Path::getFileName)
                  .map(Path::toString)
                  .collect(Collectors.toSet());
          int remainingDistanceAllowed = maxDistance - candidate.getSecond();
          List<Pair<String, Integer>> suggestedFileNamesAndLevenshteinDistance =
              MoreStrings.getSpellingSuggestionsWithLevenshteinDistance(
                  subPathString, fileNamesInFolderCandidate, remainingDistanceAllowed);

          List<Pair<Path, Integer>> suggestedFileAndLevenshteinDistance =
              suggestedFileNamesAndLevenshteinDistance
                  .stream()
                  .map(
                      folderNameAndDistance ->
                          new Pair<>(
                              candidatePath.resolve(folderNameAndDistance.getFirst()),
                              candidate.getSecond() + folderNameAndDistance.getSecond()))
                  .collect(Collectors.toList());
          nextCandidates.addAll(suggestedFileAndLevenshteinDistance);
        } catch (SecurityException | UncheckedIOException | IOException ignored) {
          LOG.warn(ignored, "Fail to list file %s", candidatePath);
        }
      }

      candidates = nextCandidates;
    }

    return candidates
        .stream()
        .sorted(Comparator.comparing(Pair::getSecond))
        .collect(Collectors.toList());
  }
}
