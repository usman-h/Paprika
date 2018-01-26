package com.usmanhussain.paprika.step_definitions;

import com.usmanhussain.paprika.BaseStepDef;
import com.usmanhussain.paprika.pages.AboutYouSectionCar;
import com.usmanhussain.paprika.pages.HomePage;
import com.usmanhussain.paprika.pages.MyDetailsSectionCar;
import com.usmanhussain.paprika.utils.OopMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

public class OOP extends BaseStepDef {

    private HomePage homePage = new HomePage();
    private MyDetailsSectionCar myDetailsSection = new MyDetailsSectionCar();
    private AboutYouSectionCar aboutYouSection = new AboutYouSectionCar();

    private OopMethods carDetailsForm = new OopMethods();

    @Given("^I am on the Direct Line homepage$")
    public void iAmOnTheDirectLineHomepage() throws Throwable {
        getDriver().get("http://www.directline.com");
    }

    @When("^I click on the motor quote button$")
    public void iClickOnTheMotorQuoteButton() throws Throwable {
        homePage.carQuoteButton().click();
    }

    @When("^After submitting my car details$")
    public void afterSubmittingMyCarDetails() throws Throwable {
        //***************************************************************************
        //Second iteration of Refactoring
        //***************************************************************************
        carDetailsForm.fillInMyCarDetailsSection("VO56 UAE", "10000", "40000");
        carDetailsForm.clickOnNextButton();

        //***************************************************************************
        //First iteration of Refactoring
        //***************************************************************************
        myDetailsSection.carRegistrationTextField().sendKeys("VO56 UAE");
        myDetailsSection.findRegistrationButton().click();
        myDetailsSection.annualMileageDropdown().sendKeys("10000");
        myDetailsSection.carNotYetPurchasedRadioBtn().click();
        myDetailsSection.estimatedCarValueTextField().sendKeys("40000");
        myDetailsSection.nextButton().click();

        //***************************************************************************
        //First time writing a test that works... Now it looks messy but it works...
        //But we will refactor it
        //***************************************************************************
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
        aboutYouSection.aboutYouSectionTitle().isDisplayed();
//        getDriver().findElement(By.xpath("//span[contains(text(), 'About You')]")).isDisplayed();
    }

    //**************************************************************************************************

    @Then("^I can verify all the fields are present$")
    public void iCanVerifyAllTheFieldsArePresent() throws Throwable {
        myDetailsSection.carRegistrationTextField().isDisplayed();
        myDetailsSection.findRegistrationButton().isDisplayed();
        myDetailsSection.annualMileageDropdown().isDisplayed();
        myDetailsSection.carNotYetPurchasedRadioBtn().isDisplayed();
    }

}
