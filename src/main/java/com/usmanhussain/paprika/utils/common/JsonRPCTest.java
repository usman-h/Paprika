package com.usmanhussain.paprika.utils.common;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonRPCTest {

    public static void main(String[] args) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpPost request = new HttpPost("END POINT URL HERE");
            String jSonRequest = new String(Files.readAllBytes(Paths.get("LOCATION OF TEXT FILE")));
            StringEntity params = new StringEntity(jSonRequest);
            request.addHeader("content-type", "application/json; charset=UTF-8");
            request.addHeader("Authorization", "Basic dXBzdHJlYW06cGFzc3dvcmQ=");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            String result = EntityUtils.toString(response.getEntity());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}