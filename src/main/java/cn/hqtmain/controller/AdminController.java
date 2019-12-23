package cn.hqtmain.controller;



import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import cn.hqtmain.entity.Role;
import cn.hqtmain.exception.MyRuntimeException;
import cn.hqtmain.entity.ResponseResult;
import cn.hqtmain.service.IAdminServer;
import cn.hqtmain.service.ICompanyServer;
import cn.hqtmain.service.IRoleServer;
import cn.hqtmain.util.LoginSession;




@Controller
public class AdminController
{
	@Autowired
	public IAdminServer adminServer;
	@Autowired
	public IRoleServer roleServer;
	@Autowired
	public ICompanyServer companyServer;
	
	private  static final  Logger logger = LogManager.getLogger(AdminController.class.getName());
	
	
	/**
	 * @throws MyRuntimeException 	
	* @Title: showhqtadminList
	* @Description: (用户浏览页面)
	* @param @param map
	* @param @param session
	* @param @param response
	* @param @param request
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("/hqt_admin")	
	public String showhqtadminList(ModelMap map,HttpSession session,HttpServletResponse response,HttpServletRequest request) throws MyRuntimeException{	
		try {
			List<Admin> adminAlllist=adminServer.getuserAll();
			map.addAttribute("adminAlllist",adminAlllist);		
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：用户资料模块  操作：进入模块  状态：OK!");
			return "admin/hqt_admin";	
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：用户资料模块  错误信息: "+e);
			throw new MyRuntimeException(e);
		}							
	}
	
	/**
	 * @throws MyRuntimeException 
	* @Title: showhqtadminPassword
	* @Description: (后台用户密码修改页面)
	* @param @param map
	* @param @param session
	* @param @param request
	* @param @param response
	* @param @return    
	* @return String    
	* @throws
	 */	
	@RequestMapping("/hqt_admin_password.do")	
	public String showhqtadminPassword(ModelMap map,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws MyRuntimeException{
		try {
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：用户密码修改  操作：进入模块  状态：OK!");
			return  "main/admin/hqt_admin_password";	
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：用户密码修改模块  错误信息: "+e);
			throw new MyRuntimeException(e);
		}
										
	}
	/**
	 * @throws MyRuntimeException 	
	* @Title: hqtadminAdd
	* @Description: (后台添加用户页面)
	* @param @param map
	* @param @param session
	* @param @param request
	* @param @param response
	* @param @return
	* @param @throws MyRuntimeException    
	* @return String    
	* @throws
	 */
	@RequestMapping("/hqt_adminadd")	
	public String hqtadminAdd(ModelMap map,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws MyRuntimeException{
		try {
			List<Company> companyList=companyServer.getCompanyAll();
			map.addAttribute("companyList", companyList);		
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：进入添加用户模块   操作：进入模块  状态：OK!");
			return "admin/hqt_adminadd";	
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：用户密码修改模块  错误信息: "+e);
			throw new MyRuntimeException(e);
		}					
	}
	
	/**
	* @Title: handleAdd
	* @Description: (后台用户添加实现方法)
	* @param @param admin
	* @param @param session
	* @param @param request
	* @param @return    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping(value = "/adminadd", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleAdd(Admin admin, HttpSession session,HttpServletRequest request)
	{	
		ResponseResult<Void> rr=adminServer.addAdmin(admin, request);		
		return rr;
	}
	/**
	* @Title: handleRoleList
	* @Description: (项目角色查询方法)
	* @param @param companyId
	* @param @param session
	* @param @param request
	* @param @return    
	* @return ResponseResult<List<Role>>    
	* @throws
	 */
	@RequestMapping(value = "/roleList", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<List<Role>> handleRoleList(Integer  companyId, HttpSession session,HttpServletRequest request)
	{		
		ResponseResult<List<Role>> rr=roleServer.getRoleByRoleCid(companyId);		
		return rr;
	}
	/**
	* @Title: hqtadminEdit
	* @Description: (后台用户编辑页面)
	* @param @param map
	* @param @param id
	* @param @param session
	* @param @param request
	* @param @param response
	* @param @return
	* @param @throws MyRuntimeException    
	* @return String    
	* @throws
	 */
	@RequestMapping("/hqt_adminedit")	
	public String hqtadminEdit(ModelMap map,Integer id,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws MyRuntimeException{
		try {
			List<Admin> adminList=adminServer.getuserByid(id);
			List<Role> roleList=roleServer.getRoleAll();
			map.addAttribute("adminList", adminList);
			map.addAttribute("roleList", roleList);
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：用户编辑模块   操作：进入模块  状态：OK!");
			return "admin/hqt_adminedit";	
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：用户编辑模块  错误信息: "+e);
			throw new MyRuntimeException(e);
		}					
	}
	/**
	* @Title: handleEdit
	* @Description: (后台用户编辑实现方法)
	* @param @param admin
	* @param @param session
	* @param @param request
	* @param @return    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping(value = "/adminedit", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleEdit(Admin admin, HttpSession session,HttpServletRequest request)
	{	
		ResponseResult<Void> rr=adminServer.updateAdmin(admin, request);		
		return rr;
	}
	/**
	* @Title: handleDel
	* @Description: (后台用户删除实现方法)
	* @param @param id
	* @param @param session
	* @param @param request
	* @param @return    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping(value = "/admindel", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleDel(Integer id, HttpSession session,HttpServletRequest request)
	{	
		ResponseResult<Void> rr=adminServer.deleteAdmin(id, request);		
		return rr;
	}
	/**
	* @Title: handlepPwdReset
	* @Description: (后台用户密码重置页面)
	* @param @param id
	* @param @param session
	* @param @param request
	* @param @return    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping(value = "/adminpwdreset", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handlepPwdReset(Integer id, HttpSession session,HttpServletRequest request)
	{	
		ResponseResult<Void> rr=adminServer.updateReset(id,"111111", request);		
		return rr;
	}
	
}
