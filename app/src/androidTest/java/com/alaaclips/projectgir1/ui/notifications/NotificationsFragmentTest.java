package com.alaaclips.projectgir1.ui.notifications;


import androidx.recyclerview.widget.RecyclerView;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.alaaclips.projectgir1.BottomNavigationActivity;
import com.alaaclips.projectgir1.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class NotificationsFragmentTest {

    private int lesId = R.id.recy_allList;
    private RecyclerView recyclerView;
    @Rule
    public ActivityScenarioRule<BottomNavigationActivity> home = new ActivityScenarioRule<BottomNavigationActivity>(BottomNavigationActivity.class);


    @Before
    public void setUpTest() {
        home.getScenario().onActivity(new ActivityScenario.ActivityAction<BottomNavigationActivity>() {
            @Override
            public void perform(BottomNavigationActivity activity) {

                recyclerView=activity.findViewById(lesId);
            }
        });
    }

    @Test
    public void listView_isCorrect() {
        // check list view is visible
        onView(withId(lesId)).check(matches(isDisplayed()));
    }



//    @Test
//    public void row_Click() {
//        onData(allOf())
//                .inAdapterView(withId(R.id.recy_allList))
//                .atPosition(1)
//                .perform(click());
//    }




}