package com.zhoujw.socketiotest.test2.controller;

import com.zhoujw.socketiotest.test2.Socketio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * todo 加点注释
 *
 * @author: zhoujw
 * @Date: 2018-08-02
 */

@Controller
public class IndexController {

    @GetMapping("/")
    public String getIndex(){
        return "netty";
    }
    @GetMapping("test")
    public  String getTest()
    {
        return  "test";
    }

}
