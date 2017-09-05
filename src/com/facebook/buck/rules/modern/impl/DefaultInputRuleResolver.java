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

package com.facebook.buck.rules.modern.impl;

import com.facebook.buck.rules.BuildRule;
import com.facebook.buck.rules.SourcePath;
import com.facebook.buck.rules.SourcePathRuleFinder;
import com.facebook.buck.rules.modern.InputData;
import com.facebook.buck.rules.modern.InputPath;
import com.facebook.buck.rules.modern.InputRuleResolver;
import java.util.Optional;

public class DefaultInputRuleResolver implements InputRuleResolver {
  private SourcePathRuleFinder ruleFinder;

  public DefaultInputRuleResolver(SourcePathRuleFinder ruleFinder) {
    this.ruleFinder = ruleFinder;
  }

  @Override
  public Optional<BuildRule> resolve(InputPath path) {
    return ruleFinder.getRule(InputPath.Internals.getSourcePathFrom(path));
  }

  @Override
  public Optional<BuildRule> resolve(InputData data) {
    Optional<SourcePath> sp = data.getSourcePath();
    if (!sp.isPresent()) {
      return Optional.empty();
    }
    return ruleFinder.getRule(sp.get());
  }
}
