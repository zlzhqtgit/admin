package cn.hqtmain.controller;


import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.hqtmain.entity.Company;
import cn.hqtmain.entity.ResponseResult;
import cn.hqtmain.exception.MyRuntimeException;
import cn.hqtmain.service.ICompanyServer;
import cn.hqtmain.util.LoginSession;


/**
* @Title: CompanyController.java
* @Package cn.hqtmain.controller
* @Description:(用一句话描述该文件做什么)
* @author: ZhouLingZhang
* @date 2019年12月3日
* @Copyright:好前途教育
* @version V1.0
*/
@Controller
public class SystemController {
	
	@Resource
	public ICompanyServer companyServer;
	private  static final  Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	
	
	/**
	* @Title: hanldSystem
	* @Description: (后台系统参数页面)
	* @param @param map
	* @param @param request
	* @param @return
	* @param @throws MyRuntimeException    
	* @return String    
	* @throws
	 */
	@RequestMapping("/hqt_system")
	public String  hanldSystem(ModelMap map,HttpServletRequest request) throws MyRuntimeException{
		try {			
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：系统参数模块  操作：进入模块  状态：OK!");
			return "system/hqt_system";
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：系统参数模块   错误信息: "+e);
			throw new MyRuntimeException(e);
		}					
	}
	/**
	* @Title: hanldCompany
	* @Description: (单位信息页面)
	* @param @param map
	* @param @param request
	* @param @return
	* @param @throws MyRuntimeException    
	* @return String    
	* @throws
	 */
	@RequestMapping("/hqt_company")
	public String hanldCompany(ModelMap map,HttpServletRequest request) throws MyRuntimeException{
		try {		
			List<Company> companyList=companyServer.getCompanyAll();		
			map.addAttribute("companyList", companyList);				
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：单位信息模块  操作：进入模块  状态：OK!");
			return "system/hqt_company";
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：单位信息模块   错误信息: "+e);
			throw new MyRuntimeException(e);
		}			
	}
	/**
	* @Title: hanldCompanyAdd
	* @Description: (单位信息添加)
	* @param @param map
	* @param @param request
	* @param @return
	* @param @throws MyRuntimeException    
	* @return String    
	* @throws
	 */
	@RequestMapping("/hqt_companyadd")
	public String hanldCompanyAdd(ModelMap map,HttpServletRequest request) throws MyRuntimeException{
		try {							
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：单位信息添加模块  操作：进入模块  状态：OK!");
			return "system/hqt_companyadd";
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：单位信息添加模块   错误信息: "+e);
			throw new MyRuntimeException(e);
		}			
	}
	
	/**
	* @Title: hanldCompanyEdit
	* @Description: (单位信息编辑)
	* @param @param map
	* @param @param companyId
	* @param @param request
	* @param @return
	* @param @throws MyRuntimeException    
	* @return String    
	* @throws
	 */
	@RequestMapping("/hqt_companyedit")
	public String hanldCompanyEdit(ModelMap map,Integer companyId,HttpServletRequest request) throws MyRuntimeException{
		try {
			List<Company> companyList=companyServer.getCompanyBycompanyId(companyId);
			map.addAttribute("companyList",companyList);			
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：单位信息编辑模块  操作：进入模块  状态：OK!");
			return "system/hqt_companyedit";
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：单位信息编辑模块   错误信息: "+e);
			throw new MyRuntimeException(e);
		}	
		
	}
	/**
	* @Title: handleAdd
	* @Description: (单位信息添加实现方法)
	* @param @param company
	* @param @param session
	* @param @param request
	* @param @return    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping(value = "/companyadd", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleAdd(Company company, HttpSession session,HttpServletRequest request)
	{			
		ResponseResult<Void> rr=companyServer.addCompany(company, request);		
		return rr;
	}
	/**	
	* @Title: handleDel
	* @Description: (单位信息删除实现方法)
	* @param @param companyId
	* @param @param session
	* @param @param request
	* @param @return    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping(value = "/companydel", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleDel(Integer companyId, HttpSession session,HttpServletRequest request)
	{			
		ResponseResult<Void> rr=companyServer.deleteCompany(companyId, request);		
		return rr;
	}
	/**
	* @Title: handleEdit
	* @Description: (单位信息编辑实现方法)
	* @param @param company
	* @param @param session
	* @param @param request
	* @param @return    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping(value = "/companyedit", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleEdit(Company company, HttpSession session,HttpServletRequest request)
	{			
		ResponseResult<Void> rr=companyServer.updateCompany(company, request);		
		return rr;
	}
}
