package com.robben.bbs.util;public enum ResultStatus {    SUCCESS(1,"成功"),FAILED(0,"失败");    ResultStatus(Integer code,String msg){        this.code=code;        this.msg=msg;    }    private Integer code;    private String msg;    public Integer getCode() {        return code;    }    public void setCode(int code) {        this.code = code;    }    public String getMsg() {        return msg;    }    public void setMsg(String msg) {        this.msg = msg;    }}