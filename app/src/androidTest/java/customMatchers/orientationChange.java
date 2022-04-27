package customMatchers;


import static androidx.test.espresso.matcher.ViewMatchers.isRoot;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.view.ViewGroup;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;

import org.hamcrest.Matcher;

public class orientationChange implements ViewAction {
    private final int orientation;

    private orientationChange(int orientation) {
        this.orientation = orientation;
    }

    public static ViewAction orientationLandscape() {
        return new orientationChange(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    public static ViewAction orientationPortrait() {
        return new orientationChange(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public Matcher<View> getConstraints() {
        return isRoot();
    }

    @Override
    public String getDescription() {
        return "change orientation to " + orientation;
    }


    @Override
    public void perform(UiController uiController, View view) {
        uiController.loopMainThreadUntilIdle();
        Activity activity = getActivity(view.getContext());
        if (activity == null && view instanceof ViewGroup) {
            ViewGroup v = (ViewGroup) view;
            int c = v.getChildCount();
            for (int i = 0; i < c && activity == null; ++i) {
                activity = getActivity(v.getChildAt(i).getContext());
            }
        }
        activity.setRequestedOrientation(orientation);
    }

    public Activity getActivity(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}


