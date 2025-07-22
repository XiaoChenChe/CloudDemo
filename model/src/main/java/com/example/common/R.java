package com.example.common;

import lombok.Data;

/**
 * @Author: cjx
 * @CreateTime: 2025-07-21
 * @Description:
 * @Version:
 */

@Data
public class R {
    private Integer code;
    private String message;
    private Object data;

    public static R success(){
        R r = new R();
        r.setCode(200);
        return r;
    }

    public static R success(String message,Object data){
        R r = new R();
        r.setCode(200);
        r.setData(data);
        r.setMessage(message);
        return r;
    }

    public static R error(){
        R r = new R();
        r.setCode(500);
        return r;

    }

    public static R error(String message,Object data){
        R r = new R();
        r.setCode(500);
        r.setData(data);
        r.setMessage(message);
        return r;
    }


    public static R error(String message,Object data,Integer code){
        R r = new R();
        r.setCode(code);
        r.setData(data);
        r.setMessage(message);
        return r;
    }

}
