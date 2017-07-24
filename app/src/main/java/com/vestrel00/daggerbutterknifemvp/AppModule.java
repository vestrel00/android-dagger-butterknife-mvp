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

import android.app.Activity;

import com.vestrel00.daggerbutterknifemvp.ui.example_1.Example1Activity;
import com.vestrel00.daggerbutterknifemvp.ui.example_1.Example1ActivitySubcomponent;
import com.vestrel00.daggerbutterknifemvp.ui.main.MainActivity;
import com.vestrel00.daggerbutterknifemvp.ui.main.MainActivitySubcomponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Provides application-wide dependencies.
 */
@Module(includes = AndroidInjectionModule.class,
        subcomponents = {
                MainActivitySubcomponent.class,
                Example1ActivitySubcomponent.class
        })
abstract class AppModule {

    /**
     * Provides the injector for the {@link MainActivity}, which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    // TODO (ContributesAndroidInjector) remove this in favor of @ContributesAndroidInjector
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    mainActivityInjectorFactory(MainActivitySubcomponent.Builder builder);


    /**
     * Provides the injector for the {@link Example1Activity}, which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    // TODO (ContributesAndroidInjector) remove this in favor of @ContributesAndroidInjector
    @Binds
    @IntoMap
    @ActivityKey(Example1Activity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    example1ActivityInjectorFactory(Example1ActivitySubcomponent.Builder builder);
}