package com.luchoc.diquarantine;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component
public interface AppComponent {

    // only inject on quarantines
    void inject(MainActivityQtn activity);
}