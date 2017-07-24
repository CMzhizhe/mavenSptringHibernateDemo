package com.art.msh.controller;

import com.art.msh.base.BaseResultBean;
import com.art.msh.model.UserDomain;
import com.art.msh.service.LoginService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目描述:登录
 * @Author 高小雄
 * 创建时间:2017/7/24
 * 修改时间:
 */
@Controller
@Scope("prototype")
@RequestMapping("/LoginCon")
public class LoginController {
    @Resource
    LoginService loginService;

    @ResponseBody
    @RequestMapping(value ="/login",method = RequestMethod.POST)
    public BaseResultBean HttpLoginMap(HttpServletRequest request, @RequestBody UserDomain u ){
        BaseResultBean<UserDomain> baseResultBean = new BaseResultBean<UserDomain>();
        UserDomain userDomain = loginService.loginUserDomain(u);
        if (userDomain==null){
            baseResultBean.setFaile("暂无数据");
        }else if (userDomain.getAccount()==null||userDomain.getPassword()==null){
            baseResultBean.setFaile("暂无数据");
        }else {
            baseResultBean.setSuccess(userDomain);
        }
        return baseResultBean;
    }



}
