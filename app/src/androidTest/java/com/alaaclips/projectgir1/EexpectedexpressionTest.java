package com.alaaclips.projectgir1;


import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.alaaclips.projectgir1.db.DatabaseHelpers;
import com.alaaclips.projectgir1.model.Volting;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class EexpectedexpressionTest {

    DatabaseHelpers db;




    @Test(expected =Exception.class)
    public void testExpectation() {

        Context appContext = InstrumentationRegistry.getInstrumentation().getContext();
        //logInActivity  = new LogInActivity();
        db = new DatabaseHelpers(appContext);

        assertEquals(true,db.getALLVoltingUser().size()!=-1);
    }

    @Test(expected =Exception.class)
    public void sacendtestExpectedasiptioin() {

        Context appContext = InstrumentationRegistry.getInstrumentation().getContext();
        //logInActivity  = new LogInActivity();
        db = new DatabaseHelpers(appContext);

        assertEquals(true,db.getallUser().size()!=-1);
    }




}
