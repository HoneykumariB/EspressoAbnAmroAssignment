package referenceAppTests;


import static org.junit.Assert.assertTrue;


import org.junit.Test;

import referenceAppPages.referenceMainPage;
import utilities.NativeScreenshot;

public class orientationTest extends referenceMainPage {


    @Test
    public void screenOrientation() {

        landscapeOrientation();
        assertTrue("Background display status:Landscape", verifyToolBarStatus());
        assertTrue("Heading display status:Landscape", verifyHeadingText());
        assertTrue("Main body display status:Landscape", verifyBodyStatus());
        assertTrue("Mail ICON display status :Landscape", verifyMailStatus());
        portraitOrientation();
        assertTrue("Background display status:portrait", verifyToolBarStatus());
        assertTrue("Heading display status:portrait", verifyHeadingText());
        assertTrue("Main body display status:portrait", verifyBodyStatus());
        assertTrue("Mail ICON display status :portrait", verifyMailStatus());
        NativeScreenshot.capture("PostUI_OrientationStatus");

    }
}