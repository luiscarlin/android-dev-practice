package com.luchoc.quarantine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityImplTest {

    @Mock
    MainActivityQtn qtn;

    @Test
    public void renders_activity_main_on_create() {
        MainActivityImpl impl = new MainActivityImpl(qtn);
        impl.onCreate();
        verify(qtn, times(1)).setContentView(R.layout.activity_main);
    }
}
