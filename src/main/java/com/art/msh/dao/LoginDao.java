package com.art.msh.dao;

import com.art.msh.base.BaseDao;
import com.art.msh.model.UserDomain;

/**
 * 项目描述:登录Dao
 *
 * @Author 高小雄
 * 创建时间:2017/7/24
 * 修改时间:
 */
public interface LoginDao extends BaseDao<UserDomain>{

    /**
     * 方法描述:登录
     * 作者:高小雄
     * 创建时间 2017/7/24
     * @param userDomain 用户对象
     **/
    public boolean login(UserDomain userDomain);

    /**
     * 方法描述:登录
     * 作者:高小雄
     * 创建时间 2017/7/24
     * @param userDomain 用户对象
     **/
    public UserDomain loginUserDomain(UserDomain userDomain);

}
