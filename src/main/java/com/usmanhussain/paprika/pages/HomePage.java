package com.usmanhussain.paprika.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractPage {

    public WebElement carQuoteButton() {
        return findElement(By.id("car-insurance/getquote"));
    }

}
