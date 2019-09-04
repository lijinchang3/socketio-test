package com.zhoujw.socketiotest.test;

/**
 * todo 加点注释
 *
 * @author: zhoujw
 * @Date: 2018-08-02
 */
public class ChatObject {

    private String userName;
    private String message;

    public ChatObject() {
    }

    public ChatObject(String userName, String message) {
        super();
        this.userName = userName;
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
