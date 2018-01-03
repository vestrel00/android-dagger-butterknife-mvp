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

package com.vestrel00.daggerbutterknifemvp.ui.main.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vestrel00.daggerbutterknifemvp.R;
import com.vestrel00.daggerbutterknifemvp.ui.common.view.BaseFragment;

import javax.inject.Inject;

import butterknife.OnClick;

/**
 * Displays a set of buttons for the other activities.
 * <p>
 * <b>NOTE</b>
 * This fragment does not implement a view and host a presenter because there is no logic that
 * is done here. This fragment simply notifies the host Activity of the button click events that
 * occur.
 * <p>
 * With that said, this does not implement and MVPView interface nor does it extend
 * BaseViewFragment.
 * <p>
 * So why not just put the layout of this fragment into the Activity itself? We could do that but
 * we would lose the ability to reuse this fragment along with other fragments in different
 * activities if we wanted to (not that we would).
 * <p>
 * The activity only acts as the host to 1 or more fragments for inter-fragment communication. All
 * views and logic are in fragments.
 */
public final class MainFragment extends BaseFragment {

    @Inject
    MainFragmentListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @OnClick(R.id.example_1)
    void onExample1Clicked() {
        listener.onExample1Clicked();
    }

    @OnClick(R.id.example_2)
    void onExample2Clicked() {
        listener.onExample2Clicked();
    }

    @OnClick(R.id.example_3)
    void onExample3Clicked() {
        listener.onExample3Clicked();
    }

    @OnClick(R.id.example_4)
    void onExample4Clicked() {
        listener.onExample4Clicked();
    }

    @OnClick(R.id.example_5)
    void onExample5Clicked() {
        listener.onExample5Clicked();
    }
}
