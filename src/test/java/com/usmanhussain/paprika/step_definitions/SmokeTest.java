package com.usmanhussain.sample.step_definitions;

import com.usmanhussain.sample.BaseStepDef;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

public class SmokeTest extends BaseStepDef {

    @Given("^I have navigated to a website$")
    public void iHaveNavigatedToAWebsite() throws Throwable {
        getDriver().get("http://www.bing.com");
    }

    @When("^I search for the following '(.+)'$")
    public void iSearchForTheFollowing(String searchTerm) throws Throwable {
        getDriver().findElement(By.id("sb_form_q")).sendKeys(searchTerm);
        getDriver().findElement(By.id("sb_form_go")).click();
    }

    @Then("^The correct (.+) appears on the screen$")
    public void theCorrectResultsAppearOnTheScreen(String searchResultTerm) throws Throwable {
        getDriver().findElement(By.xpath("//input[@id='sb_form_q'][@value='" + searchResultTerm + "']")).isDisplayed();
    }

}
