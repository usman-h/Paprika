package com.usmanhussain.paprika.Session3;

import java.io.Reader;
import java.util.Scanner;

public class Session3BasicJava {

    public static void main(String[] args) {
        //Simply printing "Hello World"
        System.out.println("Hello World");

        //creating an object
        Session3BasicJavaClass2 objClass = new Session3BasicJavaClass2("test");
//        try {
            System.out.println("enter an integer");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            objClass.printNamesWithIndex(number);
       // } catch (Throwable e) {
            System.out.println(" you have enterd an invalid number ");
       // }

        objClass.printConcatenateString("testing", "test");
    }

}
