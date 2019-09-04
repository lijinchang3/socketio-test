package com.zhoujw.socketiotest.test2;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;

import java.util.Collection;

/**
 * SocketIo 执行工具类
 *
 * @author: zhoujw
 * @Date: 2018-08-02
 */
public class Socketio {

    static SocketIOServer socketIOServer;

    /**
     * 添加客户端
     */
    public void startSocketio() throws InterruptedException {
        //配置
        Configuration config = new Configuration();
        //指定要主机ip地址，与页面请求ip保持一致
        config.setHostname("localhost");
        //指定端口号
        config.setPort(9092);
        //设置最大的webSocket帧内容长度限制
        config.setMaxFramePayloadLength(1024*1024);
        //设置最大的Http内容长度限制
        config.setMaxHttpContentLength(1024*1024);

        socketIOServer = new SocketIOServer(config);

        ConnectListener connect = new ConnectListener() {
            @Override
            public void onConnect(SocketIOClient socketIOClient) {
                //todo -> 客户端检验？ 客户端详操？
                System.out.println("添加");
            }
        };

        //添加客户端
        socketIOServer.addConnectListener(connect);
        socketIOServer.start();

        //设置超时时间
        Thread.sleep(Integer.MAX_VALUE);

        socketIOServer.stop();

    }


    /**
     * 全体消息推送
     * @param type 前台根据类型接收消息，所以接收的消息类型不同，收到儿都通知就不同 => 推送事件类型 /todo 类型可以设置成 监听分组？
     * @param content
     */
    public void pushArr(String type,String content) throws InterruptedException {
//        if (socketIOServer == null){
//            startSocketio();
//        }
        //获取全部客户端
        Collection<SocketIOClient> allClients = socketIOServer.getAllClients();
        for (SocketIOClient clientSocket: allClients) {

            /*
               todo 客户端支持操作
                void send(Packet var1);
                void disconnect();
                void sendEvent(String var1, Object... var2);
             */
            clientSocket.sendEvent(type,content);
        }
    }

    /**
     * 启动服务
     */
    public void startServer(){
        if (socketIOServer == null) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        startSocketio();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    /**
     * 停止服务
     */
    public void stopServer(){
        if (socketIOServer != null) {
            socketIOServer.stop();
            socketIOServer = null;
        }
    }

}
