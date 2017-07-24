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

package com.vestrel00.daggerbutterknifemvp.ui.example_1;


import com.vestrel00.daggerbutterknifemvp.inject.PerActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Injects example 1 activity dependencies.
 * <p>
 * TODO (ContributesAndroidInjector) remove this in favor of @ContributesAndroidInjector
 */
@PerActivity
@Subcomponent(modules = Example1ActivityModule.class)
public interface Example1ActivitySubcomponent extends AndroidInjector<Example1Activity> {

    /**
     * The builder for this subcomponent.
     */
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<Example1Activity> {
    }
}
