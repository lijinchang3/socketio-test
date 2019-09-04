package com.zhoujw.socketiotest.test2.controller;

import com.zhoujw.socketiotest.test2.Socketio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * todo 加点注释
 *
 * @author: zhoujw
 * @Date: 2018-08-02
 */
@Controller
public class NettyController {

    @GetMapping("/pushArr")
    public void sendSocMsg() throws InterruptedException {
        System.out.println("给全体人员发送消息");
        Socketio socketio = new Socketio();
        socketio.pushArr("connect_msg","Hello,World");
    }

}
