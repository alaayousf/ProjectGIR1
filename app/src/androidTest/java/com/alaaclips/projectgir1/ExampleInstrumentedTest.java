package com.alaaclips.projectgir1;

import android.content.Context;
import android.graphics.Bitmap;

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


import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

  static  DatabaseHelpers db;
    ArrayList<Users> listUser;




    @Before public void beforeDB() {

        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        //logInActivity  = new LogInActivity();
        db = new DatabaseHelpers(appContext);



    }


//    @BeforeClass public void beforeclasseDB() {
//
//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        logInActivity  = new LogInActivity();
//
//    }




    @After public void aftereDB() {

    }

//    @AfterClass public void aftereClassDB() {
//
//    }


    @Test
    public void useAppContext() {
//
//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        assertEquals("com.alaaclips.projectgir1", appContext.getPackageName());

        Volting UserVoltinguseingemaile= db.getVoltingUser("uuee51014@gmail.com");

        assertEquals("uuee51014@gmail.com",UserVoltinguseingemaile.getEmailevolting());
    }


//    @Test(expected = Exception.class)

    @Test
    public void testWithNetwork() {

        VotingList list3 = new VotingList("الجبهة الشعبية",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/%D8%B4%D8%B9%D8%A7%D8%B1_%D8%AD%D8%B1%D9%83%D8%A9_%D8%AD%D9%85%D8%A7%D8%B3.jpg/195px-%D8%B4%D8%B9%D8%A7%D8%B1_%D8%AD%D8%B1%D9%83%D8%A9_%D8%AD%D9%85%D8%A7%D8%B3.jpg",
                "lalalalal",
                "الزهار");


       boolean test= db.insertNote(list3);

        assertEquals(true,test);

    }





    public Users findUser(String email, ArrayList<Users> customers) {
        for (Users customer : customers) {
            if (customer.getEmail().equals(email)) {
                return customer;
            }
        }
        return null;
    }


    public static byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }



}