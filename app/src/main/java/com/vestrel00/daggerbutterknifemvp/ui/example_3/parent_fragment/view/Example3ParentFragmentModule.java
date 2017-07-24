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

package com.vestrel00.daggerbutterknifemvp.ui.example_3.parent_fragment.view;

import android.app.Fragment;

import com.vestrel00.daggerbutterknifemvp.inject.PerChildFragment;
import com.vestrel00.daggerbutterknifemvp.inject.PerFragment;
import com.vestrel00.daggerbutterknifemvp.ui.common.view.BaseFragmentModule;
import com.vestrel00.daggerbutterknifemvp.ui.example_3.child_fragment.view.Example3ChildFragment;
import com.vestrel00.daggerbutterknifemvp.ui.example_3.child_fragment.view.Example3ChildFragmentModule;
import com.vestrel00.daggerbutterknifemvp.ui.example_3.parent_fragment.presenter.Example3ParentPresenterModule;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Provides example 3 parent fragment dependencies.
 */
@Module(includes = {
        BaseFragmentModule.class,
        Example3ParentPresenterModule.class
})
public abstract class Example3ParentFragmentModule {

    /**
     * Provides the injector for the {@link Example3ChildFragment}, which has access to the
     * dependencies provided by this fragment and activity and application instance
     * (singleton scoped objects).
     */
    @PerChildFragment
    @ContributesAndroidInjector(modules = Example3ChildFragmentModule.class)
    abstract Example3ChildFragment example3ChildFragmentInjector();

    /**
     * As per the contract specified in {@link BaseFragmentModule}; "This must be included in all
     * fragment modules, which must provide a concrete implementation of {@link Fragment}
     * and named {@link BaseFragmentModule#FRAGMENT}.
     *
     * @param example3ParentFragment the example 3 parent fragment
     * @return the fragment
     */
    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract Fragment fragment(Example3ParentFragment example3ParentFragment);

    @Binds
    @PerFragment
    abstract Example3ParentView example3ParentView(Example3ParentFragment example3ParentFragment);
}
