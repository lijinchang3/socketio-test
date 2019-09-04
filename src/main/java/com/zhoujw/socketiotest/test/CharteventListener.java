package com.zhoujw.socketiotest.test;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

/**
 * todo 加点注释
 *
 * @author: zhoujw
 * @Date: 2018-08-02
 */
public class CharteventListener implements DataListener<ChatObject>{

    SocketIOServer server;

    public void setServer(SocketIOServer server) {
        this.server = server;
    }

    @Override
    public void onData(SocketIOClient client, ChatObject data,
                       AckRequest ackSender) throws Exception {
        // chatevent为 事件的名称， data为发送的内容
        this.server.getBroadcastOperations().sendEvent("chatevent", data);
    }
}
