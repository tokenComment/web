package com.hqz.demo.session.server;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.springframework.stereotype.Component;

@Component
public class MySessionListener implements HttpSessionListener {
    public MySessionListener() {
    }

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("session正在創建");
        MySessionContext.AddSession(httpSessionEvent.getSession());
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        System.out.println("session注銷中");
        MySessionContext.DelSession(session);
    }
}