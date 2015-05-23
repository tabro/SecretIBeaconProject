package com.example.lsrensen.beaconapp.rest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpHelper {

    public static String readURL(String URL, String Parameters) throws IOException{
        StringBuilder builder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(URL);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setEntity(new StringEntity(Parameters));

        HttpResponse response = client.execute(httpPost);
        StatusLine statusLine = response.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        if (statusCode == 200) {
            HttpEntity entity = response.getEntity();
            InputStream content = entity.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(content));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } else {

        }
        return builder.toString();
    }

    public static String readURL(String URL, String Parameters, String method) throws IOException  {
        System.setProperty("http.keepAlive", "false");
        StringBuilder builder = new StringBuilder();
        HttpURLConnection client;

        if (method == "POST") {
            client = (HttpURLConnection) new URL(URL).openConnection();
            client.setRequestMethod("POST");

            client.setRequestProperty("Accept", "application/json");
            client.setRequestProperty("Content-type", "application/json");
            client.setRequestProperty("Content-Length",
                    "" + Integer.toString(Parameters.getBytes().length));

            DataOutputStream wr = new DataOutputStream(
                    client.getOutputStream());

            wr.writeBytes(Parameters);
            wr.flush();
            wr.close();
        } else {
            client = (HttpURLConnection) new URL(URL + Parameters)
                    .openConnection();
            client.setRequestMethod("GET");
        }

        StringBuffer response = new StringBuffer();
        // Get Response
        InputStream is = client.getInputStream();
        InputStreamReader isw = new InputStreamReader(is);
        int data = isw.read();
        StringBuilder sb = new StringBuilder();
        while (data != -1) {
            char current = (char) data;
            data = isw.read();
            sb.append(current);
        }
        return sb.toString();
    }
}