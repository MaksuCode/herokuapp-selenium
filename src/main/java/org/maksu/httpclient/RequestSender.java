package org.maksu.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class RequestSender {

    public int getStatusCode(String url){
        try {
            return sendRequest(url).getStatusLine().getStatusCode();
        }catch (NullPointerException npe){
            return HttpStatus.SC_NOT_FOUND;
        }
    }

    private HttpResponse sendRequest(String url) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            return client.execute(request);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




}
