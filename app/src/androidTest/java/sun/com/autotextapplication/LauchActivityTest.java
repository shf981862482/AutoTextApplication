package sun.com.autotextapplication;


import android.app.Instrumentation;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LauchActivityTest {

    @Rule
    public ActivityTestRule<LauchActivity> mActivityTestRule = new ActivityTestRule<>(LauchActivity.class);

    @Test
    public void lauchActivityTest() {
        //at dalvik.system.VMStack.getThreadStackTrace(Native Method)

        Instrumentation.ActivityMonitor am = new Instrumentation.ActivityMonitor("sun.com.autotextapplication.LoginActivity", null, false);
        getInstrumentation().addMonitor(am);
        getInstrumentation().waitForMonitor(am);

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.etxt_name),
                        withParent(allOf(withId(R.id.activity_login),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.etxt_name),
                        withParent(allOf(withId(R.id.activity_login),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("hong"));


        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.etxt_pass),
                        withParent(allOf(withId(R.id.activity_login),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("123"));

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btn_login), withText("登陆"),
                        withParent(allOf(withId(R.id.activity_login),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton.perform(click());
        Instrumentation.ActivityMonitor amMain = new Instrumentation.ActivityMonitor("sun.com.autotextapplication.MainActivity", null, false);
        getInstrumentation().addMonitor(amMain);
        getInstrumentation().waitForMonitor(amMain);

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
