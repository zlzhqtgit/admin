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
import cn.hqtmain.entity.Admin;
import cn.hqtmain.entity.ResponseResult;
import cn.hqtmain.service.IAdminServer;

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
	 * 后端用户登录模块
	 * @param map
	 * @return nav_login模块
	 */
	@RequestMapping("/login")	
	public String showNavlogin(ModelMap map){		
		logger.info("用户名： 模块名：登录模块  操作：进入模块  状态：OK!");
		return "hqt_login";	
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
		ResponseResult<Void> rr;						
		Admin admin=adminServer.doLogin(username, password);		
		if(admin==null){
			rr=new ResponseResult<Void>(ResponseResult.ERR,"用户名或密码错误");				
		}else{
			logger.info("用户名："+username+" 模块名：登录模块 操作：登录  状态：OK!");
			rr = new ResponseResult<Void>(ResponseResult.STATE_OK, "登录成功");	
		}		
		return rr;
	}
}
