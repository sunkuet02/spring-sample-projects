package com.sunkuet02.springboot2.client.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import java.io.IOException;

/**
 *
 * @author Ataur Rahman
 */
public class PartnerResponseErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        HttpStatus statusCode = response.getStatusCode();
        switch (statusCode.series()) {
            case CLIENT_ERROR:
                break;
            case SERVER_ERROR:
                break;
            default:
                throw new UnknownHttpStatusCodeException(statusCode.value(), response.getStatusText(),
                        response.getHeaders(), getResponseBody(response), getCharset(response));
        }
    }
    
}
