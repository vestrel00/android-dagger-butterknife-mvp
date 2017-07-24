/*
 * Copyright 2017 Vandolf Estrellado
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vestrel00.daggerbutterknifemvp.ui.example_3.child_fragment;

import com.vestrel00.daggerbutterknifemvp.inject.PerChildFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Injects example 3 child fragment dependencies.
 * <p>
 * TODO (ContributesAndroidInjector) remove this in favor of @ContributesAndroidInjector
 */
@PerChildFragment
@Subcomponent(modules = Example3ChildFragmentModule.class)
public interface Example3ChildFragmentSubcomponent extends AndroidInjector<Example3ChildFragment> {

    /**
     * The builder for this subcomponent.
     */
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<Example3ChildFragment> {
    }
}
