package com.art.msh.service;

import com.art.msh.dao.CheckAppupDateServiceDao;
import com.art.msh.model.ProjectUpdateDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CheckAppupDateService {
	@Resource
	CheckAppupDateServiceDao checkDao;
	
	/**
	* 根据版本号查询数据库<br> 
	* 创建人： 高小雄<br> 
	* 创建时间： 2016年9月29日 下午10:05:19  
	* Copyright (c)2016 <br> 
	* @param versionNum  版本号
	* @return
	 */
	public ProjectUpdateDomain checkNewVersion(String versionNum){
		return checkDao.checkNewVersion(versionNum);
	}
}
