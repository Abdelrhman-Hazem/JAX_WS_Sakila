package com.iti.jets.sakilaJax.util;

import jakarta.persistence.EntityManager;

public class RequestThreadLocal extends  ThreadLocal<EntityManager>{
    private volatile static RequestThreadLocal instance;
    private RequestThreadLocal() {}

    public static RequestThreadLocal getInstance(){

        if(instance == null){
            instance = new RequestThreadLocal();
        }
        return instance;
    }
}
