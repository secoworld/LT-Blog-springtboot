package com.liulongtao.ltblogs.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseVO implements Serializable {

    /**
     * 响应状态码，0-成功，1-失败
     */
    public int code;

    /**
     * 返回的信息
     */
    public String msg;

    /**
     * JSON格式的的响应数据
     */
    public Object data;

    /**
     * 返回成功：
     * @param data 成功返回的数据内容
     * @return
     */
    public static ResponseVO success(Object data){
        ResponseVO rv = new ResponseVO();
        rv.setCode(0);
        rv.setMsg("success");
        rv.setData(data);
        return rv;
    }

    public static ResponseVO error(){
        ResponseVO rv = new ResponseVO();
        rv.setCode(1);
        rv.setMsg("error");
        return rv;
    }

}
