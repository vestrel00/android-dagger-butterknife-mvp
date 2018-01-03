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

package com.vestrel00.daggerbutterknifemvp.util;

import android.app.Activity;

import com.vestrel00.daggerbutterknifemvp.inject.PerActivity;

import javax.inject.Inject;

/**
 * A class that does something.
 * <p>
 * This class has the {@link PerActivity} scope. This means that the Activity and all of its
 * Fragments and child fragments and their dependencies will share the same instance of this class.
 * However, different activity instances will have their own instances.
 * <p>
 * This is not available at the Application.
 */
@PerActivity
public final class PerActivityUtil {

    private final Activity activity;

    @Inject
    PerActivityUtil(Activity activity) {
        this.activity = activity;
    }

    /**
     * @return the result of the work done here as a string. For this example, this returns its
     * {@link #hashCode()} and the activity's {@link #hashCode()}.
     */
    public String doSomething() {
        return "PerActivityUtil: " + hashCode() + ", Activity: " + activity.hashCode();
    }
}
