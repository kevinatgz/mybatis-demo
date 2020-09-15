package com.kevin.mybatisdemo.configure;

public class AlertException extends  Exception{
    private String retCode;
    private String message;

    public AlertException(String code,String message) {
        super(message);
        this.retCode = code;
    }

    public String getRetCode() {
        return this.retCode;
    }

    public void setRetCode(String code) {
        this.retCode = code;
    }
}
