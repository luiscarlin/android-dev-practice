package com.luchoc.diquarantine;

import android.app.Application;

/**
 * This application is instantiated before any activities
 */

public class MainApplication extends Application {
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // start the component. Note that DaggerAppComponent is a class created by Dagger after processing
        // the AppComponent class
        mAppComponent = DaggerAppComponent.builder().build();
    }

    // exposes the component
    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
