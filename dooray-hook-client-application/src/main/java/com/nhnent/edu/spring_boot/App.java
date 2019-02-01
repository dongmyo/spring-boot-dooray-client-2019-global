package com.nhnent.edu.spring_boot;

import com.nhnent.dooray.client.DoorayHook;
import com.nhnent.dooray.client.DoorayHookSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
    // TODO : #10 DoorayHookSender를 의존성 주입받으세요.
    //        cf.) @Autowired
    @Autowired
    private DoorayHookSender doorayHookSender;


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    // TODO : #11 ApplicationReady 일때, DoorayHookSender로 hook을 발송하는 빈을 선언하세요.
    @Bean
    public ApplicationListener<ApplicationReadyEvent> applicationListener() {
        return new ApplicationListener<ApplicationReadyEvent>() {
            @Override
            public void onApplicationEvent(ApplicationReadyEvent event) {
                DoorayHook doorayHook = new DoorayHook();
                doorayHook.setBotName("dooray-hook-bot");
                doorayHook.setText("My Name is dongmyo, Nice to meet ya!");

                doorayHookSender.send(doorayHook);
            }
        };
    }

}
