package com.usmanhussain.paprika.step_definitions;

import com.usmanhussain.paprika.BaseStepDef;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class DemoTwo extends BaseStepDef {

    @Then("^four$")
    public void four() throws Throwable {
        throw new PendingException();
    }

}
