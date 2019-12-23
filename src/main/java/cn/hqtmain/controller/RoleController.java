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
import cn.hqtmain.exception.MyRuntimeException;
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
	private  static final  Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	/**
	* @Title: showNavRole
	* @Description: (查询角色方法)
	* @param @param map
	* @param @param request
	* @param @return
	* @param @throws MyRuntimeException    
	* @return String    
	* @throws
	 */
	@RequestMapping("/role")	
	public String showNavRole(ModelMap map,HttpServletRequest request) throws MyRuntimeException{
		try {	
			Admin admin=LoginSession.getSession();
			if(admin.getCompanyNumber().equals("201910001")){
				List<Role> roleList=roleServer.getRoleAll();		
				map.addAttribute("roleList",roleList);
			}else{
				List<Role> roleList=roleServer.getRoleByCid(admin.getCompanyId());		
				map.addAttribute("roleList",roleList);
			}	
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：角色信息查询模块  操作：进入模块  状态：OK!");
			return "role/hqt_role";			
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：角色信息查询   错误信息: "+e);
			throw new MyRuntimeException(e);
		}				
	}
	/**
	* @Title: showRoleAdd
	* @Description: (角色信息添加页面)
	* @param @param map
	* @param @param request
	* @param @return
	* @param @throws MyRuntimeException    
	* @return String    
	* @throws
	 */
	@RequestMapping("/hqt_roleadd")	
	public String showRoleAdd(ModelMap map,HttpServletRequest request) throws MyRuntimeException{
		try {	
			Admin admin=LoginSession.getSession();
			if(admin.getCompanyNumber().equals("201910001")){
				List<Company>companyList=companyServer.getCompanyAll();
				map.addAttribute("companyList",companyList);
			}else{
				List<Company>companyList=companyServer.getCompanyBycompanyId(admin.getCompanyId());
				map.addAttribute("companyList",companyList);
			}			
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：角色信息添加模块  操作：进入模块  状态：OK!");
			return "role/hqt_roleadd";			
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：角色信息添加   错误信息: "+e);
			throw new MyRuntimeException(e);
		}		
	}
	/**
	* @Title: handleAdd
	* @Description: (角色信息添加实现方法)
	* @param @param role
	* @param @param session
	* @param @param request
	* @param @return    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping(value = "/roleadd", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleAdd(Role role, HttpSession session,HttpServletRequest request)
	{	
		ResponseResult<Void> rr=roleServer.addRole(role, request);		
		return rr;
	}
	/**
	* @Title: hanldCompanyEdit
	* @Description: (角色信息编辑页面)
	* @param @param map
	* @param @param roleId
	* @param @param request
	* @param @return
	* @param @throws MyRuntimeException    
	* @return String    
	* @throws
	 */
	@RequestMapping("/hqt_roleedit")
	public String hanldCompanyEdit(ModelMap map,Integer roleId,HttpServletRequest request) throws MyRuntimeException{
		try {	
			List<Role> roleList=roleServer.getRoleByRoleId(roleId);
			map.addAttribute("roleList",roleList);		
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：角色信息编辑模块  操作：进入模块  状态：OK!");
			return "role/hqt_roleedit";		
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：角色信息编辑   错误信息: "+e);
			throw new MyRuntimeException(e);
		}
		
	}
	/**
	* @Title: handleEdit
	* @Description: (角色信息编辑实现方法)
	* @param @param role
	* @param @param session
	* @param @param request
	* @param @return    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping(value = "/roleedit", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleEdit(Role role, HttpSession session,HttpServletRequest request)
	{			
		ResponseResult<Void> rr=roleServer.updateRole(role, request);		
		return rr;
	}
	/**
	* @Title: handleDel
	* @Description: (角色信息删除实现放法)
	* @param @param roleId
	* @param @param session
	* @param @param request
	* @param @return    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping(value = "/roledel", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleDel(Integer roleId, HttpSession session,HttpServletRequest request)
	{			
		ResponseResult<Void> rr=roleServer.deleteRole(roleId, request);		
		return rr;
	}
}
