package cn.hqtmain.controller;



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
import cn.hqtmain.entity.ResponseResult;
import cn.hqtmain.exception.MyRuntimeException;
import cn.hqtmain.service.IAdminServer;
import cn.hqtmain.util.LoginSession;

/**
* @Title: LoginController.java
* @Package cn.hqtmain.controller
* @Description:(用一句话描述该文件做什么)
* @author: ZhouLingZhang
* @date 2019年11月26日
* @Copyright:好前途教育
* @version V1.0
*/
@Controller
public class LoginController {
	
	@Autowired
	public IAdminServer adminServer;
	private  static final  Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	/**
	 * @throws MyRuntimeException 
	* @Title: showNavlogin
	* @Description: (后台系统登录页面)
	* @param @param map
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("/login")	
	public String showNavlogin(ModelMap map,HttpServletRequest request) throws MyRuntimeException{
//		try {			
//			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：登录模块  操作：进入模块  状态：OK!");
			return "hqt_login";
//		} catch (Exception e) {
//			logger.error("访问路径："+request.getRequestURI()+"操作：登录模块   错误信息: "+e);
//			throw new MyRuntimeException(e);
//		}		
			
	}
	/**
	* @Title: handleAdminlogin
	* @Description: (后台登录按钮实现功能方法)
	* @param @param username
	* @param @param password
	* @param @param session
	* @param @param request
	* @param @return    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping(value = "/hqt_login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleAdminlogin(String username,String password, HttpSession session,HttpServletRequest request)
	{	
		ResponseResult<Void> rr=adminServer.doLogin(username, password,request);;		
		return rr;
	}
}
