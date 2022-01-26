package com.alaaclips.projectgir1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LogInActivityTest {



    private TextView textView;

    @Rule
    public ActivityScenarioRule<LogInActivity> hom  = new ActivityScenarioRule<>(LogInActivity.class);



//    @Before
//    public void setUpTest() {
//        homeActivityActivityScenarioRule2.getScenario().onActivity(new ActivityScenario.ActivityAction<LogInActivity>() {
//            @Override
//            public void perform(LogInActivity activity) {
//                textView=activity.findViewById(R.id.card2);
//            }
//        });
//    }
//
//
//    @Test
//    public void listView_isCorrect() {
//        // check list view is visible
//        onView(withId(textView.getId())).check(matches(isDisplayed()));
//    }
//




    @Test
    public void check_ui_login(){

        String Email = "Ahmed@test.com";
        String Password = "123456789";

        //View Actions (1,2) - closeSoftKeyboard/typeText
        onView(withId(R.id.Emaile)).perform(typeText(Email),closeSoftKeyboard());
        onView(withId(R.id.passworde)).perform(typeText(Password), closeSoftKeyboard());

        onView(withId(R.id.Emaile)).check(matches(withText(Email)));
        onView(withId(R.id.passworde)).check(matches(withText(Password)));

        //View Actions (3) - click
        onView(withId(R.id.btn_Login)).perform(click());

    }


}