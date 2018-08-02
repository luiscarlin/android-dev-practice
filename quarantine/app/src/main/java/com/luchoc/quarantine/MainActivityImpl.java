package com.luchoc.quarantine;


/**
 * - This code should be fully testable
 * - Any Android functionality that cannot be mocked belongs in quarantine
 */

public class MainActivityImpl {

    MainActivityQtn qtn;

    MainActivityImpl(MainActivityQtn qtn) {
        this.qtn = qtn;
    }

    public void onCreate() {
        qtn.setContentView(R.layout.activity_main);
    }
}
