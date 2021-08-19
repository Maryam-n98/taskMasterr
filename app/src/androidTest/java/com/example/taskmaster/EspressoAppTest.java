package com.example.taskmaster;



import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;

import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class EspressoAppTest {
//    @Rule
//    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
@Rule
public ActivityScenarioRule<MainActivity> activityScenarioRule =
        new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testSetting(){
        onView(withId(R.id.button7)).perform(click());
        onView(withId(R.id.textView7)).check(matches(withText("Settings")));
    }

    @Test
    public void assertTextChanged() {
        // type text and then press change text button
        onView(withId(R.id.button7)).perform(click());

        onView(withId(R.id.editTextTextPersonName)).perform(typeText("Mariam"), closeSoftKeyboard());

        onView(withId(R.id.button8)).perform(click());
        // check that the text was changed when the button was clicked
        onView(withId(R.id.textView)).check(matches(withText("Mariam's Task")));
    }
    @Test
    public void testOpenTaskDetail(){

        onView(withId(R.id.list3)).perform(RecyclerViewActions.actionOnItemAtPosition(0,click()));

        onView(withId(R.id.textViewTitle)).check(matches(withText("DO TODAY LAB")));
        onView(withId(R.id.textViewBody)).check(matches(withText("Lab 30")));
        onView(withId(R.id.textViewState)).check(matches(withText("New")));
    }
    @Test
    public void testAddTask(){
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.editTextTextPersonName2)).perform(typeText("DO TODAY LAB"), closeSoftKeyboard());
        onView(withId(R.id.editTextTextPersonName3)).perform(typeText("Lab 30"), closeSoftKeyboard());
        onView(withId(R.id.editTextTextPersonName4)).perform(typeText("New"), closeSoftKeyboard());
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.list3)).perform(RecyclerViewActions.actionOnItemAtPosition(2,click()));
        onView(withId(R.id.textViewTitle)).check(matches(withText("DO TODAY LAB")));
        onView(withId(R.id.textViewBody)).check(matches(withText("Lab 30")));
        onView(withId(R.id.textViewState)).check(matches(withText("New")));
    }


}
