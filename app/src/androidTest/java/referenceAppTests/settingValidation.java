package referenceAppTests;


import static org.junit.Assert.assertTrue;

import android.util.Log;

import androidx.test.filters.SmallTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;


import org.junit.Test;
import org.junit.runner.RunWith;

import referenceAppPages.referenceMainPage;
import utilities.NativeScreenshot;
import utilities.Regression;
import utilities.Smoke;


@RunWith(AndroidJUnit4ClassRunner.class)
@SmallTest
public class settingValidation extends referenceMainPage {


    @Test
    @Regression
    @Smoke
    public void moreOptionValidations(){
        click3Dots();
        selectSetting();
        tapHelloWorld();
        assertTrue("Setting field collapsed",noSettingField());
    //    NativeScreenshot.capture("PostSettingStatus");

    }

}


