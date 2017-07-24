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

package com.vestrel00.daggerbutterknifemvp.ui.example_3;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.vestrel00.daggerbutterknifemvp.R;
import com.vestrel00.daggerbutterknifemvp.ui.common.BaseActivity;
import com.vestrel00.daggerbutterknifemvp.ui.example_3.parent_fragment.Example3ParentFragment;

/**
 * Activity that contains a single fragment that contains a child fragment.
 */
public final class Example3Activity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_3_activity);

        if (savedInstanceState == null) {
            addFragment(R.id.parent_fragment_container, new Example3ParentFragment());
        }
    }
}
