/*
 * Copyright 2017-present Facebook, Inc.
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

package com.facebook.buck.js;

import com.facebook.buck.model.BuildTarget;
import com.facebook.buck.model.Either;
import com.facebook.buck.rules.AbstractNodeBuilder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;

import java.util.Optional;

public class JsBundleBuilder extends
    AbstractNodeBuilder<JsBundleDescription.Arg, JsBundleDescription, JsBundle> {
  private static final JsBundleDescription bundleDescription = new JsBundleDescription();

  JsBundleBuilder(
      BuildTarget target,
      BuildTarget worker,
      ImmutableSortedSet<BuildTarget> libs,
      Either<ImmutableSet<String>, String> entry) {
    super(bundleDescription, target);
    arg.entry = entry;
    arg.libs = libs;
    arg.bundleName = Optional.empty();
    arg.worker = worker;
  }

  JsBundleBuilder setBundleName(String bundleName) {
    arg.bundleName = Optional.of(bundleName);
    return this;
  }
}
