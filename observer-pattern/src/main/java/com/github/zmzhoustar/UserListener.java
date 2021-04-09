package com.github.zmzhoustar;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * EventListener监听实现
 *
 * @author zmzhou
 * @version 1.0
 * date 2021/4/9 14:36
 * @title UserListener
 */
@Slf4j
@Component
public class UserListener {

	@EventListener
	public void getUserEvent(UserEvent userEvent) {
		log.info("getUserEvent-接受到事件：{}", userEvent);
	}
}
