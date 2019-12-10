package cn.hqtmain.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hqtmain.entity.Admin;
import cn.hqtmain.entity.Company;
import cn.hqtmain.entity.ResponseResult;
import cn.hqtmain.entity.Role;
import cn.hqtmain.service.ICompanyServer;
import cn.hqtmain.service.IRoleServer;
import cn.hqtmain.util.LoginSession;

/**
* @Title: RoleController.java
* @Package cn.hqtmain.controller
* @Description:(用一句话描述该文件做什么)
* @author: ZhouLingZhang
* @date 2019年11月26日
* @Copyright:好前途教育
* @version V1.0
*/
@Controller
public class RoleController {
	
	@Autowired
	public IRoleServer roleServer;
	@Resource
	public ICompanyServer companyServer;
	private  static final  Logger logger = LogManager.getLogger(RoleController.class.getName());
	
	
	@RequestMapping("/role")	
	public String showNavlogin(ModelMap map){
		Admin admin=LoginSession.getSession();
		if(admin.getCompanyNumber().equals("201910001")){
			List<Role> roleList=roleServer.getRoleAll();		
			map.addAttribute("roleList",roleList);
		}else{
			List<Role> roleList=roleServer.getRoleByCid(admin.getCompanyId());		
			map.addAttribute("roleList",roleList);
		}		
		return "role/hqt_role";	
	}
	@RequestMapping("/hqt_roleadd")	
	public String showRoleAdd(ModelMap map){		
		Admin admin=LoginSession.getSession();
		if(admin.getCompanyNumber().equals("201910001")){
			List<Company>companyList=companyServer.getCompanyAll();
			map.addAttribute("companyList",companyList);
		}else{
			List<Company>companyList=companyServer.getCompanyBycompanyId(admin.getCompanyId());
			map.addAttribute("companyList",companyList);
		}
		return "role/hqt_roleadd";	
	}
	@RequestMapping(value = "/roleadd", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleAdd(Role role, HttpSession session,HttpServletRequest request)
	{	
		ResponseResult<Void> rr=roleServer.addRole(role, request);		
		return rr;
	}
	@RequestMapping("/hqt_roleedit")
	public String hanldCompanyEdit(ModelMap map,Integer roleId){
		List<Role> roleList=roleServer.getRoleByRoleId(roleId);
		map.addAttribute("roleList",roleList);
		return "role/hqt_roleedit";
	}
	@RequestMapping(value = "/roleedit", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleEdit(Role role, HttpSession session,HttpServletRequest request)
	{			
		ResponseResult<Void> rr=roleServer.updateRole(role, request);		
		return rr;
	}
	
	@RequestMapping(value = "/roledel", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleDel(Integer roleId, HttpSession session,HttpServletRequest request)
	{			
		ResponseResult<Void> rr=roleServer.deleteRole(roleId, request);		
		return rr;
	}
}
