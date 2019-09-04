package com.zhoujw.socketiotest.test2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听器启动
 *
 * @author: zhoujw
 * @Date: 2018-08-02
 */
@WebListener
public class SocketListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //启动监听服务
        Socketio socketio = new Socketio();
        socketio.startServer();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //关闭Socketio服务
        Socketio socketio = new Socketio();
        socketio.stopServer();
    }
}
