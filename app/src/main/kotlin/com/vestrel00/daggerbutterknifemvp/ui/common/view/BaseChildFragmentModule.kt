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

package com.vestrel00.daggerbutterknifemvp.ui.common.view

import dagger.Module

/**
 * Provides base fragment dependencies. This must be included in all child fragment modules, which
 * must provide a concrete implementation of the child [android.app.Fragment] and named
 * [CHILD_FRAGMENT].
 *
 * Note that a different [javax.inject.Named] for the [android.app.Fragment] is required in order to
 * remove any ambiguity about which fragment is being provided in a child fragment. For example,
 * we have parent fragment P and child fragment C. Parent fragment P will provide the Fragment
 * reference using the [BaseFragmentModule.FRAGMENT] name. Child fragment C will provide the
 * Fragment reference using the [CHILD_FRAGMENT] name.
 *
 * If the parent and child fragments are not uniquely named, then the child fragment and its
 * dependencies will not know which Fragment is provided to it. It could be the parent fragment
 * or the child fragment. Hence the ambiguity, which causes a compile error of
 * "android.app.Fragment is bound multiple times".
 */
@Module
abstract class BaseChildFragmentModule {

    companion object {
        /**
         * See class documentation regarding the need for this name.
         */
        const val CHILD_FRAGMENT = "BaseChildFragmentModule.childFragment"
    }
}