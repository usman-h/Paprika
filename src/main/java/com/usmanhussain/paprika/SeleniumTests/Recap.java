package com.usmanhussain.paprika.SeleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class Recap {
    public static void main(String[] arg){
        WebDriver driver;

        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Paprika\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.directline.com/");
/*
        driver.findElement(By.cssSelector("a[id='home-insurance/getquote']")).click();

        Set<String> wHandle = driver.getWindowHandles();
        System.out.println(wHandle.size());
        for (String han:wHandle) {
            if(driver.switchTo().window(han).getTitle() == "Direct Line Home Insurance") {
                driver.switchTo().window(han);
                break;
            }
            System.out.println(han);
        }
*/


        WebElement element = driver.findElement(By.cssSelector("span[class='i-search']"));
        element.click();

        //element = driver.findElement(By.cssSelector("input[placeholder='Start your search here']"));
        WebDriverWait wait = new WebDriverWait(driver, 15, 100);
        element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[placeholder='Start your search here']")));

        element.clear();
        element.sendKeys("test");

        //new Actions(driver).moveToElement(driver.findElement(By.cssSelector("a[title='Help for existing customers']"))).perform();

//        new Select(driver.findElement(By.cssSelector("select[class='month']"))).selectByValue("2");
    }
}
