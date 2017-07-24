package com.art.msh.model;

import java.io.Serializable;

/**
 * 项目描述:用户类
 *
 * @Author 高小雄
 * 创建时间:2017/7/24
 * 修改时间:
 */
public class UserDomain implements Serializable {
    private String account;//账号
    private String password;//密码
    private Integer id;
    private String idCard;//身份证
    private String userIcon;//用户头像
    private String userName;//用户名称
    private String userSex;//性别
    private String userNotes;//描述

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserNotes() {
        return userNotes;
    }

    public void setUserNotes(String userNotes) {
        this.userNotes = userNotes;
    }
}
