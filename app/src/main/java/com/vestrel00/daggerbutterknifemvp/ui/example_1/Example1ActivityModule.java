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

import android.app.Activity;
import android.app.Fragment;

import com.vestrel00.daggerbutterknifemvp.inject.PerActivity;
import com.vestrel00.daggerbutterknifemvp.ui.common.BaseActivityModule;
import com.vestrel00.daggerbutterknifemvp.ui.example_1.fragment.Example1Fragment;
import com.vestrel00.daggerbutterknifemvp.ui.example_1.fragment.Example1FragmentSubcomponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Provides example 1 activity dependencies.
 */
@Module(includes = BaseActivityModule.class,
        subcomponents = Example1FragmentSubcomponent.class)
abstract class Example1ActivityModule {

    /**
     * Provides the injector for the {@link Example1Fragment}, which has access to the dependencies
     * provided by this activity and application instance (singleton scoped objects).
     */
    // TODO (ContributesAndroidInjector) remove this in favor of @ContributesAndroidInjector
    @Binds
    @IntoMap
    @FragmentKey(Example1Fragment.class)
    abstract AndroidInjector.Factory<? extends Fragment>
    example1FragmentInjectorFactory(Example1FragmentSubcomponent.Builder builder);

    /**
     * As per the contract specified in {@link BaseActivityModule}; "This must be included in all
     * activity modules, which must rovide a concrete implementation of {@link Activity}."
     * <p>
     * This provides the activity required to inject the
     * {@link BaseActivityModule#ACTIVITY_FRAGMENT_MANAGER} into the
     * {@link com.vestrel00.daggerbutterknifemvp.ui.common.BaseActivity}.
     *
     * @param example1Activity the example 1 activity
     * @return the activity
     */
    @Binds
    @PerActivity
    abstract Activity activity(Example1Activity example1Activity);
}
