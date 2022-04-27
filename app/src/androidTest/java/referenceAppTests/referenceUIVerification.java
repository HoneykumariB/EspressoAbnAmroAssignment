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
public class referenceUIVerification extends referenceMainPage {

@Test
@Regression
@Smoke
    public void uiElementVerification(){

    assertTrue("Background display status:",verifyBackgroundStatus());
    assertTrue("Background display status:",verifyToolBarStatus());
    assertTrue("Heading display status:",verifyHeadingText());
    assertTrue("Main body display status:",verifyBodyStatus());
    assertTrue("toolbar display status :",verifyToolBarStatus());
    assertTrue("Mail ICON display status :",verifyMailStatus());
    assertTrue("Hello world has Background status :",bodyBackGround());
    assertTrue("ToolBar backGround Color is Green :",toolbarColor());
    NativeScreenshot.capture("PostUIValidationStatus");
}

}
