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

package com.vestrel00.daggerbutterknifemvp.ui.example_3.parent_fragment.presenter

import com.vestrel00.daggerbutterknifemvp.inject.PerFragment
import com.vestrel00.daggerbutterknifemvp.ui.common.presenter.BasePresenter
import com.vestrel00.daggerbutterknifemvp.ui.example_3.parent_fragment.view.Example3ParentView
import com.vestrel00.daggerbutterknifemvp.util.PerActivityUtil
import com.vestrel00.daggerbutterknifemvp.util.PerFragmentUtil
import com.vestrel00.daggerbutterknifemvp.util.SingletonUtil
import javax.inject.Inject

/**
 * An implementation of [Example3ParentPresenter].
 */
@PerFragment
class Example3ParentPresenterImpl @Inject constructor(
        view: Example3ParentView,
        private val singletonUtil: SingletonUtil,
        private val perActivityUtil: PerActivityUtil,
        private val perFragmentUtil: PerFragmentUtil
) : BasePresenter<Example3ParentView>(view), Example3ParentPresenter {

    // We can use the delegation pattern here (or inheritance or composition). However, we don't
    // for the sake of this example and parody with the Java branch.
    override fun onDoSomething() {
        // Do something here. Maybe make an asynchronous call to fetch data...
        // We should refactor and make `something` a val (immutable) instead of a var, which is
        // better because we should make something immutable if we can. However, we don't for the
        // sake of this example and parody with the Java branch.
        var something = singletonUtil.doSomething()
        something += "\n" + perActivityUtil.doSomething()
        something += "\n" + perFragmentUtil.doSomething()
        view.showSomething(something)
    }
}