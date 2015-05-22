package com.example.lsrensen.beaconapp.rest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHelper {

    public static String post(String url) throws IOException {
        return post(url, null);
    }

    public static String post(String url, String data) throws IOException {
        URL uri = new URL(url);
        HttpURLConnection urlConnection = (HttpURLConnection) uri.openConnection();
        try {
            urlConnection.setDoOutput(true);
            urlConnection.setChunkedStreamingMode(0);

            if(data != null) {
                OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
                writer.write(data);
            }

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            //fetch content.
            String response = "";
            String inLine;

            while ((inLine = reader.readLine()) != null) {
                response += inLine;
            }

            return response;
        }finally{
            urlConnection.disconnect();
        }
    }

}
