package com.usmanhussain.paprika.Session3;

import net.serenitybdd.core.annotations.findby.By;
import org.apache.commons.lang.NullArgumentException;
import org.apache.commons.lang.ObjectUtils;
//import org.junit.Assert;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Session4 {
    WebDriver driver;


    public void launchGoogle() {

        System.setProperty("webdriver.chrome.driver", "D:\\projects\\Paprika\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
    }

    //method that return a boolean value based on an element's presence
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

    public void assertExample(String str) {
       // assert true;
        //if (a != 1) {
        int length = str.length();
        if(length==3){
            System.out.println("success");
        }else{
            throw  new AssertionError();
        }
        Assert.assertTrue(str.length()==3);
           // Assert.assertTrue(a==1);
            //throw new AssertionError();
        }



    //method that prints contents of a file
    public void readFile() throws FileNotFoundException, IOException{
            BufferedReader br = new BufferedReader(new FileReader("src\\test\\resources\\samplefile.txt"));
            System.out.println(br.readLine());
    }

    public void arrayListExample(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("asd");
        arrayList.add(1);
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
    }


}
