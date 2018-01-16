package com.usmanhussain.paprika.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OopPageObject extends AbstractPage {

    public WebElement carQuoteButton() {
        return findElement(By.id("car-insurance/getquote"));
    }

//    public WebElement carRegistrationNumberTextField() {
//        return findElement(By.id("formField.vehicle.registration"));
//    }

    public WebElement carRegistrationTextField() {
        return findElement(By.id("formField.vehicle.registration"));
    }

    public WebElement findRegistrationButton() {
        return findElement(By.cssSelector(".secondary.small"));
    }

    public WebElement annualMileageTextField() {
        return findElement(By.partialLinkText("guessing"));
    }

    public WebElement carNotYetPurchasedRadioBtn() {
        return findElement(By.name("Not yet bought"));
    }

    public WebElement estimatedCarValueTextField() {
        return findElement(By.id("formField.vehicle.value"));
    }

    public WebElement nextButton() {
        return findElement(By.linkText("Next"));
    }

    public WebElement aboutYouSectionTitle() {
        return findElement(By.xpath("//span[contains(text(), 'About You')]"));
    }

}
