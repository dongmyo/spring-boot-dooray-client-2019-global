package com.nhnent.edu.spring_boot.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

// TODO : #5 application.properties 에서 `dooray.hook-url` 을 받을 수 있도록 속성을 선언하세요.
//        cf.) @ConfigurationProperties 사용.
@ConfigurationProperties("dooray")
public class DoorayProperties {
    private String hookUrl;


    public String getHookUrl() {
        return hookUrl;
    }

    public void setHookUrl(String hookUrl) {
        this.hookUrl = hookUrl;
    }

}
