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

package com.vestrel00.daggerbutterknifemvp.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.vestrel00.daggerbutterknifemvp.R;
import com.vestrel00.daggerbutterknifemvp.ui.common.BaseActivity;

/**
 * The main activity that provides a way to navigate to all other activities.
 */
public final class MainActivity extends BaseActivity implements MainFragmentListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, new MainFragment());
        }
    }

    @Override
    public void onExample1Clicked() {
        navigator.toExample1(this);
    }

    @Override
    public void onExample2Clicked() {
        navigator.toExample2(this);
    }

    @Override
    public void onExample3Clicked() {
        navigator.toExample3(this);
    }
}
