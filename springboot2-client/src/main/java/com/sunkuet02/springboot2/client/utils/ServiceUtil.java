/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunkuet02.springboot2.client.utils;

import com.sunkuet02.springboot2.client.config.PartnerResponseErrorHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 *
 * @author Ataur Rahman
 */


public class ServiceUtil {

    public static final String HOST = "http://api.sunkuet02.service-host.com";

    public static final String PORT = ":7003";

    public static final String SERVICE_PATH = "/service";

    public static final String AUTH_SERVER_URI = HOST + PORT + SERVICE_PATH+ "/auth/login";

    public static String cookieName;

    @Value("${auth.cookie.name}")
    public void setCookieName(String value) {
        this.cookieName = value;
    }

    public  <T, R> T sendHttpRequest(HttpMethod method, String url, R requestObject, HttpServletRequest request, Class<T> clazz) throws Exception {
        Cookie cookieValue = WebUtils.getCookie(request, cookieName);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        if (cookieValue != null && !cookieValue.getValue().isEmpty() && !url.contains("login")) {
            headers.add("Authorization", "Bearer " + cookieValue.getValue());
        }

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.setErrorHandler(new PartnerResponseErrorHandler());

        HttpEntity<R> requestEntity = new HttpEntity<>(requestObject, headers);

        try {
            ResponseEntity<T> response = restTemplate.exchange(url, method, requestEntity, clazz);

            if (response.hasBody()) {
                return response.getBody();

            } else {
                throw new Exception("No Response from Server! Contact with administrator");
            }
        } catch (Exception ex) {
            throw new Exception("Service is unavailable! Contact with administrator");
        }
    }
}
