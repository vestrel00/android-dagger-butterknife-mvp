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

package com.vestrel00.daggerbutterknifemvp.ui.example_3.parent_fragment.view

import android.support.v4.app.Fragment
import com.vestrel00.daggerbutterknifemvp.inject.PerChildFragment
import com.vestrel00.daggerbutterknifemvp.inject.PerFragment
import com.vestrel00.daggerbutterknifemvp.ui.common.view.BaseFragmentModule
import com.vestrel00.daggerbutterknifemvp.ui.example_3.child_fragment.view.Example3ChildFragment
import com.vestrel00.daggerbutterknifemvp.ui.example_3.child_fragment.view.Example3ChildFragmentModule
import com.vestrel00.daggerbutterknifemvp.ui.example_3.parent_fragment.presenter.Example3ParentPresenterModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Named

/**
 * Provides example 3 parent fragment dependencies.
 */
@Module(includes = [
    BaseFragmentModule::class,
    Example3ParentPresenterModule::class
])
abstract class Example3ParentFragmentModule {

    /**
     * Provides the injector for the [Example3ChildFragment], which has access to the
     * dependencies provided by this fragment and activity and application instance
     * (singleton scoped objects).
     */
    @PerChildFragment
    @ContributesAndroidInjector(modules = [Example3ChildFragmentModule::class])
    abstract fun example3ChildFragmentInjector(): Example3ChildFragment

    /**
     * As per the contract specified in [BaseFragmentModule]; "This must be included in all
     * fragment modules, which must provide a concrete implementation of [Fragment]
     * and named [BaseFragmentModule.FRAGMENT].
     *
     * @param example3ParentFragment the example 3 parent fragment
     * @return the fragment
     */
    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract fun fragment(example3ParentFragment: Example3ParentFragment): Fragment

    @Binds
    @PerFragment
    abstract fun example3ParentView(example3ParentFragment: Example3ParentFragment):
            Example3ParentView
}
