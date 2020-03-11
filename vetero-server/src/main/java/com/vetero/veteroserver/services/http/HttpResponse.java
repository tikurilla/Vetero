package com.vetero.veteroserver.services.http;

import org.apache.http.Header;

import java.util.ArrayList;
import java.util.List;

public class HttpResponse {
    private List<Header> headers;
    private final int statusCode;
    private final String body;


    public HttpResponse(int statusCode, String body) {
        this.headers = new ArrayList<>();
        this.statusCode = statusCode;
        this.body = body;
    }

    public HttpResponse(List<Header> headers, int statusCode, String body) {
        this.headers = headers;
        this.statusCode = statusCode;
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }

    public List<Header> getHeaders() {
        if(headers == null) {
            headers = new ArrayList<>();
        }
        return headers;
    }
}
