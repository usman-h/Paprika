package com.usmanhussain.paprika.Session3;

public class Session3BasicJavaClass2 {
    //This is a constructor which takes an input parameter of type String
    //This will be invoked whenever an object is created for the class
    public Session3BasicJavaClass2(String strMessage){
        System.out.println(strMessage);
    }

    //This is an example of a method that prints a static message
    public void printStaticMessage(){
        System.out.println("Print Static Message");
    }

    //This is an example of a method that prints a message that is dynamic
    //A user can control what he/she needs to print based on the input that is passed into the method
    public void printDynamicMessage(String strMessage){
        System.out.println(strMessage);
    }

    //This is an example to show access modifiers for a method. The below shows a private method defined.
    //This method can be accessed only within the class Session3BasicJavaClass2.
    private void printPrivateMessage(){
        System.out.println("This is a private method");
    }

    //This is an example to show access modifiers for a method. The below shows a protected method defined.
    //This method can be accessed within the class Session3BasicJavaClass2 as well as any other class within the same package
    // In this case this method can be accessed from Session3BasicJava class as well
    // When access modifier is given as public, then it means the method can be access from any class in the program.
    protected void printProtectedMessage(){
        System.out.println("This is a protected method");
    }

    //This is an example of showing the boolean data type. Below shows a method that takes an input paramter/variable
    //of type boolean
    public void printBooleanVariable(boolean bCondition){
        System.out.println(bCondition);
    }

    //This is an example of showing the int data type. Below shows a method that takes an input paramter/variable
    //of type int
    public void printID(int i){
        System.out.println(i);
    }

    //Below example shows how an if..else is used to implement a scenario.
    //Scenario is : - Based on the customer ID, print customer name
    public void printNameAsString(int iCustID) {
        int iCustomerID = iCustID;
        if (iCustomerID == 1) {
            System.out.println("Bijith");
        } else if (iCustomerID == 2) {
            System.out.println("Usman");
        } else {
            System.out.println("No customer with this iD");
        }
    }

    //Below example shows how an switch case is used to implement a scenario.
    //Scenario is : - Based on the customer ID, print customer name
    public void printNameWithSwitch(int iCustID){
            int iCustomerID = iCustID;
            switch (iCustomerID){
                case 1:
                    System.out.println("Bijith");
                    break;

                case 2:
                    System.out.println("Usman");
                    break;

                default:
                    System.out.println("No customer with this iD");
                    break;
            }
    }

    //Below example shows the usage of an array
    //Arrays are zero indexed based. When an array is defined, memory space is allocated in machine based on the size of array
    public void printNamesWithIndex(int iIndex){
        String[] arrNames = new String[3];
        arrNames[0] = "Bijith";
        arrNames[1] = "Usman";
        arrNames[2] = "test";
        System.out.println(arrNames[iIndex]);
    }

    //Example of how to combine two strings, compare the final string using if..else and print something
    public void printConcatenateString(String strFirstName, String strLastName){
        String strFullName = strFirstName + " " + strLastName;
        System.out.println("Customer Name is "+ strFullName);

        if(strFullName.equalsIgnoreCase("Bijith Narikkuni")){
            System.out.println("I got the right customer");
        }else{
            System.out.println("Wrong customer");
        }
    }



}
