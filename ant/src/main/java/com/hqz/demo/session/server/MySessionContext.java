package com.hqz.demo.session.server;

import java.util.HashMap;
import javax.servlet.http.HttpSession;

public class MySessionContext {
    private static HashMap mymap = new HashMap();

    public MySessionContext() {
    }

    public static synchronized void AddSession(HttpSession session) {
        if (session != null) {
            mymap.put(session.getId(), session);
        }

    }

    public static synchronized void DelSession(HttpSession session) {
        if (session != null) {
            mymap.remove(session.getId());
        }

    }

    public static synchronized HttpSession getSession(String session_id) {
        return session_id == null ? null : (HttpSession)mymap.get(session_id);
    }
}