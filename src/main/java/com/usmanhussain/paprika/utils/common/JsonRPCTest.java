package com.usmanhussain.paprika.utils.common;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.mortbay.log.Log;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonRPCTest {

    public static void main(String[] args) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpPost request = new HttpPost("http://ci.claimportal.scor.dlg/cc/service/edge/fnol/fnol");
            String jSonRequest = new String(Files.readAllBytes(Paths.get("D:\\projects\\SCOR-TestAutomation\\src\\test\\resources\\Requests\\ResetTimeSlotAvailability.txt")));
            StringEntity params = new StringEntity(jSonRequest);
            request.addHeader("content-type", "application/json; charset=UTF-8");
            request.addHeader("Authorization", "Basic dXBzdHJlYW06cGFzc3dvcmQ=");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            Log.info("---+++---+++ Status: " + response.getStatusLine());
            String result = EntityUtils.toString(response.getEntity());
            Log.info("Result ===== " + result);
            // handle response here...
        } catch (Exception ex) {
            ex.printStackTrace();
            // handle exception here
        }
    }

}