package com.luchoc.diquarantine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

public class MainActivityQtn extends AppCompatActivity {

    // by injecting this member, dagger injects any MainActivityImpl dependencies (defined in MainActivityImpl.java) into impl
    @Inject MainActivityImpl impl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // creates the dagger dependency graph and injects members into this file
        ((MainApplication) getApplication()).getAppComponent().inject(this);

        // continue doing the rest
        impl.onCreate(this);
    }
}
