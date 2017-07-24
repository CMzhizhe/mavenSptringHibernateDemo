package com.art.msh.controller;
import com.art.msh.model.ProjectUpdateDomain;
import com.art.msh.service.CheckAppupDateService;
import com.art.msh.utils.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
@SuppressWarnings({ "rawtypes" })
@Controller
@Scope("prototype")
@RequestMapping("/downFile")
public class DownFileController {
	@Resource
	CheckAppupDateService checkService;
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value ="/down")
	public Map HttpDownMap(HttpServletRequest request){
		Map<String, Object> reMap = new HashMap<String, Object>();
		Map<String, Map> map = new HashMap<String, Map>();
		String action = request.getParameter("action");
		if(action==null){
			action="checkNewVersion";
		}
		
		if(action.equals("checkNewVersion")){
			map = Down(request);
			return map;
		}
		
		reMap.put("reInfos", "暂时查询不到您需要业务");
		reMap.put("AICODE", "2");
		map.put("resultMap", reMap);
		return map;
	}
	
	/**
	* 查询是否有新的版本<br> 
	* 创建人： 高小雄<br> 
	* 创建时间： 2016年9月29日 下午10:00:23  
	* Copyright (c)2016 <br> 
	* @param request
	* @return
	 */
	private Map Down(HttpServletRequest request){
		Map<String, Object> reMap = new HashMap<String, Object>();
		Map<String, Map> map = new HashMap<String, Map>();
		String versionNum = request.getParameter("versionNum");
		if(StringUtils.isEmptyOrNull(versionNum)){
			reMap.put("reInfos", "版本号不能为空");
			reMap.put("AICODE", "2");
			map.put("resultMap", reMap);
			return map;
		}
		ProjectUpdateDomain bean = checkService.checkNewVersion(versionNum);
		reMap.put("AICODE", "1");
		reMap.put("reInfos", bean);
		map.put("resultMap", reMap);
		return map;
	}
	
}
