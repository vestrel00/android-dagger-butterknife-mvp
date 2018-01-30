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

package com.vestrel00.daggerbutterknifemvp.ui.example_2.fragment_b.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import com.vestrel00.daggerbutterknifemvp.R
import com.vestrel00.daggerbutterknifemvp.ui.common.view.BaseViewFragment
import com.vestrel00.daggerbutterknifemvp.ui.example_2.fragment_b.presenter.Example2BPresenter

/**
 * A fragment implementation of [Example2BView].
 */
class Example2BFragment : BaseViewFragment<Example2BPresenter>(), Example2BView {

    @BindView(R.id.some_text)
    lateinit var someText: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.example_2_fragment_b, container, false)

    override fun showSomething(something: String) {
        someText.text = something
    }

    @OnClick(R.id.do_something)
    fun onDoSomethingClicked() = presenter.onDoSomething()
}