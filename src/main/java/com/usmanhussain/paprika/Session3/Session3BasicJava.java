package com.usmanhussain.paprika.Session3;

public class Session3BasicJava {

    public static void main(String[] args){
        //Simply printing "Hello World"
        System.out.println("Hello World");

        //creating an object
        Session3BasicJavaClass2 objClass = new Session3BasicJavaClass2("test");

        //Calling different methods defined in Session3BasicJavaClass2 class
        //When a method is called, based on the type of method either pass the required parameters of correct
        //data types or simple call the method(if no input parameter defined for the method)
        objClass.printDynamicMessage("testing");
        objClass.printStaticMessage();
        objClass.printProtectedMessage();
        objClass.printBooleanVariable(false);
        objClass.printID(1);
        objClass.printNameAsString(1);
        objClass.printNameAsString(5);
        objClass.printNameWithSwitch(5);
        objClass.printNamesWithIndex(1);
        objClass.printConcatenateString("testing","test");
    }

}
