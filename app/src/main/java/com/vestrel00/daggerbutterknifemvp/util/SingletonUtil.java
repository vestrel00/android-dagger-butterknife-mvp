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

package com.vestrel00.daggerbutterknifemvp.util;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * A class that does something.
 * <p>
 * This class has the {@link Singleton} scope. This means that the {@link android.app.Application}
 * and all {@link android.app.Activity}s, {@link android.app.Fragment}s, and child fragments and
 * their dependencies will share the same instance of this class.
 */
@Singleton
public final class SingletonUtil {

    @Inject
    SingletonUtil() {
    }

    /**
     * @return the result of the work done here as a string. For this example, this returns its
     * {@link #hashCode()}.
     */
    public String doSomething() {
        return "SingletonUtil: " + hashCode();
    }
}
