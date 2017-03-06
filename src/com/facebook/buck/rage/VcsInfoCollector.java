/*
 * Copyright 2016-present Facebook, Inc.
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

package com.facebook.buck.rage;

import static com.facebook.buck.util.versioncontrol.VersionControlStatsGenerator.TRACKED_BOOKMARKS;

import com.facebook.buck.model.Pair;
import com.facebook.buck.util.immutables.BuckStyleImmutable;
import com.facebook.buck.util.versioncontrol.VersionControlCmdLineInterface;
import com.facebook.buck.util.versioncontrol.VersionControlCommandFailedException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import org.immutables.value.Value;

import java.util.Map;
import java.util.Optional;

/**
 * Responsible foe getting information out of the version control system.
 */
public class VcsInfoCollector {

  private final VersionControlCmdLineInterface vcCmdLineInterface;

  private VcsInfoCollector(VersionControlCmdLineInterface vcCmdLineInterface) {
    this.vcCmdLineInterface = vcCmdLineInterface;
  }

  public static Optional<VcsInfoCollector> create(
      VersionControlCmdLineInterface vcCmdLineInterface) {
    if (!vcCmdLineInterface.isSupportedVersionControlSystem()) {
      return Optional.empty();
    }
    return Optional.of(new VcsInfoCollector(vcCmdLineInterface));
  }

  public SourceControlInfo gatherScmInformation()
      throws InterruptedException, VersionControlCommandFailedException {
    String currentRevisionId = vcCmdLineInterface.currentRevisionId();
    ImmutableMap<String, String> bookmarksRevisionIds =
        vcCmdLineInterface.bookmarksRevisionsId(TRACKED_BOOKMARKS);
    Pair<String, Long> baseRevisionInfo = vcCmdLineInterface.commonAncestorAndTS(
        currentRevisionId,
        bookmarksRevisionIds.get("remote/master"));

    ImmutableSet.Builder<String> baseBookmarks = ImmutableSet.builder();
    for (Map.Entry<String, String> bookmark : bookmarksRevisionIds.entrySet()) {
      if (bookmark.getValue().startsWith(baseRevisionInfo.getFirst())) {
        baseBookmarks.add(bookmark.getKey());
      }
    }

    return SourceControlInfo.builder()
        .setCurrentRevisionId(currentRevisionId)
        .setRevisionIdOffTracked(baseRevisionInfo.getFirst())
        .setRevisionTimestampOffTracked(baseRevisionInfo.getSecond())
        .setBasedOffWhichTracked(baseBookmarks.build())
        .setDiff(vcCmdLineInterface.diffBetweenRevisionsOrAbsent(
            baseRevisionInfo.getFirst(),
            currentRevisionId))
        .setDirtyFiles(vcCmdLineInterface.changedFiles(baseRevisionInfo.getFirst()))
        .build();
  }

  @Value.Immutable
  @BuckStyleImmutable
  interface AbstractSourceControlInfo {
    /* Commit hash of the current revision. */
    String getCurrentRevisionId();
    /* A list of bookmarks that the current commit is based and also exist in TRACKED_BOOKMARKS */
    ImmutableSet<String> getBasedOffWhichTracked();
    /* Commit hash of the revision that is the common base between current revision and master. */
    Optional<String> getRevisionIdOffTracked();
    /* The timestamp of the base revision */
    Optional<Long> getRevisionTimestampOffTracked();
    /* The diff between base and current revision if it exists */
    @JsonIgnore
    Optional<String> getDiff();
    /* A list of all the files that are changed from the base revision. */
    ImmutableSet<String> getDirtyFiles();
  }
}
