/*
 * Copyright 2015-present Facebook, Inc.
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

package com.facebook.buck.jvm.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.facebook.buck.testutil.TestCustomZipOutputStream;
import com.google.common.collect.ImmutableSet;

import org.junit.Before;
import org.junit.Test;

import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

/**
 * Tests {@link JavaInMemoryFileManager}
 */
public class JavaInMemoryFileManagerTest {

  private JavaInMemoryFileManager inMemoryFileManager;
  private TestCustomZipOutputStream outputStream;

  @Before
  public void setUp() {
    outputStream = new TestCustomZipOutputStream();
    DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
    inMemoryFileManager = new JavaInMemoryFileManager(
        ToolProvider.getSystemJavaCompiler().getStandardFileManager(diagnostics, null, null),
        Paths.get(URI.create("file:///tmp/test.jar!/")),
        outputStream,
        /*classesToBeRemovedFromJar */ ImmutableSet.of());
  }

  @Test
  public void testJavaFileName() throws Exception {
    JavaFileObject fileObject = inMemoryFileManager.getJavaFileForOutput(
        StandardLocation.CLASS_OUTPUT,
        "com.facebook.buck.jvm.java.JavaFileParser",
        JavaFileObject.Kind.CLASS,
        null);

    assertEquals(JavaFileObject.Kind.CLASS, fileObject.getKind());
    assertEquals("com/facebook/buck/jvm/java/JavaFileParser.class", fileObject.getName());
  }

  @Test
  public void testWriteContent() throws Exception {
    JavaFileObject fileObject = inMemoryFileManager.getJavaFileForOutput(
        StandardLocation.CLASS_OUTPUT,
        "JavaFileParser",
        JavaFileObject.Kind.CLASS,
        null);

    OutputStream stream = fileObject.openOutputStream();
    stream.write("Hello World!".getBytes());
    stream.close();

    List<String> entries = outputStream.getEntriesContent();
    assertEquals(1, entries.size());
    assertEquals("Hello World!", entries.get(0));
  }

  @Test
  public void testIntermediateDirectoriesAreCreated() throws Exception {
    JavaFileObject fileObject = inMemoryFileManager.getJavaFileForOutput(
        StandardLocation.CLASS_OUTPUT,
        "jvm.java.JavaFileParser",
        JavaFileObject.Kind.CLASS,
        null);

    fileObject.openOutputStream().close();

    List<ZipEntry> zipEntries = outputStream.getZipEntries();
    assertEquals(3, zipEntries.size());
    assertEquals("jvm/", zipEntries.get(0).getName());
    assertEquals("jvm/java/", zipEntries.get(1).getName());
    assertEquals("jvm/java/JavaFileParser.class", zipEntries.get(2).getName());
  }

  @Test
  public void testMultipleFilesInSamePackage() throws Exception {
    JavaFileObject fileObject1 = inMemoryFileManager.getJavaFileForOutput(
        StandardLocation.CLASS_OUTPUT,
        "jvm.java.JavaFileParser",
        JavaFileObject.Kind.CLASS,
        null);

    JavaFileObject fileObject2 = inMemoryFileManager.getJavaFileForOutput(
        StandardLocation.CLASS_OUTPUT,
        "jvm.java.JavaInMemoryFileManager",
        JavaFileObject.Kind.CLASS,
        null);

    fileObject1.openOutputStream().close();
    fileObject2.openOutputStream().close();

    List<ZipEntry> zipEntries = outputStream.getZipEntries();
    assertEquals(4, zipEntries.size());
    assertEquals("jvm/", zipEntries.get(0).getName());
    assertEquals("jvm/java/", zipEntries.get(1).getName());
    assertEquals("jvm/java/JavaFileParser.class", zipEntries.get(2).getName());
    assertEquals("jvm/java/JavaInMemoryFileManager.class", zipEntries.get(3).getName());
  }

  @Test
  public void testIsNotSameFile() throws Exception {
    JavaFileObject fileObject1 = inMemoryFileManager.getJavaFileForOutput(
        StandardLocation.CLASS_OUTPUT,
        "jvm.java.JavaFileParser",
        JavaFileObject.Kind.CLASS,
        null);

    JavaFileObject fileObject2 = inMemoryFileManager.getJavaFileForOutput(
        StandardLocation.CLASS_OUTPUT,
        "jvm.java.JavaInMemoryFileManager",
        JavaFileObject.Kind.CLASS,
        null);

    assertFalse(inMemoryFileManager.isSameFile(fileObject1, fileObject2));
  }

  @Test
  public void testIsSameFile() throws Exception {
    JavaFileObject fileObject1 = inMemoryFileManager.getJavaFileForOutput(
        StandardLocation.CLASS_OUTPUT,
        "jvm.java.JavaFileParser",
        JavaFileObject.Kind.CLASS,
        null);

    JavaFileObject fileObject2 = inMemoryFileManager.getJavaFileForOutput(
        StandardLocation.CLASS_OUTPUT,
        "jvm.java.JavaFileParser",
        JavaFileObject.Kind.CLASS,
        null);

    assertTrue(inMemoryFileManager.isSameFile(fileObject1, fileObject2));
  }

  @Test
  public void testNonRecursiveListOperationReturnsNewlyCreatedFile() throws Exception {
    JavaFileObject fileObject1 = inMemoryFileManager.getJavaFileForOutput(
        StandardLocation.CLASS_OUTPUT,
        "jvm.java.JavaFileParser",
        JavaFileObject.Kind.CLASS,
        null);
    Iterator<JavaFileObject> nonRecursiveIterable = inMemoryFileManager.list(
      StandardLocation.CLASS_OUTPUT,
      "jvm.java",
      Collections.singleton(JavaFileObject.Kind.CLASS),
      false)
      .iterator();

    assertEquals(fileObject1, nonRecursiveIterable.next());
    assertFalse(nonRecursiveIterable.hasNext());
  }

  @Test
  public void testNonRecursiveListOperationDoesntReturnNewlyCreatedFileOnOtherDir()
      throws Exception {
    JavaFileObject fileObject1 = inMemoryFileManager.getJavaFileForOutput(
        StandardLocation.CLASS_OUTPUT,
        "jvm.java.JavaFileParser",
        JavaFileObject.Kind.CLASS,
        null);
    assertEquals("jvm/java/JavaFileParser.class", fileObject1.getName());
    Iterator<JavaFileObject> recursiveIterable = inMemoryFileManager.list(
      StandardLocation.CLASS_OUTPUT,
      "jvm",
      Collections.singleton(JavaFileObject.Kind.CLASS),
      false)
      .iterator();
    assertFalse(recursiveIterable.hasNext());
  }

  @Test
  public void testRecursiveListOperationReturnsNewlyCreatedFile() throws Exception {
    JavaFileObject fileObject1 = inMemoryFileManager.getJavaFileForOutput(
        StandardLocation.CLASS_OUTPUT,
        "jvm.java.JavaFileParser",
        JavaFileObject.Kind.CLASS,
        null);
    Iterator<JavaFileObject> recursiveIterable = inMemoryFileManager.list(
      StandardLocation.CLASS_OUTPUT,
      "jvm",
      Collections.singleton(JavaFileObject.Kind.CLASS),
      true)
      .iterator();

    assertEquals(fileObject1, recursiveIterable.next());
    assertFalse(recursiveIterable.hasNext());
  }
}
