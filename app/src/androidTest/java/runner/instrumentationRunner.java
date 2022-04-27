package runner;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import referenceAppTests.mailIconValidation;
import referenceAppTests.orientationTest;
import referenceAppTests.referenceUIVerification;
import referenceAppTests.settingValidation;
import utilities.Regression;


@RunWith(Suite.class)
@Suite.SuiteClasses(
        {referenceUIVerification.class, settingValidation.class, mailIconValidation.class, orientationTest.class
        })
public class instrumentationRunner {

}



