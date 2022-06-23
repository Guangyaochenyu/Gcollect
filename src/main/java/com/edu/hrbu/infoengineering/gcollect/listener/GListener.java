package com.edu.hrbu.infoengineering.gcollect.listener;
import com.edu.hrbu.infoengineering.gcollect.util.Init;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebListener
public class GListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    public GListener() {}
    @Override public void contextInitialized(ServletContextEvent sce) {
        Init.getInstance();
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("PageView",0);
    }
    @Override public void contextDestroyed(ServletContextEvent sce) {}
    @Override public void sessionCreated(HttpSessionEvent se) {}
    @Override public void sessionDestroyed(HttpSessionEvent se) {}
    @Override public void attributeAdded(HttpSessionBindingEvent sbe) {}
    @Override public void attributeRemoved(HttpSessionBindingEvent sbe) {}
    @Override public void attributeReplaced(HttpSessionBindingEvent sbe) {}
}