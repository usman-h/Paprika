package com.usmanhussain.paprika.step_definitions;

import com.usmanhussain.paprika.BaseStepDef;
import cucumber.api.java.en.Given;

public class RegressionStepDef extends BaseStepDef {

    @Given("^User navigates to '(.+)' Landing Page(?:|(?:| with parameters '(.+)' and '(.+)')(?:,'(.+)'))$")
    public void launchBroswer(String application, String userName, String password, String ContinueQuoteOrMakeACall) throws Throwable {
        switch (application) {
            case "WJ":
                getDriver().get(System.getProperty("WJ"));
                break;
            case "CC":
                getDriver().navigate().to(System.getProperty("CC"));
                break;
            case "SS":
                getDriver().navigate().to(System.getProperty("SS"));
                break;
        }
    }

}