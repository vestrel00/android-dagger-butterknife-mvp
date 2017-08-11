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

import com.vestrel00.daggerbutterknifemvp.inject.PerActivity;
import com.vestrel00.daggerbutterknifemvp.ui.example_1.Example1Activity;
import com.vestrel00.daggerbutterknifemvp.ui.example_1.Example1ActivityModule;
import com.vestrel00.daggerbutterknifemvp.ui.example_2.Example2Activity;
import com.vestrel00.daggerbutterknifemvp.ui.example_2.Example2ActivityModule;
import com.vestrel00.daggerbutterknifemvp.ui.example_3.Example3Activity;
import com.vestrel00.daggerbutterknifemvp.ui.example_3.Example3ActivityModule;
import com.vestrel00.daggerbutterknifemvp.ui.main.MainActivity;
import com.vestrel00.daggerbutterknifemvp.ui.main.MainActivityModule;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

/**
 * Provides application-wide dependencies.
 */
@Module(includes = AndroidInjectionModule.class)
abstract class AppModule {

    @Binds
    @Singleton
    /*
     * Singleton annotation isn't necessary since Application instance is unique but is here for
     * convention. In general, providing Activity, Fragment, BroadcastReceiver, etc does not require
     * them to be scoped since they are the components being injected and their instance is unique.
     *
     * However, having a scope annotation makes the module easier to read. We wouldn't have to look
     * at what is being provided in order to understand its scope.
     */
    abstract Application application(App app);

    /**
     * Provides the injector for the {@link MainActivity}, which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerActivity
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivityInjector();

    /**
     * Provides the injector for the {@link Example1Activity}, which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerActivity
    @ContributesAndroidInjector(modules = Example1ActivityModule.class)
    abstract Example1Activity example1ActivityInjector();

    /**
     * Provides the injector for the {@link Example2Activity}, which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerActivity
    @ContributesAndroidInjector(modules = Example2ActivityModule.class)
    abstract Example2Activity example2ActivityInjector();

    /**
     * Provides the injector for the {@link Example3Activity}, which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerActivity
    @ContributesAndroidInjector(modules = Example3ActivityModule.class)
    abstract Example3Activity example3ActivityInjector();
}