package com.usmanhussain.paprika.SeleniumTests;

import com.google.common.base.Function;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
//import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ActionsAndWait {
    public static void main(String[] arg) throws Exception{
        WebElement element;
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Paprika\\src\\main\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

/*
        driver.get("http://toolsqa.com/iframe-practice-page/");
        //driver.navigate()

        driver.switchTo().frame("iframe1");
//driver.switchTo().frame("IF1");

        element = driver.findElement(By.name("firstname"));
        element.clear();
        element.sendKeys("First Name field");

        element = driver.findElement(By.id("sex-0"));
        element.click();
        Assert.assertTrue("Element not selected", element.isSelected());
        new Actions(driver).moveToElement(element).build().perform();

        element = driver.findElement(By.id("continents"));
        element.click();
        element.findElement(By.xpath("//option[contains(text(),'Australia')]")).click();

        new Select(element).selectByVisibleText("Australia");

//to top most window/content
//driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();

        driver.switchTo().frame("iframe2");

        element = driver.findElement(By.className("entry-title"));
        System.out.println(element.getText());
        System.out.println(element.getAttribute("text"));

        driver.get("https://www.directline.com/");
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("a[title='Get a quote']"))).build().perform();

*/

//        driver.manage().timeouts().implicitlyWait(60, SECONDS);

        driver.get("https://www.directline.com/");

        WebDriverWait wdWait = new WebDriverWait(driver, 15L, 100L);
        WebElement getAQuote = wdWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Get a quote']")));

        new Actions(driver).moveToElement(getAQuote).build().perform();
        //new Actions(driver).moveToElement(driver.findElement(By.cssSelector("a[title='Get a quote11']"))).build().perform();

    }
}
