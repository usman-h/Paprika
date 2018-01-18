package com.usmanhussain.paprika.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AboutYouSectionCar extends AbstractPage {

    public WebElement aboutYouSectionTitle() {
        return findElement(By.xpath("//span[contains(text(), 'About You')]"));
    }

}
