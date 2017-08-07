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

package com.vestrel00.daggerbutterknifemvp;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;

/**
 * Injects application dependencies.
 */
@Singleton
@Component(modules = AppModule.class)
interface AppComponent extends AndroidInjector<App> {
    /**
     * The builder for this component that allows the {@link Application} instance to be provided.
     * Providing the {@link Application} instance in the {@link AppModule} using and abstract
     * {@link dagger.Binds} method does not work.
     */
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }
}