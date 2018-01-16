package com.usmanhussain.paprika.step_definitions;

import com.usmanhussain.paprika.BaseStepDef;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

public class OOP extends BaseStepDef {

    @Given("^I am on the Direct Line homepage$")
    public void iAmOnTheDirectLineHomepage() throws Throwable {
        getDriver().get("http://www.directline.com");
    }

    @When("^I click on the motor quote button$")
    public void iClickOnTheMotorQuoteButton() throws Throwable {
        getDriver().findElement(By.id("car-insurance/getquote")).click();
    }

    @When("^After submitting my car details$")
    public void afterSubmittingMyCarDetails() throws Throwable {
//        carDetailsPage.carRegistrationTextField().sendKeys("VO56 UAE");
        //fill in vehicle registration
        getDriver().findElement(By.id("formField.vehicle.registration")).sendKeys("VO56 UAE");
        getDriver().findElement(By.cssSelector(".secondary.small")).click();
        //fill in annual mileage
        getDriver().findElement(By.partialLinkText("guessing")).sendKeys("10000");
        //not purchased car radio button
        getDriver().findElement(By.name("Not yet bought")).click();
        //estimated car value
        getDriver().findElement(By.id("formField.vehicle.value")).sendKeys("40000");
        //click on Next button
        getDriver().findElement(By.linkText("Next")).click();
    }

    @Then("^I should be taken to the 'About You' page$")
    public void iShouldBeTakenToTheAboutYouPage() throws Throwable {
        getDriver().findElement(By.xpath("//span[contains(text(), 'About You')]")).isDisplayed();
    }

    //**************************************************************************************************

//    @Then("^I can verify all the fields are present$")
//    public void iCanVerifyAllTheFieldsArePresent() throws Throwable {
//        //What can i reuse to go here...
//    }

}
