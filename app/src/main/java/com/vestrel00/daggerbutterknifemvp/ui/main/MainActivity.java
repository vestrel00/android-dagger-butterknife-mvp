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

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.vestrel00.daggerbutterknifemvp.R;
import com.vestrel00.daggerbutterknifemvp.ui.common.BaseActivity;
import com.vestrel00.daggerbutterknifemvp.ui.example_1.Example1Activity;
import com.vestrel00.daggerbutterknifemvp.ui.example_2.Example2Activity;

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
        Intent intent = new Intent(this, Example1Activity.class);
        startActivity(intent);
    }

    @Override
    public void onExample2Clicked() {
        Intent intent = new Intent(this, Example2Activity.class);
        startActivity(intent);
    }

    @Override
    public void onExample3Clicked() {
        // TODO start example 3 activity
        Toast.makeText(this, "Launch example 3", Toast.LENGTH_SHORT).show();
    }
}
