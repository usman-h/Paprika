package com.usmanhussain.paprika.Session3;

import net.serenitybdd.core.annotations.findby.By;
import org.apache.commons.lang.NullArgumentException;
import org.apache.commons.lang.ObjectUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Session4 {
    WebDriver driver;


    public void launchGoogle() {

        System.setProperty("webdriver.chrome.driver", "D:\\projects\\Paprika\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
    }

    public boolean elementPresent() {
        boolean elementPresent = false;
        try {
            elementPresent = driver.findElement(By.name("qaaaa")).isDisplayed();
            return elementPresent;
        } catch (NoSuchElementException e) {
            return false;
        }finally {
            System.out.println("i will be called anyways.....");
        }
    }

    public void assertExample(int a) {
        if (a != 1) {
            throw new AssertionError();
        }

    }

    public void readFile() throws FileNotFoundException, IOException{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\491136\\Desktop\\samplefile.txt"));
            System.out.println(br.readLine());
    }


}
