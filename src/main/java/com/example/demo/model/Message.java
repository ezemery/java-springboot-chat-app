package com.example.demo.model;

public class Message {
    private Integer messageid;
    private String username;
    private String messagetext;

//    public Message(Integer messageid, String username, String message){
//        this.messageid = messageid;
//        this.message = message;
//        this.username = username;
//    }

    public int getMessageid() {
        return messageid;
    }

    public void setMessageid(int messageid) {
        this.messageid = messageid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return messagetext;
    }

    public void setMessage(String message) {
        this.messagetext = message;
    }
}
