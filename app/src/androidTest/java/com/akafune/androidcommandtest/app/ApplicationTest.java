package com.akafune.androidcommandtest.app;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
public class ApplicationTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity activity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        activity = getActivity();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void idEmpty(){
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.noticeView)).check(matches(withText("IDが入力されていません")));
    }

    @Test
    public void passEmpty(){
        onView(withId(R.id.userIdText)).perform(typeText("1234"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.noticeView)).check(matches(withText("パスワードが入力されていません")));
    }

    @Test
    public void allInput(){
        onView(withId(R.id.userIdText)).perform(typeText("1234"));
        onView(withId(R.id.passwordText)).perform(typeText("password"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.noticeView)).check(matches(withText("OK")));
    }
}
