package com.alaaclips.projectgir1;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@LargeTest
public class SplashActivityTest {

    @Rule
    public ActivityScenarioRule<SplashActivity> activityRule = new ActivityScenarioRule<>(SplashActivity.class);

    @Test
    public void TestView_isCorrect() {
        onView(withId(R.id.titel)).check(matches(is(withText("1111"))));
        //onView(withId(R.id.tv_test)).check(matches(not(is(withText("Ahmed")))));
        //onView(withId(R.id.tv_test)).check(matches(isDisplayed()));
        //onView(withId(R.id.tv_test)).check(matches(isCompletelyDisplayed()));
    }

}