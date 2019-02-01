package com.nhnent.edu.spring_boot.starter;

import com.nhnent.dooray.client.DoorayHookSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration

// TODO : #1 DoorayHookSender.class 가 classpath에 존재할 때 DoorayAutoConfiguration가 동작하도록 한다.
@ConditionalOnClass(DoorayHookSender.class)

// TODO : #2 `dooray.hook-url` 속성이 정의되어 있을때 DoorayAutoConfiguration가 동작하도록 한다.
@ConditionalOnProperty("dooray.hook-url")

@EnableConfigurationProperties(DoorayProperties.class)
public class DoorayAutoConfig {
    @Autowired
    private DoorayProperties doorayProperties;


    // TODO : #3 RestTemplate 타입의 빈이 선언되어 있지 않으면 아래 빈이 생성되도록 수정하세요.
    @ConditionalOnMissingBean(RestTemplate.class)
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }

    // TODO : #4 DoorayHookSender 빈이 생성되도록 코드를 작성하세요.
    @Bean
    public DoorayHookSender doorayHookSender(RestTemplate restTemplate) {
        return new DoorayHookSender(restTemplate, doorayProperties.getHookUrl());
    }

}