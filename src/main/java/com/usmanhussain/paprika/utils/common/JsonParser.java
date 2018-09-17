package com.usmanhussain.paprika.utils.common;

import org.mortbay.log.Log;

import javax.json.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.util.List;

public class JsonParser {

    static List<String> value;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\DLG\\SCOR\\Requests\\M&P-CCv8-Json\\TimeSlotResponse.txt"));
            StringBuffer stringBuffer = new StringBuffer();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line).append("\n");
            }
            System.out.println(stringBuffer);
            JsonReader jsonReader = Json.createReader(new StringReader(stringBuffer.toString()));
            JsonObject jsonObject = jsonReader.readObject();
            Log.info("++++++Value: " + navigateTree(jsonObject, "", "timeslot"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> navigateTree(JsonValue tree, String key, String keyName) {
        if (key != null)
            System.out.print("Key " + key + ": ");
        switch (tree.getValueType()) {
            case OBJECT:
                Log.info("OBJECT");
                JsonObject object = (JsonObject) tree;
                for (String name : object.keySet()) {
                    navigateTree(object.get(name), name, keyName);
                }
                break;
            case ARRAY:
                Log.info("ARRAY");
                JsonArray array = (JsonArray) tree;
                for (JsonValue val : array)
                    navigateTree(val, null, keyName);
                break;
            case STRING:
                JsonString st = (JsonString) tree;
                if (key.contains(keyName)) {
                    value.add(st.getString());
                }
                Log.info("STRING " + st.getString());
                break;
            case NUMBER:
                JsonNumber num = (JsonNumber) tree;
                Log.info("NUMBER " + num.toString());
                break;
            case TRUE:
            case FALSE:
            case NULL:
                Log.info(tree.getValueType().toString());
                break;
        }
        return value;
    }

}