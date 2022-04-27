package referenceAppTests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.platform.app.InstrumentationRegistry;

import com.abnamro.apps.referenceandroid.MainActivity;

import org.junit.Rule;

public class baseClass {


    @Rule
    public IntentsTestRule<MainActivity> activityTestRule =
            new IntentsTestRule<MainActivity>(MainActivity.class) {
                @Override
                public void beforeActivityLaunched() {
                    super.beforeActivityLaunched();
                    Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
                    SharedPreferences.Editor editor =
                            context.getSharedPreferences(context.getPackageName(),
                                    Activity.MODE_PRIVATE).edit();
                    editor.putBoolean("is_first_launch", true);
                    editor.commit();
                }
            };

    public static ViewInteraction checkDisplay(int uiElement){
        ViewInteraction status=onView(withId(uiElement)).check(matches(isDisplayed()));
        System.out.println(status);
        return status;
    }

    public static ViewInteraction checkDisplay(String uiElementText){
        ViewInteraction status=onView(withText(uiElementText)).check(matches(isDisplayed()));
        return status;
    }

    public static void clickElement(String uiElement){
        onView(withText(uiElement)).perform(click());
    }

    public static void clickElement(int uiElementInt){
        onView(withId(uiElementInt)).perform(click());
    }

    public static void notExistStatus(String uiElementExist){
        onView(withText(uiElementExist)).check(doesNotExist());
    }

    public static void notExistStatus(int uiElementExist){
        onView(withId(uiElementExist)).check(doesNotExist());
    }
    public static void elementTextStatus(String elementText,String Value){
            onView(withText(elementText))
                    .check(matches(withText(Value)));

    }

    public void wait(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
