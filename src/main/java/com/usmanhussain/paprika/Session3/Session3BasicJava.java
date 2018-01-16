package com.usmanhussain.paprika.Session3;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Session3BasicJava {

    public static void main(String[] args) throws IOException {
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
        session4.assertExample("abcddd");
        session4.readFile();
        session4.launchGoogle();
        System.out.println("is the element present ? " + session4.elementPresent());

        session4.assertExample("sad");
        System.out.println("so it is 1");

        Session5 session5 = new Session5();
        session5.hashMapExample();
        session5.launchSite();
        session5.setNames();
        Session6 session6 = new Session6();
        session6.hashTableExample();

        ArrayList<Gettersetter1> arrayList = new ArrayList<>();
        arrayList.add(new Gettersetter1("policy1", 1, "name1"));
        arrayList.add(new Gettersetter1("policy2", 2, "name2"));
        arrayList.add(new Gettersetter1("policy3", 3, "name3"));

        Hashtable<String, Gettersetter1> hashtable = new Hashtable<>();
        hashtable.put("data1", new Gettersetter1("firstname", 1, "lastname"));
        hashtable.put("policy2", new Gettersetter1("policy2", 2, "name2"));

        System.out.println(hashtable.get("policy2").claimNumber);
        System.out.println(hashtable.get("policy2").policyNumber);
        System.out.println(hashtable.get("policy2").policyNumber);



//        Session5 session5 = new Session5();
//        session5.launchSite();
//        session5.setNames();

    }

}
