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

package com.facebook.buck.shell;

import com.facebook.buck.model.BuildTarget;
import com.facebook.buck.parser.NoSuchBuildTargetException;
import com.facebook.buck.rules.AbstractNodeBuilder;
import com.facebook.buck.rules.BuildRule;
import com.facebook.buck.rules.BuildRuleParams;
import com.facebook.buck.rules.BuildRuleResolver;
import com.facebook.buck.rules.Description;
import com.facebook.buck.rules.NoopBuildRule;
import com.facebook.buck.rules.SourcePathResolver;
import com.facebook.buck.rules.TargetGraph;
import com.facebook.buck.rules.Tool;
import com.google.common.hash.HashCode;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;

public class FakeWorkerBuilder extends AbstractNodeBuilder<
    Object, FakeWorkerBuilder.FakeWorkerDescription, FakeWorkerBuilder.FakeWorkerTool> {

  public FakeWorkerBuilder(BuildTarget target) {
    this(target, FakeWorkerTool::new);
  }

  public FakeWorkerBuilder(
      BuildTarget target,
      Function<BuildRuleParams, BuildRule> create) {
    super(new FakeWorkerDescription(create), target);
  }

  public static class FakeWorkerTool extends NoopBuildRule implements WorkerTool {

    public FakeWorkerTool(BuildRuleParams params) {
      super(params);
    }
    @Override
    public Tool getTool() {
      return null;
    }

    @Override
    public String getArgs(SourcePathResolver pathResolver) {
      return "";
    }

    @Override
    public Path getTempDir() {
      return Paths.get("");
    }

    @Override
    public int getMaxWorkers() {
      return 0;
    }

    @Override
    public boolean isPersistent() {
      return false;
    }

    @Override
    public HashCode getInstanceKey() {
      return null;
    }

  }

  public static class FakeWorkerDescription implements Description<Object> {
    private final Function<BuildRuleParams, BuildRule> create;

    private FakeWorkerDescription(Function<BuildRuleParams, BuildRule> create) {
      this.create = create;
    }

    @Override
    public Object createUnpopulatedConstructorArg() {
      return new Object();
    }

    @Override
    public <A> BuildRule createBuildRule(
        TargetGraph targetGraph,
        BuildRuleParams params,
        BuildRuleResolver resolver,
        A args) throws NoSuchBuildTargetException {
      return create.apply(params);
    }

  }
}


