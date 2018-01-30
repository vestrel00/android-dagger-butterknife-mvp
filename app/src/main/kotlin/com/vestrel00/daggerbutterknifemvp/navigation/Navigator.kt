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

package com.vestrel00.daggerbutterknifemvp.navigation

import android.content.Context
import android.content.Intent
import com.vestrel00.daggerbutterknifemvp.ui.example_1.Example1Activity
import com.vestrel00.daggerbutterknifemvp.ui.example_2.Example2Activity
import com.vestrel00.daggerbutterknifemvp.ui.example_3.Example3Activity
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Provides methods to navigate to the different activities in the application.
 */
@Singleton
class Navigator @Inject constructor() {

    fun toExample1(context: Context) {
        val intent = Intent(context, Example1Activity::class.java)
        context.startActivity(intent)
    }

    fun toExample2(context: Context) {
        val intent = Intent(context, Example2Activity::class.java)
        context.startActivity(intent)
    }

    fun toExample3(context: Context) {
        val intent = Intent(context, Example3Activity::class.java)
        context.startActivity(intent)
    }
}
