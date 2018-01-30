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

package com.vestrel00.daggerbutterknifemvp.ui.example_2

import android.os.Bundle
import com.vestrel00.daggerbutterknifemvp.R
import com.vestrel00.daggerbutterknifemvp.ui.common.BaseActivity
import com.vestrel00.daggerbutterknifemvp.ui.example_2.fragment_a.view.Example2AFragment
import com.vestrel00.daggerbutterknifemvp.ui.example_2.fragment_b.view.Example2BFragment

/**
 * Activity that contains 2 Fragments.
 */
class Example2Activity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.example_2_activity)

        if (savedInstanceState == null) {
            addFragment(R.id.fragment_a_container, Example2AFragment())
            addFragment(R.id.fragment_b_container, Example2BFragment())
        }
    }
}