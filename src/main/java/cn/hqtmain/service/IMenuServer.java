package cn.hqtmain.service;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import cn.hqtmain.entity.Menu;
import cn.hqtmain.entity.ResponseResult;
import net.sf.json.JSONObject;


public interface IMenuServer
{
	ResponseResult<Void> addMenu(Menu menu,HttpServletRequest request);	
	List<Menu> getMenuAll();
	JSONObject getMenu(HttpServletRequest request);
	ResponseResult<Void> updateMenu(Menu menu,HttpServletRequest request);
	ResponseResult<Void> deleteMenu(String menuId,HttpServletRequest request);
}
