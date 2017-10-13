package com.usmanhussain.paprika.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SamplePage extends AbstractPage {

    public WebElement samplePageWebElement() {
        return waitForUnstableElement(By.id("ABC123_Something"));
    }

}

