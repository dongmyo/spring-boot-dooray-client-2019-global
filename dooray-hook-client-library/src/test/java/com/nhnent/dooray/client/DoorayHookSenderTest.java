package com.nhnent.dooray.client;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class DoorayHookSenderTest {
    private static final String HOOK_URL = "https://hook.dooray.com/services/1387695619080878080"
                                           + "/2405059123166269395/W6zoIU6vTROvcXeu_UKzpg";

    @Test
    public void testSend() {
        DoorayHook doorayHook = new DoorayHook();
        doorayHook.setBotName("edu-bot");
        doorayHook.setText("Hello, Dooray!");

        DoorayHookSender doorayHookSender = new DoorayHookSender(new RestTemplate(), HOOK_URL);
        doorayHookSender.send(doorayHook);
    }

}
