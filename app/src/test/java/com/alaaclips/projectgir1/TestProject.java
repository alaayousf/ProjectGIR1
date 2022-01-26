package com.alaaclips.projectgir1;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;

import com.alaaclips.projectgir1.db.DatabaseHelpers;
import com.alaaclips.projectgir1.model.Users;

import org.junit.Rule;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestProject  {

    @Test
    public void activityResult_DisplaysContactsPhoneNumber() {
        // Build the result to return when the activity is launched.
        Intent resultData = new Intent();
        String phoneNumber = "123-345-6789";
        resultData.putExtra("phone", phoneNumber);
        ActivityResult result =
                new ActivityResult(Activity.RESULT_OK, resultData);
//
//    // Set up result stubbing when an intent sent to "contacts" is seen.
//    intending(toPackage("com.android.contacts")).respondWith(result);
//
//    // User action that results in "contacts" activity being launched.
//    // Launching activity expects phoneNumber to be returned and displayed.
//    onView(withId(R.id.pickButton)).perform(click());
//
//        // Assert that the data we set up above is shown.
//        onView(withId(R.id.phoneNumber)).check(matches(withText(phoneNumber)));
    }

}
