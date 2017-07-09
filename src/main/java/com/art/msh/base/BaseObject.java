package com.art.msh.base;

import java.util.List;

/**
 * 项目描述:封装对象
 *2、封装错误
 *
 * @Author 高小雄
 * 创建时间:2017/7/9
 * 修改时间:
 */
public class BaseObject<T> {
    private String errorMessage;//错误信息
    private T obj;//对象
    private String code;//状态1成功 2失败
    private List<T> objectList;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<T> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<T> objectList) {
        this.objectList = objectList;
    }
}
