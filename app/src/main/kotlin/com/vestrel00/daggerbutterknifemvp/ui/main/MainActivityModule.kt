/*
 * Copyright 2018 Vandolf Estrellado
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

package com.vestrel00.daggerbutterknifemvp.ui.main

import android.app.Activity
import com.vestrel00.daggerbutterknifemvp.inject.PerActivity
import com.vestrel00.daggerbutterknifemvp.inject.PerFragment
import com.vestrel00.daggerbutterknifemvp.ui.common.BaseActivityModule
import com.vestrel00.daggerbutterknifemvp.ui.example_1.fragment.view.Example1Fragment
import com.vestrel00.daggerbutterknifemvp.ui.example_1.fragment.view.Example1FragmentModule
import com.vestrel00.daggerbutterknifemvp.ui.example_3.parent_fragment.view.Example3ParentFragment
import com.vestrel00.daggerbutterknifemvp.ui.example_3.parent_fragment.view.Example3ParentFragmentModule
import com.vestrel00.daggerbutterknifemvp.ui.main.view.MainFragment
import com.vestrel00.daggerbutterknifemvp.ui.main.view.MainFragmentListener
import com.vestrel00.daggerbutterknifemvp.ui.main.view.MainFragmentModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Provides main activity dependencies.
 */
@Module(includes = [BaseActivityModule::class])
abstract class MainActivityModule {

    /**
     * Provides the injector for the [MainFragment], which has access to the dependencies
     * provided by this activity and application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun mainFragmentInjector(): MainFragment

    /**
     * Provides the injector for the [Example1Fragment], which has access to the dependencies
     * provided by this activity and application instance (singleton scoped objects).
     *
     * This is used for example 4, which displays [Example1Fragment] as a
     * [android.app.DialogFragment].
     */
    @PerFragment
    @ContributesAndroidInjector(modules = [Example1FragmentModule::class])
    abstract fun example1FragmentInjector(): Example1Fragment

    /**
     * Provides the injector for the [Example3ParentFragment], which has access to the
     * dependencies provided by this activity and application instance (singleton scoped objects).
     *
     * This is used for example 5, which displays [Example3ParentFragment] as a
     * [android.app.DialogFragment].
     */
    @PerFragment
    @ContributesAndroidInjector(modules = [Example3ParentFragmentModule::class])
    abstract fun example3ParentFragmentInjector(): Example3ParentFragment

    /**
     * As per the contract specified in [BaseActivityModule]; "This must be included in all
     * activity modules, which must provide a concrete implementation of [Activity]."
     *
     * @param mainActivity the activity
     * @return the activity
     */
    @Binds
    @PerActivity
    abstract fun activity(mainActivity: MainActivity): Activity

    /**
     * The main activity listens to the events in the [MainFragment].
     *
     * @param mainActivity the activity
     * @return the main fragment listener
     */
    @Binds
    @PerActivity
    abstract fun mainFragmentListener(mainActivity: MainActivity): MainFragmentListener
}