package com.nhnent.dooray.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class DoorayHookSender {
    private final RestTemplate restTemplate;

    private final String url;


    public DoorayHookSender(RestTemplate restTemplate, String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }


    public void send(DoorayHook doorayHook) {
        HttpEntity<DoorayHook> httpEntity = new HttpEntity<DoorayHook>(doorayHook, new HttpHeaders());
        restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
    }

}
