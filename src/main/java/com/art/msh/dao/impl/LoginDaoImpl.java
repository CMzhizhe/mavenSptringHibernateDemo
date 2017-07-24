package com.art.msh.dao.impl;

import com.art.msh.base.BaseDaoImpl;
import com.art.msh.dao.LoginDao;
import com.art.msh.model.UserDomain;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;

/**
 * 项目描述:登录数据处理
 *
 * @Author 高小雄
 * 创建时间:2017/7/24
 * 修改时间:
 */
@Service
@Transactional
public class LoginDaoImpl extends BaseDaoImpl<UserDomain> implements LoginDao {

    /**
     * 方法描述:用户登录
     * 作者:高小雄
     * 创建时间 2017/7/24
     **/
    public boolean login(UserDomain userDomain) {
        boolean b = false;
        String hql = "from UserDomain t where t.account = ? and t.password = ?";
        UserDomain userDomain1 = (UserDomain) this.getSession().createQuery(hql).setParameter(0, userDomain.getAccount())
                .setParameter(1, userDomain.getPassword());
        if (userDomain1!=null){
            b = true;
        }
        return b;
    }

    /**
     * 方法描述:用户登录
     * 作者:高小雄
     * 创建时间 2017/7/24
     **/
    public UserDomain loginUserDomain(UserDomain userDomain) {
        String hql = "from UserDomain t where t.account = ? and t.password = ?";
        UserDomain userDomain1 = (UserDomain) this.getSession().createQuery(hql).setParameter(0, userDomain.getAccount())
                .setParameter(1, userDomain.getPassword());
        if (userDomain1!=null){
            return  userDomain1;
        }
        return new UserDomain();
    }

}
