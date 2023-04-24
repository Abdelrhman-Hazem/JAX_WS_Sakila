package com.iti.jets.sakilaJax.util;

import com.iti.jets.sakilaJax.persistence.connection.EntityManagerFactorySingleton;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class SessionListenerForEntityManager implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent se) {
        RequestThreadLocal.getInstance().set(EntityManagerFactorySingleton.getInstance().createEntityManager());
        System.out.println("-------------Entity Manager Created------------------");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent se) {
        RequestThreadLocal.getInstance().get().close();
        RequestThreadLocal.getInstance().remove();
        System.out.println("-------------Entity Manager Destroyed------------------");
    }
}

//import com.iti.jets.sakilaJax.persistence.connection.EntityManagerFactorySingleton;
//        import jakarta.servlet.http.HttpSessionEvent;
//        import jakarta.servlet.http.HttpSessionListener;
//
//public class SessionListenerForEntityManager implements HttpSessionListener {
//    @Override
//    public void sessionCreated(HttpSessionEvent se) {
//
//        RequestThreadLocal.getInstance().set(EntityManagerFactorySingleton.getInstance().createEntityManager());
//        System.out.println("-------------Entity Manager Created------------------");
//    }
//
//    @Override
//    public void sessionDestroyed(HttpSessionEvent se) {
//        System.out.println("-------------Entity Manager Destroyed------------------");
//        RequestThreadLocal.getInstance().get().close();
//        RequestThreadLocal.getInstance().remove();
//    }
//}
