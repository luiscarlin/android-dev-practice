package com.luchoc.quarantine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivityQtn extends AppCompatActivity {

    MainActivityImpl impl;

    MainActivityQtn() {
        impl = new MainActivityImpl(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        impl.onCreate();
    }
}
