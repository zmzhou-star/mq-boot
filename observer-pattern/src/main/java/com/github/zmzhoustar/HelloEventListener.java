package com.github.zmzhoustar;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 * @title HelloEventListener
 * @author zmzhou
 * @version 1.0
 * date 2021/4/9 14:48
 */
@Slf4j
@Component
public class HelloEventListener implements ApplicationListener<UserEvent> {

    @Override
    public void onApplicationEvent(UserEvent event) {
        log.info("receive {}", event);
    }
}
