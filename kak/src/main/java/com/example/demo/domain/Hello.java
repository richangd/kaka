package com.example.demo.domain;

public class Hello {
    private String msg;
    private String msg2;
    private int msg3;
    private String msg4;

    public Hello(String msg) {
        this.msg = msg;
    }
    
    public Hello(String msg, String msg2) {
        this.msg = msg2;
        this.msg2 = msg;
    }
    
    public Hello(String msg, String msg2, int msg3, String msg4) {
        if(msg.equals("sdmail@kr.canon") && msg2.equals("solrnd0803!@")) {
        	msg = "SUCCESS";
        	msg2 = "AUTH_SUCCESS";
        	msg3 = 200;
        	msg4 = "OK";
        }else {
        	msg = "FAILURE";
        	msg2 = "AUTH_FAIL";
        	msg3 = 401;
        	msg4 = "Unauthorized";
        }
    	this.msg = msg;
        this.msg2 = msg2;
        this.msg3 = msg3;
        this.msg4 = msg4;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public String getMsg2() {
        return msg2;
    }

    public void setMsg2(String msg2) {
        this.msg2 = msg2;
    }
    
    public int getMsg3() {
        return msg3;
    }

    public void setMsg3(int msg3) {
        this.msg3 = msg3;
    }
    
    public String getMsg4() {
        return msg4;
    }

    public void setMsg4(String msg4) {
        this.msg4 = msg4;
    }
}