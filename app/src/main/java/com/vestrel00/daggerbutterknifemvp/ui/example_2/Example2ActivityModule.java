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

package com.vestrel00.daggerbutterknifemvp.ui.example_2;

import android.app.Activity;

import com.vestrel00.daggerbutterknifemvp.inject.PerActivity;
import com.vestrel00.daggerbutterknifemvp.inject.PerFragment;
import com.vestrel00.daggerbutterknifemvp.ui.common.BaseActivityModule;
import com.vestrel00.daggerbutterknifemvp.ui.example_2.fragment_a.view.Example2AFragment;
import com.vestrel00.daggerbutterknifemvp.ui.example_2.fragment_a.view.Example2AFragmentModule;
import com.vestrel00.daggerbutterknifemvp.ui.example_2.fragment_b.view.Example2BFragment;
import com.vestrel00.daggerbutterknifemvp.ui.example_2.fragment_b.view.Example2BFragmentModule;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Provides example 2 activity dependencies.
 */
@Module(includes = BaseActivityModule.class)
public abstract class Example2ActivityModule {

    /**
     * Provides the injector for the {@link Example2AFragment}, which has access to the dependencies
     * provided by this activity and application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = Example2AFragmentModule.class)
    abstract Example2AFragment example2AFragmentInjector();

    /**
     * Provides the injector for the {@link Example2BFragment}, which has access to the dependencies
     * provided by this activity and application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = Example2BFragmentModule.class)
    abstract Example2BFragment example2BFragmentInjector();

    /**
     * As per the contract specified in {@link BaseActivityModule}; "This must be included in all
     * activity modules, which must provide a concrete implementation of {@link Activity}."
     * <p>
     * This provides the activity required to inject the
     * {@link BaseActivityModule#ACTIVITY_FRAGMENT_MANAGER} into the
     * {@link com.vestrel00.daggerbutterknifemvp.ui.common.BaseActivity}.
     *
     * @param example2Activity the example 2 activity
     * @return the activity
     */
    @Binds
    @PerActivity
    abstract Activity activity(Example2Activity example2Activity);
}
