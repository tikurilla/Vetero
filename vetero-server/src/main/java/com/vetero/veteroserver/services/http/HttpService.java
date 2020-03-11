package com.vetero.veteroserver.services.http;

import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class HttpService {
    public HttpResponse doRequest(HttpRequestBase method) {
        try(CloseableHttpResponse response = HttpClients.createDefault().execute(method)) {
            int statusCode = response.getStatusLine().getStatusCode();
            String body = null;
            if (statusCode != HttpStatus.SC_NO_CONTENT) {
                body = EntityUtils.toString(response.getEntity());
            }
            Header[] headers = response.getAllHeaders();
            return new HttpResponse(Arrays.asList(headers), statusCode, body);
        } catch (Exception e) {
            return new HttpResponse(-1, e.getMessage());
        } finally {
            method.releaseConnection();
        }
    }
}
