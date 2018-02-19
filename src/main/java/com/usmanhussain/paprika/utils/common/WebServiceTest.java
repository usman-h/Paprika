package com.usmanhussain.paprika.utils.common;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.mortbay.log.Log;

import java.nio.file.Files;
import java.nio.file.Paths;

public class WebServiceTest {

    public static void main(String[] args) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        try {
//            HttpPost request = new HttpPost("http://www.webservicex.net/uklocation.asmx?WSDL");
//            String jSonRequest = new String(Files.readAllBytes(Paths.get("D:\\projects\\Paprika\\src\\test\\resources\\request.txt")));
//            StringEntity params = new StringEntity(jSonRequest);
//            request.addHeader("content-type", "text/xml; charset=utf-8");
//            request.addHeader("SOAPAction", "http://www.webserviceX.NET/GetUKLocationByPostCode");
//            request.setEntity(params);
//            HttpResponse response = httpClient.execute(request);
//            Log.info("ssssssssstttttttttttttttaaaaaaaaaaaaaaaaaaatttttttttttttttttuuuuuuuuuuuusssssssss" + response.getStatusLine());
//            String result = EntityUtils.toString(response.getEntity());
//            System.out.println("result ====================== " + result);
//            Log.info("result ====================== " + result);
//                       HttpUriRequest request = new HttpGet("https://api.getaddress.io/find/br11dp?api-key=-_2PDl0-BUa2Rm2qbDWPFQ12276");
//                      HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
//                      System.out.println(EntityUtils.toString(httpResponse.getEntity()));

            HttpPost request = new HttpPost("https://secure-uat.directlineforbusiness.co.uk/DLGUAT/TechnologyFrameworksWeb/ManageCompanyWS");
            String jSonRequest = new String(Files.readAllBytes(Paths.get("D:\\EVO\\Same.xml")));
            StringEntity params = new StringEntity(jSonRequest);
            //request.addHeader("content-type", "text/xml; charset=utf-8");
            request.addHeader("SOAPAction", "ManageCompanyWSService/createCompany");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            Log.info("ssssssssstttttttttttttttaaaaaaaaaaaaaaaaaaatttttttttttttttttuuuuuuuuuuuusssssssss" + response.getStatusLine());
            String result = EntityUtils.toString(response.getEntity());
            System.out.println("result ====================== " + result);
            Log.info("result ====================== " + result);

            // handle response here...
        } catch (Exception ex) {
            ex.printStackTrace();
            // handle exception here
        }
    }

}