package com.usmanhussain.paprika.SeleniumTests;

import groovyjarjarantlr.LexerSharedInputState;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;

public class FirstSeleniumTest {
    public static void main(String[] arg){
        WebDriver driver;
        WebElement element;
        List<WebElement> lElement;

        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Paprika\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
/*
        System.setProperty("webdriver.gecko.driver", "D:\Automation\Paprika\src\main\resources\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
*/
/*
        System.setProperty("webdriver.ie.driver", "D:\\Automation\\Paprika\\src\\main\\resources\\drivers\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
*/
/*
        System.setProperty("phantomjs.binary.path", "D:\Automation\Paprika\src\main\resources\drivers\\phantomjs.exe");
        driver = new PhantomJSDriver();
*/
        driver.get("https://www.directline.com/");

        try {
            driver.findElement(By.id("car-insurance/getquote"));
            System.out.println("Element found by id");

            driver.get("https://claim.directline.com/home/#/cm/login");
            driver.findElement(By.name("loginButton"));
            System.out.println("Element found by name");

            driver.get("https://www.directline.com/");
            driver.findElement(By.className("navigation-primary"));
            System.out.println("Element found by classname");

            driver.findElement(By.linkText("Get a quote"));
            System.out.println("Element found by link text");

            lElement = driver.findElements(By.partialLinkText("INSURANCE"));
            System.out.println("Elements found by partial link text ==== " + lElement.size());

            lElement = driver.findElements(By.tagName("a"));
            System.out.println("Element found by tagname ==== " + lElement.size());

            //css selector sample
/*
            //on https://www.directline.com/
            driver.findElement(By.cssSelector("#cookie-bar"));
            System.out.println("Element found by cssselector #");

            driver.findElement(By.cssSelector("div#cookie-bar"));
            System.out.println("Element found by cssselector tag#");

            // on https://www.directline.com/quote/home/details
            driver.findElement(By.cssSelector(".radio-buttons.styled-radio-fixed"));
            System.out.println("Element found by cssselector .");

            driver.findElement(By.cssSelector("div.radio-buttons.styled-radio-fixed"));
            System.out.println("Element found by cssselector tag.");

            driver.findElement(By.cssSelector("label[data-test-id='ownership'][for='rentOwn1']"));
            System.out.println("Element found by cssselector attribute and value");

            driver.findElement(By.cssSelector("[for^='rentOwn']"));
            System.out.println("Element found by cssselector startswith");

            driver.findElement(By.cssSelector("[data-test-id$='ship']"));
            System.out.println("Element found by cssselector endswith");

            driver.findElement(By.cssSelector("[data-test-id*='-address-']"));
            System.out.println("Element found by cssselector *");

            driver.findElement(By.cssSelector("input#rentOwn1 + label"));
            System.out.println("Element found by cssselector next sibling");

            driver.findElement(By.cssSelector("span > input[name='rentOwn']"));
            System.out.println("Element found by cssselector child");

            driver.findElement(By.cssSelector("div[class='small-12 medium-7 columns no-padding'] input"));
            System.out.println("Element found by cssselector subchild");

            // on http://toolsqa.com/automation-practice-form/
            driver.findElement(By.cssSelector("div input[id^='exp-']:nth-child(2)"));
            System.out.println("Element found by cssselector nth-child");

            driver.findElement(By.cssSelector("div input[id^='exp-']:nth-of-type(2)"));
            System.out.println("Element found by cssselector nth-of-type");
*/

            //xpath sample strings

            // on https://www.directline.com/quote/home/details

            //label[contains(text(),'Mortgaged')]
            //span[./input[@name='rentOwn']]/parent::div
            //span[./input[@name='rentOwn']]/following-sibling::span[3]
            //span[./input[@name='rentOwn']]/parent::div/parent::div/preceding-sibling::strong
            //span[./input[@name='rentOwn']]/parent::div/descendant::label[contains(text(),'Council Rented')]
            //span[./input[@name='rentOwn']][3]/parent::div/descendant::label[contains(text(),'Council Rented')]
            //span[./label[contains(text(),'Mortgaged')]]/parent::div/parent::div/preceding-sibling::strong

        }
        catch (Exception ex){
            Assert.fail(ex.toString());
        }
        finally {
            driver.quit();
        }
    }
}
