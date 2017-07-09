package com.art.msh.dao.impl;

import com.art.msh.base.BaseDaoImpl;
import com.art.msh.base.BaseObject;
import com.art.msh.dao.CheckAppupDateServiceDao;
import com.art.msh.model.ProjectUpdateDomain;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * <br> 
* 项目名称：gongzhi02 <br> 
* 类名称：CheckAppupDateServiceImpl <br> 
* 类描述：检查APP升级实现类 <br>  
* 创建人：高小雄<br> 
* 创建时间：2016年9月29日 下午9:55:04 <br> 
* 修改人： <br> 
* 修改时间： <br> 
* 修改备注： <br> 
* @version V1.0
 */
@Service
@Transactional
public class CheckAppupDateServiceImpl extends BaseDaoImpl<ProjectUpdateDomain> implements CheckAppupDateServiceDao {

	/**
	 * 
	* 检测版本号，APP是否需要更新<br>  
	* 创建人：高小雄 <br> 
	* 创建时间： 2016年9月29日 下午10:06:23   
	* @param versionNum  版本号
	* @return   
	 */
	@Override
	public ProjectUpdateDomain checkNewVersion(String versionNum) {
		Integer inVersionNum = Integer.parseInt(versionNum);
		StringBuffer stringBuffer = new StringBuffer("from ProjectUpdateDomain j where j.isNeedUpdate=1 and j.newVersionCode>:newVersionCode  ");
		ProjectUpdateDomain bean = (ProjectUpdateDomain)this.getSession().createQuery(stringBuffer.toString())
				.setParameter("newVersionCode", inVersionNum).uniqueResult();
		if(bean!=null){
			return bean;
		}
		return null;
	}


	/**
	 * 方法描述:获取下载文件路径
	 * 作者:高小雄
	 * 创建时间 2017/7/9
	 **/
	public BaseObject<ProjectUpdateDomain> downObj(){

		return null;
	}

}
