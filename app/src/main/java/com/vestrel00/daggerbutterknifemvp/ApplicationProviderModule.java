package com.vestrel00.daggerbutterknifemvp;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provides a reference to the {@link Application}. The {@link Application} is not provided in the
 * {@link AppModule} because it needs to remain abstract to maintain its abstract injector methods.
 * <p>
 * Providing the reference to the {@link Application} is used for providing the Application
 * {@link android.content.Context} instead of the Activity context to {@link Singleton}
 * dependencies. For example, a third party library like Picasso requires the Application context
 * in order to instantiate a unique instance.
 * <p>
 * This is required as of Dagger 2.11 in order to provide the {@link Application} instance.
 * <p>
 * FIXME: Check if future versions of Dagger gets rid of the need to for this module.
 */
@Module
class ApplicationProviderModule {

    private final Application application;

    ApplicationProviderModule(Application application) {
        this.application = application;
    }

    /**
     * Returns the {@link Application} type instead of {@link android.content.Context} to avoid
     * type collision with the Activity's context. Another way to resolve the context type collision
     * is to use different {@link javax.inject.Named} values for the Application and Activity
     * context. However, just providing the Application type is simpler and lighter in weight.
     *
     * @return the {@link Application} instance
     */
    @Provides
    @Singleton
    Application application() {
        // Does not need to be annotated with @Singleton since it returns the same instance.
        // It is only annotated with @Singleton to honor convention.
        return application;
    }
}
