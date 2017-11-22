package com.usmanhussain.paprika.Session3;

import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Session3BasicJava {

    public static void main(String[] args) {
        //Simply printing "Hello World"
        System.out.println("Hello World");

        //creating an object
        Session3BasicJavaClass2 objClass = new Session3BasicJavaClass2("test");


        //scanner class to get an input from user
        System.out.println("enter an integer");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        //handle exception using try catch block
        try {
            objClass.printNamesWithIndex(number);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        System.out.println("success");

        //creating an object for Session4 class
        Session4 session4 = new Session4();
        session4.launchGoogle();
        System.out.println("is the element present ? " + session4.elementPresent());

        session4.assertExample(3);
        System.out.println("so it is 1");

    }

}
