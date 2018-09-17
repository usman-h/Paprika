package com.usmanhussain.paprika.step_definitions;

import com.usmanhussain.paprika.BaseStepDef;
import com.usmanhussain.paprika.pages.DemoPage;
import com.usmanhussain.habanero.framework.AbstractPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class DemoOne extends BaseStepDef {
    private AbstractPage demoPage = new DemoPage();

    @Given("^one$")
    public void one() throws Throwable {
        getDriver().get("https://httpstat.us/200");
        getDriver().get("https://httpstat.us/404");
    }

    @When("^two$")
    public void two() throws Throwable {
        WebElement element = demoPage.waitForElementToBeClickableAndReturnElement(By.id("lst-ib"));
        element.sendKeys("Hi" + Keys.ENTER);
        demoPage.waitForElementToBeClickableAndReturnElement(By.cssSelector("a[href='http://www.dictionary.com/browse/hi']")).click();
    }

    @Then("^three$")
    public void three() throws Throwable {
    }

    @Given("^I launch evo application$")
    public void iLaunchASlowApplication() throws Throwable {
        getDriver().get("https://dlg-sit2.ssp-hosting.com/DirectLineVanCT/servletcontroller");
    }

    @And("^I click next$")
    public void iClickNext() throws Throwable {
        Thread.sleep(5000);
        getDriver().findElement(By.id("C2__BUT_9D492D0AD73E6FD4361634")).click();
    }

    @Then("^I should see registration text field$")
    public void iShouldSeeRegistrationTextField() throws Throwable {
        getDriver().findElement(By.id("C2__C1__QUE_D60ACA93B3AF52B1128920")).sendKeys("A1");
    }

    @And("^I wait$")
    public void iWait() throws Throwable {
        Thread.sleep(10000);
    }

}
