package referenceAppTests;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import androidx.test.filters.SmallTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.squareup.spoon.Spoon;

import org.junit.Test;
import org.junit.runner.RunWith;

import referenceAppPages.referenceMainPage;
import utilities.NativeScreenshot;
import utilities.Regression;
import utilities.Smoke;

@RunWith(AndroidJUnit4ClassRunner.class)
@SmallTest
public class mailIconValidation extends referenceMainPage {


    @Test
    @Regression
    @Smoke
    public void mailValidation(){

            assertTrue("Mail ICON display status", verifyMailStatus());
            clickMailIcon();
            assertTrue("mail popup displayed: ", mailMessageStatus());
            assertTrue("Popup text verified:", popupTextVerify("ABN AMRO APP"));
            wait(5000);
            assertTrue("popup field collapsed", noPopupField());
            NativeScreenshot.capture("PostMailStatus");
        }

    }

