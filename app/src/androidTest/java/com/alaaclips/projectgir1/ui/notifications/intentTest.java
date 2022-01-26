package com.alaaclips.projectgir1.ui.notifications;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import androidx.activity.result.ActivityResult;
import androidx.test.espresso.intent.rule.IntentsTestRule;

import com.alaaclips.projectgir1.LogInActivity;
import com.alaaclips.projectgir1.R;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class intentTest {

    @Rule
    public IntentsTestRule<LogInActivity> intentsTestRule =
            new IntentsTestRule<>(LogInActivity.class);

    @Test
    public void activityResult_DisplaysContactsPhoneNumber() {
        // Build the result to return when the activity is launched.
        Intent resultData = new Intent();
        String phoneNumber = "123-345-6789";
        resultData.putExtra("phone", phoneNumber);
        ActivityResult result =
                new ActivityResult(Activity.RESULT_OK, resultData);

        // Set up result stubbing when an intent sent to "contacts" is seen.
        intending(toPackage("com.android.contacts"));

        // User action that results in "contacts" activity being launched.
        // Launching activity expects phoneNumber to be returned and displayed.
        onView(withId(R.id.btn_Login)).perform(click());

        // Assert that the data we set up above is shown.
        onView(withId(R.id.btn_Login)).check(matches(withText(phoneNumber)));
    }

}
