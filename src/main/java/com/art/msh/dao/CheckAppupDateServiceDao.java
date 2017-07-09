package com.art.msh.dao;


import com.art.msh.base.BaseDao;
import com.art.msh.model.ProjectUpdateDomain;

public interface CheckAppupDateServiceDao extends BaseDao<ProjectUpdateDomain> {
	ProjectUpdateDomain checkNewVersion(String versionNum); //检测版本号
}
