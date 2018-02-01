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

package com.vestrel00.daggerbutterknifemvp.util

import android.support.v4.app.Fragment
import com.vestrel00.daggerbutterknifemvp.inject.PerChildFragment
import com.vestrel00.daggerbutterknifemvp.ui.common.view.BaseChildFragmentModule
import javax.inject.Inject
import javax.inject.Named

/**
 * A class that does something.
 *
 * This class has the [PerChildFragment] scope. This means that the child Fragment (a fragment
 * inside a fragment that is added using Fragment.getChildFragmentManager()) and all of its
 * dependencies will share the same instance of this class. However, different child fragments
 * instances will have their own instances of this class.
 *
 * This is not available at the parent Fragment, Activity, and Application.
 */
@PerChildFragment
class PerChildFragmentUtil @Inject constructor(@param:Named(BaseChildFragmentModule.CHILD_FRAGMENT)
                                               private val childFragment: Fragment) {

    /**
     * @return the result of the work done here as a string. For this example, this returns its
     * [hashCode] and the child fragment's [hashCode].
     */
    fun doSomething(): String = "PerChildFragmentUtil: " + hashCode() +
            ", child Fragment: " + childFragment.hashCode()
}
