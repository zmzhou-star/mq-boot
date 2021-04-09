package com.github.zmzhoustar;

import org.springframework.context.ApplicationEvent;

/**
 * 事件
 * @title UserEvent
 * @author zmzhou
 * @version 1.0
 * date 2021/4/9 14:32
 */
public class UserEvent extends ApplicationEvent {

    /**
     *  实现父类方法
     * @param source 数据源
     */
    public UserEvent(Object source) {
        super(source);
    }
}
