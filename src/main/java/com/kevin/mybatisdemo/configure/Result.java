package com.kevin.mybatisdemo.configure;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;

@Data
@Getter
public class Result<T,L> {
    // 接口调用成功或者失败
    private Integer code = 0;
    // 失败的具体code
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorCode ;
    // 需要传递的信息，例如错误信息
    private String msg;
    // 需要传递的数据
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private L list;

    public static <T,L> Result<T,L> success(T t) {
        Result<T,L> result = new Result<>();
        result.code = 200;
        result.msg = "ok";
        result.data = t;
//        result.list= (L) new ArrayList();
        return result;
    }

    public static <T,L> Result<T,L> successList(T data,L list) {
        Result<T,L> result = new Result<>();
        result.code = 200;
        result.msg = "ok";
        result.list = list;
//        result.data = data;
        return result;
    }

    public static Result<Object,Object> failed(String message) {
        Result<Object,Object> result = new Result<>();
        result.code = 500;
        result.errorCode = "500";
        result.msg = message;
        return result;
    }
    public Result(){

    }

    public Result(T data){
        this.data = data;
    }
    public Result(T data,String msg){
        this.data = data;
        this.msg = msg;
    }

//    public String getErrorCode() {
//        return errorCode;
//    }
//
//    public void setErrorCode(String errorCode) {
//        this.errorCode = errorCode;
//    }

//    public Integer getCode() {
//        return code;
//    }
//
//    public void setCode(Integer code) {
//        this.code = code;
//    }

//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
}