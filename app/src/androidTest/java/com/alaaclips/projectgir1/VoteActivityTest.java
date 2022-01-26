package com.alaaclips.projectgir1;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class VoteActivityTest {

    private RecyclerView recyclerView;

    @Rule
    public ActivityScenarioRule<VoteActivity> homeActivityActivityScenarioRule2 = new ActivityScenarioRule<>(VoteActivity.class);

    @Before
    public void setUpTest() {
        homeActivityActivityScenarioRule2.getScenario().onActivity(new ActivityScenario.ActivityAction<VoteActivity>() {
            @Override
            public void perform(VoteActivity activity) {
                recyclerView=activity.findViewById(R.id.recy_selcteItem);
            }
        });
    }


    @Test(expected = Exception.class)
    public void listView_isCorrect() {
        // check list view is visible
        onView(withId(recyclerView.getId())).check(matches(isDisplayed()));
    }


    @Test
    public void select_item_Test() {
        // check list view is visible
        onView(withId(recyclerView.getId())).check(matches(isDisplayed()));

               onData(allOf())
                .inAdapterView(withId(recyclerView.getId()))
                .atPosition(15)

                .perform(click());

    }


}