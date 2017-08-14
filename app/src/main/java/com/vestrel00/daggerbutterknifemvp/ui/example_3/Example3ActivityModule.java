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

package com.vestrel00.daggerbutterknifemvp.ui.example_3;

import android.support.v7.app.AppCompatActivity;

import com.vestrel00.daggerbutterknifemvp.inject.PerActivity;
import com.vestrel00.daggerbutterknifemvp.inject.PerFragment;
import com.vestrel00.daggerbutterknifemvp.ui.common.BaseActivityModule;
import com.vestrel00.daggerbutterknifemvp.ui.example_3.parent_fragment.view.Example3ParentFragment;
import com.vestrel00.daggerbutterknifemvp.ui.example_3.parent_fragment.view.Example3ParentFragmentModule;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Provides example 3 activity dependencies.
 */
@Module(includes = BaseActivityModule.class)
public abstract class Example3ActivityModule {

    /**
     * Provides the injector for the {@link Example3ParentFragment}, which has access to the
     * dependencies provided by this activity and application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = Example3ParentFragmentModule.class)
    abstract Example3ParentFragment example3ParentFragmentInjector();

    /**
     * As per the contract specified in {@link BaseActivityModule}; "This must be included in all
     * activity modules, which must rovide a concrete implementation of {@link AppCompatActivity}."
     * <p>
     * This provides the activity required to inject the
     * {@link BaseActivityModule#ACTIVITY_FRAGMENT_MANAGER} into the
     * {@link com.vestrel00.daggerbutterknifemvp.ui.common.BaseActivity}.
     *
     * @param example3Activity the example 3 activity
     * @return the activity
     */
    @Binds
    @PerActivity
    abstract AppCompatActivity appCompatActivity(Example3Activity example3Activity);
}
