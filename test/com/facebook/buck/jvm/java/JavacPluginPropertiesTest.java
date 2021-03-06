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

import static org.junit.Assert.assertThat;

import com.facebook.buck.core.model.BuildTargetFactory;
import com.facebook.buck.core.rules.ActionGraphBuilder;
import com.facebook.buck.core.rules.BuildRule;
import com.facebook.buck.core.rules.SourcePathRuleFinder;
import com.facebook.buck.core.rules.resolver.impl.TestActionGraphBuilder;
import com.google.common.collect.ImmutableSortedSet;
import org.hamcrest.Matchers;
import org.junit.Test;

public class JavacPluginPropertiesTest {
  @Test
  public void transitiveAnnotationProcessorDepsInInputs() {
    ActionGraphBuilder graphBuilder = new TestActionGraphBuilder();
    SourcePathRuleFinder ruleFinder = new SourcePathRuleFinder(graphBuilder);

    FakeJavaLibrary rawDep = new FakeJavaLibrary(BuildTargetFactory.newInstance("//:dep"));
    BuildRule dep = graphBuilder.computeIfAbsent(rawDep.getBuildTarget(), buildTarget -> rawDep);
    FakeJavaLibrary rawProcessor =
        new FakeJavaLibrary(
            BuildTargetFactory.newInstance("//:processor"), ImmutableSortedSet.of(dep));
    BuildRule processor =
        graphBuilder.computeIfAbsent(rawProcessor.getBuildTarget(), buildTarget -> rawProcessor);

    JavacPluginProperties props =
        JavacPluginProperties.builder()
            .setCanReuseClassLoader(false)
            .setDoesNotAffectAbi(false)
            .setSupportsAbiGenerationFromSource(false)
            .addDep(processor)
            .build();

    assertThat(
        ruleFinder.filterBuildRuleInputs(props.getInputs()),
        Matchers.containsInAnyOrder(processor, dep));
  }
}
