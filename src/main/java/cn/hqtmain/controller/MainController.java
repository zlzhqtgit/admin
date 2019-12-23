package cn.hqtmain.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.hqtmain.exception.MyRuntimeException;



/**
* @Title: MainController.java
* @Package cn.hqtzytb.controller
* @Description:(后台响应页面控制层)
* @author: ZhouLingZhang
* @date 2019年9月3日
* @Copyright:好前途教育
* @version V1.0
*/

@Controller
public class MainController {
	
	private  static final  Logger logger = LogManager.getLogger(MainController.class.getName());
	/**
	 * @throws MyRuntimeException 
	* @Title: showIndexno
	* @Description: (后台主页面)
	* @param @param session
	* @param @param response
	* @param @param request
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("/index")	
	public String showIndexno(HttpSession session,HttpServletResponse response,HttpServletRequest request) throws MyRuntimeException{	
		try {			
			logger.info("用户名："+session.getAttribute("adminname")+" 模块名：后台主页  操作：进入模块  状态：OK!");
			return "hqt_index";	
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：后台主页    错误信息: "+e);
			throw new MyRuntimeException(e);
		}								
	}
	
	@RequestMapping("/error")	
	public String error(HttpSession session,HttpServletResponse response,HttpServletRequest request){	
		return "error/error";					
	}
	/**
	 * @throws MyRuntimeException 
	 * @throws MyRuntimeException 
	* @Title: showHqtadmin
	* @Description: (响应用户管理模块下的主页)
	* @param @param map
	* @param @param session
	* @param @param request
	* @param @param response
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("/hqt_user")	
	public String showHqtadmin(ModelMap map,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws MyRuntimeException{
		try {			
			logger.info("用户名："+session.getAttribute("adminname")+" 模块名：用户管理模块  操作：进入模块  状态：OK!");
			return  "hqt_user";	
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：用户管理模块    错误信息: "+e);
			throw new MyRuntimeException(e);
		}						
	}
}
