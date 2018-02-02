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

package com.vestrel00.daggerbutterknifemvp.ui.common

import android.app.Activity
import android.app.FragmentManager
import android.content.Context
import com.vestrel00.daggerbutterknifemvp.inject.PerActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Provides base activity dependencies. This must be included in all activity modules, which must
 * provide a concrete implementation of [Activity].
 */
@Module
abstract class BaseActivityModule {

    @Module
    companion object {
        /*
         * Note that this is currently unused in this Kotlin project. However, it is used in the
         * Java branch of this project. We'll keep this private to avoid lint warnings until other
         * Kotlin classes needs it.
         */
        private const val ACTIVITY_FRAGMENT_MANAGER = "BaseActivityModule.activityFragmentManager"

        /*
         * This is a valid way to declare static provides methods.
         * See https://github.com/google/dagger/issues/900#issuecomment-337043187
         */
        @JvmStatic
        @Provides
        @Named(ACTIVITY_FRAGMENT_MANAGER)
        @PerActivity
        fun activityFragmentManager(activity: Activity): FragmentManager = activity.fragmentManager
    }

    @Binds
    @PerActivity
    /*
     * PerActivity annotation isn't necessary since Activity instance is unique but is here for
     * convention. In general, providing Application, Activity, Fragment, BroadcastReceiver,
     * etc does not require scoped annotations since they are the components being injected and
     * their instance is unique.
     *
     * However, having a scope annotation makes the module easier to read. We wouldn't have to look
     * at what is being provided in order to understand its scope.
     */
    abstract fun activityContext(activity: Activity): Context
}