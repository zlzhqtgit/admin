package cn.hqtmain.controller;



import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.hqtmain.entity.Admin;
import cn.hqtmain.entity.Menu;
import cn.hqtmain.entity.ResponseResult;
import cn.hqtmain.entity.Role;
import cn.hqtmain.exception.MyRuntimeException;
import cn.hqtmain.service.IAdminServer;
import cn.hqtmain.service.IMenuServer;
import cn.hqtmain.service.IRoleServer;
import cn.hqtmain.util.LoginSession;
import net.sf.json.JSONObject;


/**
* @Title: AdminMenuController.java
* @Package cn.hqtmain.controller
* @Description:(用一句话描述该文件做什么)
* @author: ZhouLingZhang
* @date 2019年11月29日
* @Copyright:好前途教育
* @version V1.0
*/
@Controller
public class MenuController {
	
	@Autowired
	public IMenuServer menuServer;
	@Autowired
	public IAdminServer adminServer;
	@Autowired
	public IRoleServer roleServer;
	private  static final  Logger logger = LogManager.getLogger(MenuController.class.getName());
	
	/**
	 * @throws MyRuntimeException 
	* @Title: showNavlogin
	* @Description: (后台菜单页面)
	* @param @param map
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("/menu")	
	public String showNavlogin(ModelMap map, HttpServletRequest request) throws MyRuntimeException{	
		try {			
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：菜单模块  操作：进入模块  状态：OK!");
			return "menu/menu";	
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：菜单模块   错误信息: "+e);
			throw new MyRuntimeException(e);
		}			
	}
	/**
	 * @throws MyRuntimeException 
	* @Title: showMenuAuthoritylogin
	* @Description: (后台菜单权限页面)
	* @param @param map
	* @param @param id
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("/menu_authority")	
	public String showMenuAuthoritylogin(ModelMap map,Integer id,String type,HttpServletRequest request) throws MyRuntimeException{	
		try {	
			String[] aty;
			if(type.equals("role")){ 
				List<Role> roleList=roleServer.getRoleByRoleId(id);
				 if(roleList.get(0).getRoleAuthority()!=null){
			    	 aty=roleList.get(0).getRoleAuthority().split(";");
			    	 map.addAttribute("Authority", aty);
			    }
			}else{		
				 List<Admin> adminAuthority=adminServer.getuserByid(id);
				 if(adminAuthority.get(0).getUserAuthority()!=null){
				    aty=adminAuthority.get(0).getUserAuthority().split(";");	
				    map.addAttribute("Authority", aty);
				 }	  
			}
			 
			GetCommonUser get=new GetCommonUser();
			List<Menu> listB = menuServer.getMenuAll();
		        //新建一个集合用于存放排序后的 查询内容
		    List<Menu> listA = new ArrayList<Menu>();
		        //  0L 代表长整形  Long
		    get.sort(-1, listB, listA);
		    
		    map.addAttribute("list",listA);	   
			map.addAttribute("id", id);
			map.addAttribute("type", type);
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：菜单权限模块  操作：进入模块  状态：OK!");
			return "menu/menu_authority";			
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：菜单权限模块   错误信息: "+e);
			throw new MyRuntimeException(e);
		}	
		 
	}
	/**
	* @Title: updateAuthority
	* @Description: (权限更新方法)
	* @param @param id
	* @param @param type
	* @param @param authority
	* @param @param request
	* @param @return    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping("/updateAuthority")
    @ResponseBody
    public ResponseResult<Void> updateAuthority(Integer id,String type,String authority,HttpServletRequest request){
		ResponseResult<Void> rr;
		if(type.equals("role")){
			rr=roleServer.updateAuthority(id, authority, request);
		}else{
			 rr=adminServer.updateAuthority(id, authority, request);  
		}		     
        return rr;
    }
	/**
	* @Title: addAdminMenu
	* @Description: (添加菜单实现方法)
	* @param @param adminMenu
	* @param @param request
	* @param @return      
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping("/addMenu")
    @ResponseBody
    public ResponseResult<Void> addAdminMenu(@RequestBody Menu adminMenu,HttpServletRequest request){		
		ResponseResult<Void> rr=menuServer.addMenu(adminMenu,request);       
        return rr;
    }
	/**
	* @Title: getMenu
	* @Description: (查询菜单信息方法)
	* @param @param request
	* @param @return    
	* @return JSONObject    
	* @throws
	 */
	@RequestMapping("/getMenu")
    @ResponseBody
    public JSONObject getMenu(HttpServletRequest request){		
		JSONObject lan1=menuServer.getMenu(request);			
        return lan1;
    }
	/**
	* @Title: updateMenu
	* @Description: (更新菜单信息实现方法)
	* @param @param adminMenu
	* @param @param request
	* @param @return    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping("/updateMenu")
    @ResponseBody
    public ResponseResult<Void> updateMenu(@RequestBody Menu adminMenu,HttpServletRequest request){
		ResponseResult<Void> rr=menuServer.updateMenu(adminMenu,request);
		return rr;
    }
	/**
	* @Title: deleteMenu
	* @Description: (删除菜单实现方法)
	* @param @param menuId
	* @param @param request
	* @param @return    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping("/deleteMenu")
    @ResponseBody
    public ResponseResult<Void> deleteMenu(String menuId,HttpServletRequest request){		
		ResponseResult<Void> rr=menuServer.deleteMenu(menuId,request);		
		return rr;
    }
}
