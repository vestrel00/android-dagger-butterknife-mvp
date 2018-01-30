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

package com.vestrel00.daggerbutterknifemvp.ui.example_3.parent_fragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import com.vestrel00.daggerbutterknifemvp.R
import com.vestrel00.daggerbutterknifemvp.ui.common.view.BaseViewFragment
import com.vestrel00.daggerbutterknifemvp.ui.example_3.child_fragment.view.Example3ChildFragment
import com.vestrel00.daggerbutterknifemvp.ui.example_3.parent_fragment.presenter.Example3ParentPresenter

/**
 * A fragment implementation of [Example3ParentView].
 */
class Example3ParentFragment : BaseViewFragment<Example3ParentPresenter>(), Example3ParentView {

    @BindView(R.id.some_text)
    lateinit var someText: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.example_3_parent_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            addChildFragment(R.id.child_fragment_container, Example3ChildFragment())
        }
    }

    override fun showSomething(something: String) {
        someText.text = something
    }

    @OnClick(R.id.do_something)
    fun onDoSomethingClicked() = presenter.onDoSomething()
}