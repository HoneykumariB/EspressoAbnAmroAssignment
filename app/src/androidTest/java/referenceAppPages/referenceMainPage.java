package referenceAppPages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasBackground;
import static androidx.test.espresso.matcher.ViewMatchers.hasTextColor;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


import static org.hamcrest.Matchers.allOf;


import static customMatchers.customOperation.childAtPosition;
import static customMatchers.orientationChange.orientationLandscape;
import static customMatchers.orientationChange.orientationPortrait;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewInteraction;

import com.abnamro.apps.referenceandroid.R;

import referenceAppTests.baseClass;

public class referenceMainPage extends baseClass {
    private final String mainHeading = "ReferenceAndroid";
    private final int mainBackGround = R.id.fragment;
    private final String mainBodyText = "Hello World!";
    private final int settingBox = R.id.title;
    private final String settingText = "Settings";
    private final int mailIcon = R.id.fab;
    private final int popupScreen = R.id.snackbar_text;
    private final String popupText = "ABN AMRO APP";
    private final String settingContent = "More options";
    private final int toolBar = R.id.toolbar;
    private final int settingDotsContent = R.id.content;

    ViewInteraction dotsMenuButton;
    ViewInteraction SettingTextView;



    public boolean verifyBackgroundStatus() {
        try {
            checkDisplay(mainBackGround);
            return true;
        } catch (NoMatchingViewException backElement) {
            return false;
        }
    }


    public boolean verifyPopUpText() {
        try {
            checkDisplay(popupScreen);
            return true;
        } catch (NoMatchingViewException popupElement) {
            return false;
        }
    }

    public boolean popupTextVerify(String value) {
        try {
            elementTextStatus(popupText, value);
            return true;
        } catch (NoMatchingViewException popupElement) {
            return false;
        }
    }


    public boolean verifyHeadingText() {
        try {
            checkDisplay(mainHeading);
            return true;
        } catch (NoMatchingViewException popupElement) {
            return false;
        }
    }

    public boolean verifyBodyStatus() {
        try {
            checkDisplay(mainBodyText);
            return true;
        } catch (NoMatchingViewException popupElement) {
            return false;
        }
    }

    public boolean verifyMailStatus() {
        try {
            checkDisplay(mailIcon);
            return true;
        } catch (NoMatchingViewException popupElement) {
            return false;
        }
    }


    public void clickMailIcon() {
        clickElement(mailIcon);
    }

    public boolean verifyToolBarStatus() {
        try {
            checkDisplay(toolBar);
            return true;
        } catch (NoMatchingViewException noElement) {
            return false;
        }
    }


    public void click3Dots() {
        dotsMenuButton = onView(
                allOf(withContentDescription(settingContent),
                        childAtPosition(
                                childAtPosition(
                                        withId(toolBar),
                                        1),
                                0),
                        isDisplayed()));
        dotsMenuButton.perform(click());
    }

    public void selectSetting() {
        SettingTextView = onView(
                allOf(withId(settingBox), withText("Settings"),
                        childAtPosition(
                                childAtPosition(
                                        withId(settingDotsContent),
                                        0),
                                0),
                        isDisplayed()));
        SettingTextView.perform(click());
    }

    public void tapHelloWorld() {
        clickElement(mainBodyText);
    }

    public boolean noSettingField() {
        try {
            notExistStatus(settingText);
            return true;
        } catch (NoMatchingViewException noElement) {
            return false;
        }
    }


    public boolean noPopupField() {
        try {
            notExistStatus(popupScreen);
            return true;
        } catch (NoMatchingViewException noElement) {
            return false;
        }
    }


    public boolean mailMessageStatus() {
        try {
            onView(withId(popupScreen)).check(matches(isDisplayed()));
            return true;
        } catch (NoMatchingViewException noElement) {
            return false;
        }
    }


    public void landscapeOrientation() {
        onView(isRoot()).perform(orientationLandscape());
        wait(3000);
    }

    public void portraitOrientation() {
        onView(isRoot()).perform(orientationPortrait());
        wait(3000);

    }

    public boolean toolbarColor() {
        try {
            onView(allOf(withId(toolBar), hasTextColor(R.color.colorPrimaryDark)));
            return true;
        } catch (Exception colorEx){
       return false;
    }

}


    public boolean bodyBackGround(){
      try {
          onView(allOf(withText(mainBodyText), hasBackground(mainBackGround)));
          return true;
      }
      catch(NoMatchingViewException noMatchEx){
     return false;
      }

    }

}
