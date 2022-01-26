package com.alaaclips.projectgir1;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.alaaclips.projectgir1.db.DatabaseHelpers;
import com.alaaclips.projectgir1.model.Users;
import com.alaaclips.projectgir1.model.Volting;
import com.alaaclips.projectgir1.model.VotingList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.runners.Parameterized;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class parametrizedTest {


    static DatabaseHelpers db;
    String input;
    String expextedresulte;

//@BeforeClass
//public void afterClaa() {
//
//
//}



  //  @AfterClass
    //public void afterClaa() {
//
//
//}



    @Before
    public void beforeDB() {

        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        //logInActivity  = new LogInActivity();
        db = new DatabaseHelpers(appContext);
    }

    public parametrizedTest(String input,String expextedresulte){
        this.input=input;
        this.expextedresulte=expextedresulte;
    }



    @Parameterized.Parameters
    public static Collection parame() {
        return Arrays.asList(new Object[][]{
                {"uuee51014@gmail.com","uuee51014@gmail.com"},
                {"uuee51014@gmail.com","uuee51014@gmail.com"},
                {"uuee51014@gmail.com","uuee51014@gmail.com"},
                {"uuee51014@gmail.com","uuee51014@gmail.com"},

        });
    }


    @Test
    public void useAppContext() {

        Volting UserVoltinguseingemaile = db.getVoltingUser(input);
        System.out.println(input);
        assertEquals(expextedresulte, UserVoltinguseingemaile.getEmailevolting());
    }


}
