package com.github.zmzhoustar;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * 发送事件
 *
 * @author zmzhou
 * @version 1.0
 * date 2021/4/9 14:33
 * @title UserService
 */
@Service("eventUserService")
public class UserService implements ApplicationContextAware, ApplicationEventPublisherAware {

	private ApplicationContext applicationContext;
	private ApplicationEventPublisher applicationEventPublisher;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	public UserVo addUser(UserVo user) {
		// 保存用户
		// 发生事件（发邮件、发短信、、、）
		applicationContext.publishEvent(new UserEvent(user));
		// 两种发生方式一致
		applicationEventPublisher.publishEvent(new UserEvent(user));
		return user;
	}
}
