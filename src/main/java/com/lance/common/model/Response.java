package com.lance.common.model;

import lombok.Data;
import java.io.Serializable;

/**
 * Created by perdonare on 2015/8/16.
 */
@Data
public class Response<T> implements Serializable{
    private static final long serialVersionUID = 4282752337010638593L;

    public Response(){
        this.success = false;
    }

    public Response(String errorCode,String errorMsg){
        this.success = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Response(T body){
        this.success = true;
        this.body = body;
    }

    /**
     * 标识成功或失败
     */
    private boolean success ;
    /**
     * 业务码
     */
    private String errorCode;
    /**
     * 描述
     */
    private String errorMsg;
    /**
     * 具体业务数据
     */
    private T body;
}
