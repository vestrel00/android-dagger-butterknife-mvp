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

package com.vestrel00.daggerbutterknifemvp.ui.example_1.fragment.view

import android.support.v4.app.Fragment
import com.vestrel00.daggerbutterknifemvp.inject.PerFragment
import com.vestrel00.daggerbutterknifemvp.ui.common.view.BaseFragmentModule
import com.vestrel00.daggerbutterknifemvp.ui.example_1.fragment.presenter.Example1PresenterModule
import dagger.Binds
import dagger.Module
import javax.inject.Named

/**
 * Provides example 1 fragment dependencies.
 */
@Module(includes = [
    BaseFragmentModule::class,
    Example1PresenterModule::class
])
abstract class Example1FragmentModule {

    /**
     * As per the contract specified in [BaseFragmentModule]; "This must be included in all
     * fragment modules, which must provide a concrete implementation of [Fragment]
     * and named [BaseFragmentModule.FRAGMENT].
     *
     * @param example1Fragment the example 1 fragment
     * @return the fragment
     */
    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract fun fragment(example1Fragment: Example1Fragment): Fragment

    @Binds
    @PerFragment
    abstract fun example1View(example1Fragment: Example1Fragment): Example1View
}
