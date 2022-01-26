package com.alaaclips.projectgir1;

import android.widget.TextView;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class MokeTest {


    TextView mockedTextView;

    @Test
    public void test_TextView() {

        mockedTextView = mock(TextView.class);
        mockedTextView.setText("test");
        System.out.println(mockedTextView.getText());

        verify(mockedTextView).setText("test");
        verify(mockedTextView,times(1)).setText("test");
    }

    @Test
    public void test_TextView2() {

        mockedTextView = mock(TextView.class);
        when(mockedTextView.getText()).thenReturn("test");
        System.out.println(mockedTextView.getText());

        // doReturn("test").when(mockedTextView).getText();

        /*
        doThrow(new RuntimeException()).when(mockedTextView).setText("abc");
        when(mockedTextView.getText()).thenThrow(new RuntimeException());
         */
    }


}
