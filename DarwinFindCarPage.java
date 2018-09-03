package com.dlg.webBau.pages.IGO4;

import com.dlg.webBau.steps.AbstractSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DarwinFindCarPage extends AbstractSteps {

    public DarwinFindCarPage(){
        WebElementPath.put("getQuoteBtn",By.cssSelector("button[class='btn btn-quote btn-lg btn-block']"));
        WebElementPath.put("enterCarRegNumTxtBox",By.name("vehicle_finder[registration]"));
        WebElementPath.put("getAQuoteBtn",By.xpath("//button[contains(text(),'GET')]"));
        WebElementPath.put("isInformationCorrectBtn",By.xpath("//button[contains(text(),'YES')]"));
    }

    public WebElement getQuoteBtn(){
        return waitForElementPresent(By.cssSelector("button[class='btn btn-quote btn-lg btn-block']"));
    }
    public WebElement enterCarRegNumTxtBox(){
        return waitForElementPresent(By.name("vehicle_finder[registration]"));
    }
    public WebElement getAQuoteBtn(){
        return waitForElementPresent(By.xpath("//button[contains(text(),'GET')]"));
    }
    public WebElement isInformationCorrectBtn(){
        return waitForElementPresent(By.xpath("//button[contains(text(),'YES')]"));
    }
}
