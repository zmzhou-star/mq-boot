package com.github.zmzhoustar;

import java.util.Observable;

import lombok.Data;

/**
 * 观察目标：栈长
 * @title JavaStackObservable
 * @author zmzhou
 * @version 1.0
 * date 2021/4/2 11:58
 */
@Data
public class JavaStackObservable extends Observable {

    private String article;

    /**
     * 发表文章
     * @param article 文章
     */
    public void publish(String article){
        // 发表文章
        this.article = article;

        // 改变状态
        this.setChanged();

        // 通知所有观察者
        this.notifyObservers();
    }

}
