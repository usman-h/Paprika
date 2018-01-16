package com.usmanhussain.paprika.Session3;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by 491136 on 28/11/2017.
 */
public class Session6 {

    //example of arraylist
    public void arrayListexample() {
        ArrayList userNames = new ArrayList();
        userNames.add("sadsd");
        userNames.get(0);

        System.out.println(userNames.size());


    }

    //example of hashtable
    public void hashTableExample(){
        Hashtable hashtable = new Hashtable();
        hashtable.put("username", "un1");
        hashtable.put(123, "un1");
        hashtable.put(true, 123);

        System.out.println(hashtable.get(123));


    }
}
