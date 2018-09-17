package com.usmanhussain.paprika.pages;

import com.usmanhussain.paprika.steps.AbstractSteps;
import org.openqa.selenium.By;

public class DemoNewPage extends AbstractSteps {

    public DemoNewPage() {
        WebElementPath.put("elementNameOne", By.id("LOCATOR HERE"));
        WebElementPath.put("elementNameTwo", By.xpath("LOCATOR"));
        WebElementPath.put("elementNameThree", By.cssSelector("LOCATOR"));
    }

}
