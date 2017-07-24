package com.art.msh.service;

import com.art.msh.dao.LoginDao;
import com.art.msh.model.UserDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 项目描述:
 *
 * @Author 高小雄
 * 创建时间:2017/7/24
 * 修改时间:
 */
@Service
public class LoginService {
    @Resource
    LoginDao loginDao;

    /**
     * 方法描述:登录验证,验证账号密码是否正确
     * 作者:高小雄
     * 创建时间 2017/7/24
     **/
    public boolean login(UserDomain userDomain){
        boolean b = false;
        if (userDomain==null){
            return b;
        }else if (userDomain.getAccount()==null||userDomain.getPassword()==null){
            return b;
        }
        b =  loginDao.login(userDomain);
        return b;
    }



    /**
     * 方法描述:登录验证,验证账号密码是否正确
     * 作者:高小雄
     * 创建时间 2017/7/24
     **/
    public UserDomain loginUserDomain(UserDomain userDomain){
        if (userDomain==null){
            return new UserDomain();
        }else if (userDomain.getAccount()==null||userDomain.getPassword()==null){
            return new UserDomain();
        }
        UserDomain userDomain1 =  loginDao.loginUserDomain(userDomain);
        return userDomain1;
    }

}
