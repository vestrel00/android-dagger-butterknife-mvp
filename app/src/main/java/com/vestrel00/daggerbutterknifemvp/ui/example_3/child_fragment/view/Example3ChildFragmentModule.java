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

package com.vestrel00.daggerbutterknifemvp.ui.example_3.child_fragment.view;

import android.app.Fragment;

import com.vestrel00.daggerbutterknifemvp.inject.PerChildFragment;
import com.vestrel00.daggerbutterknifemvp.ui.common.view.BaseChildFragmentModule;
import com.vestrel00.daggerbutterknifemvp.ui.example_3.child_fragment.presenter.Example3ChildPresenterModule;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

/**
 * Provides example 3 child fragment dependencies.
 */
@Module(includes = {
        BaseChildFragmentModule.class,
        Example3ChildPresenterModule.class
})
public abstract class Example3ChildFragmentModule {

    /**
     * As per the contract specified in {@link BaseChildFragmentModule}; "This must be included in
     * all child fragment modules, which must provide a concrete implementation of the child
     * {@link Fragment} and named {@link BaseChildFragmentModule#CHILD_FRAGMENT}..
     *
     * @param example3ChildFragment the example 3 child fragment
     * @return the fragment
     */
    @Binds
    @Named(BaseChildFragmentModule.CHILD_FRAGMENT)
    @PerChildFragment
    abstract Fragment fragment(Example3ChildFragment example3ChildFragment);

    @Binds
    @PerChildFragment
    abstract Example3ChildView example3ChildView(Example3ChildFragment example3ChildFragment);
}
