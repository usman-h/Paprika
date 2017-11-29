package com.usmanhussain.paprika.Session3;

import net.serenitybdd.core.annotations.findby.By;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.yecht.Data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

//import org.junit.Assert;

public class Session5 {
    WebDriver driver;

    public void launchSite() {
        System.setProperty("webdriver.chrome.driver", "D:\\projects\\Paprika\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://toolsqa.com/automation-practice-form/");
    }

    public void getDropDownValues() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Select select = new Select(driver.findElement(By.id("continents")));
        ArrayList<WebElement> options = (ArrayList) select.getOptions();
        System.out.println("size is " + options.size());
        for (WebElement element : options) {
            System.out.println(element.getText());
        }
    }

    public void setNames() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Hashtable<String, String> usernames = new Hashtable<>();
        usernames.put("username1", "hemanth");
        usernames.put("username2", "usman");
        usernames.put("username3", "preetam");

        driver.findElement(By.name("firstname")).sendKeys(usernames.get("username3"));
        driver.findElement(By.name("lastname")).sendKeys(usernames.get("username2"));
    }

    public void arrayListExample1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("asd");
        arrayList.add(1);
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
    }

    public void arrayListExample() {
        ArrayList<GetterSetter> arrayList = new ArrayList();
        arrayList.add(new GetterSetter("hemanth", 12345, true));
        arrayList.add(new GetterSetter("usman", 234456, false));
        arrayList.add(new GetterSetter("preetam", 4321, true));

        for (GetterSetter getterSetter : arrayList) {
            System.out.println(getterSetter.getPolicyHolerName());
            System.out.println(getterSetter.getClaimNumber());
            System.out.println(getterSetter.isSettled());
        }
    }

    public void hashMapExample() {
        Hashtable<String, GetterSetter> hashtable = new Hashtable();
        hashtable.put("detail1", new GetterSetter("name1", 12345, true));
        hashtable.put("detail2", new GetterSetter("name2", 54321, true));
        hashtable.put("detail3", new GetterSetter("name3", 67890, false));

        Set<String> keys = hashtable.keySet();

        Iterator<String> itr = keys.iterator();
        while (itr.hasNext()) {
            String str = itr.next();
            System.out.println(hashtable.get(str));
        }

//        System.out.println(hashtable.get("detail2").getClaimNumber());
//        System.out.println(hashtable.get("detail2").getPolicyHolerName());
//        System.out.println(hashtable.get("detail2").isSettled());
    }
}
