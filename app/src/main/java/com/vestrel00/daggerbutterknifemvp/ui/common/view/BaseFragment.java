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

package com.vestrel00.daggerbutterknifemvp.ui.common.view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;

/**
 * Abstract Fragment for all Fragments and child Fragments to extend. This contains some boilerplate
 * dependency injection code and activity {@link Context}.
 * <p>
 * <b>DEPENDENCY INJECTION</b>
 * We could extend {@link dagger.android.DaggerFragment} so we can get the boilerplate
 * dagger code for free. However, we want to avoid inheritance (if possible and it is in this case)
 * so that we have to option to inherit from something else later on if needed.
 * <p>
 * <b>VIEW BINDING</b>
 * This fragment handles view bind and unbinding.
 */
public abstract class BaseFragment extends Fragment implements HasFragmentInjector {

    @Inject
    protected Context activityContext;

    // Note that this should not be used within a child fragment.
    @Inject
    @Named(BaseFragmentModule.CHILD_FRAGMENT_MANAGER)
    protected FragmentManager childFragmentManager;

    @Inject
    DispatchingAndroidInjector<Fragment> childFragmentInjector;

    private Unbinder viewUnbinder;

    @Override
    public void onAttach(Context context) {
        AndroidInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        View view = getView();
        if (view != null) {
            /*
             * Bind the views here instead of in onViewCreated so that view state changed listeners
             * are not invoked automatically without user interaction.
             *
             * If we bind before this method (e.g. onViewCreated), then any checked changed
             * listeners bound by ButterKnife will be invoked during fragment recreation.
             *
             * The lifecycle order is as follows (same if added via xml or java
             * or if retain instance is true):
             *
             * onAttach
             * onCreateView
             * onActivityCreated
             * onViewStateRestored
             * onResume
             */
            viewUnbinder = ButterKnife.bind(this, view);
        }
    }

    @Override
    public void onDestroyView() {
        if (viewUnbinder != null) {
            viewUnbinder.unbind();
        }
        super.onDestroyView();
    }

    @Override
    public final AndroidInjector<Fragment> fragmentInjector() {
        return childFragmentInjector;
    }

    protected final void addChildFragment(int containerViewId, Fragment fragment) {
        childFragmentManager.beginTransaction()
                .add(containerViewId, fragment)
                .commit();
    }
}