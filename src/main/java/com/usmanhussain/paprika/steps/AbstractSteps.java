package com.usmanhussain.paprika.steps;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class AbstractSteps extends AbstractPage {

    protected final HashMap<String, By> WebElementPath = new HashMap();

    public WebElement findElementPresent(String elementName) {
        getDriver.executeScript("window.onbeforeunload = function(e){};");
        return waitForElementPresent(WebElementPath.get(elementName));
    }

    public WebElement findElementClickable(String elementName) {
        getDriver.executeScript("window.onbeforeunload = function(e){};");
        return waitForUnstableElement(WebElementPath.get(elementName));
    }

    public WebElement findElementVisible(String elementName) {
        getDriver.executeScript("window.onbeforeunload = function(e){};");
        return waitForElementVisible(WebElementPath.get(elementName));
    }

    public boolean isMessagePresent(String message) {
        getDriver.executeScript("window.onbeforeunload = function(e){};");
        String xpath = "";
        String msg = "";
        String apos = "random char";
        if (message.contains("'")) {
            apos = "'";
        } else if (message.contains("’")) {
            apos = "'";
        }
        if (message.contains(apos)) {
            String[] split = message.split(apos);
            for (int i = 0; i < split.length; i++) {
                if (i == split.length - 1) {
                    msg = msg + apos + split[i] + apos + ",";
                } else {
                    msg = msg + apos + split[i] + apos + ",\"'\",";
                }
            }
            xpath = "//*[text()=concat(" + msg + "\"\")]";
        } else {
            xpath = "//*[text()=\"" + message + "\"]";
        }
        return elementDisplayed(By.xpath(xpath));
    }

}