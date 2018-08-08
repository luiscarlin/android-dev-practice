package com.luchoc.diquarantine;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MainActivityImpl {

    @Inject
    public MainActivityImpl() {
    }

    public void onCreate(MainActivityQtn qtn) {
        qtn.setContentView(R.layout.activity_main);
    }
}
