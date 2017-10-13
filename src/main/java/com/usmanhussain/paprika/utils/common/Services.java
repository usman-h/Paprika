package com.usmanhussain.paprika.utils.common;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.*;

public class Services {

    public String invokeWebService(String webServiceURL,
                                   String requestXMLPath)
            throws FileNotFoundException, Exception {
        String result = "";
        String xml2String = "";

        try {
            HttpClient client = HttpClientBuilder.create().build();
            File xmlFile = new File(requestXMLPath);
            // Let's get XML file as String using BufferedReader
            // FileReader uses platform's default character encoding
            // if you need to specify a different encoding, use InputStreamReader
            Reader fileReader = new FileReader(xmlFile);
            BufferedReader bufReader = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();
            String line = bufReader.readLine();
            while (line != null) {
                sb.append(line).append("\n");
                line = bufReader.readLine();
            }
            xml2String = sb.toString();
            HttpPost post = new HttpPost(webServiceURL);
            //HttpPost post = new HttpPost("http://www.thomas-bayer.com/axis2/services/BLZService?wsdl");
            HttpEntity entity = new ByteArrayEntity(xml2String.getBytes("UTF-8"));
            post.setHeader("SOAPAction", "http://www.webserviceX.NET/GetCitiesByCountry");
            post.setHeader("Content-Type", "text/xml; charset=utf-8");
            post.setEntity(entity);
            HttpResponse response = client.execute(post);
            result = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}