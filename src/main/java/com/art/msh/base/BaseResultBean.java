package com.art.msh.base;

import java.io.Serializable;

/**
 * 项目描述:返回手机端的类
 *
 * @Author 高小雄
 * 创建时间:2017/7/24
 * 修改时间:
 */
public class BaseResultBean<T> implements Serializable{
    public   String SUCCESS="1";//成功
    public   String FAILE="2";//失败
    private String message;//描述
    private String resultStatus;//状态
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setFaile(String value){
        this.message = value;
        this.resultStatus = FAILE;
    }

    public void setSuccess(T data){
        this.data = data;
        this.resultStatus = SUCCESS;
    }

    public void setSuccess(String value){
        this.message = value;
        this.resultStatus = SUCCESS;
    }


}
