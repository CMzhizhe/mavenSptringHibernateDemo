package com.art.msh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 项目描述:
 *
 * @Author 高小雄
 * 创建时间:2017/7/5
 * 修改时间:
 */
@Controller
@RequestMapping("/mvc")
public class mvcController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
