package cn.hqtmain.service;



import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.hqtmain.entity.Menu;
import cn.hqtmain.entity.ResponseResult;
import cn.hqtmain.mapper.MenuMapper;
import cn.hqtmain.util.Constants;
import cn.hqtmain.util.LoginSession;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;




@Service
public class MenuServerImpl implements IMenuServer
{
	@Autowired
	public MenuMapper menuMapper;
	private  static final  Logger logger = LogManager.getLogger(MenuServerImpl.class.getName());	
	
	@Override
	public ResponseResult<Void> addMenu(Menu menu,HttpServletRequest request) {
		ResponseResult<Void> rr;
		try {
			menuMapper.insert(menu);
			rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：菜单信息添加   操作：添加信息  状态：OK!");
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：菜单信息添加  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}			
		return rr;
	}

	@Override
	public List<Menu> getMenuAll(){		
		return menuMapper.select(null, null, null, null);
	}
	@Override
	public JSONObject getMenu(HttpServletRequest request) {
		try {
			List<Menu> menulist=getMenuAll();			
			JSONArray json = JSONArray.fromObject(menulist);
			JSONObject lan1 = new JSONObject();
	        lan1.put("code", 0);
	        lan1.put("msg", "");
	        lan1.put("count",menulist.size());
	        lan1.put("data",json);	       
	        logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：菜单信息查询   操作：获取菜单信息  状态：OK!");	       
	        return lan1;
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：菜单信息查询  错误信息: "+e);
			return null;
		}	
	}
	@Override
	public ResponseResult<Void> updateMenu(Menu menu,HttpServletRequest request) {
		ResponseResult<Void> rr;					
		try {		
			menuMapper.update(menu);
			rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：菜单信息修改   操作：修改信息  状态：OK!");
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：菜单信息修改  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}		
		return rr;
	}

	@Override
	public ResponseResult<Void> deleteMenu(String menuId,HttpServletRequest request) {
		ResponseResult<Void> rr;
		String where="parent_id="+menuId;
		try {
			List<Menu> menuList=menuMapper.select(where, null, null, null);
			if(menuList.size()>0){				
				where ="menu_id="+menuId+" or parent_id="+menuList.get(0).getParentId();
			}else{
				where="menu_id="+menuId;
			}		
			menuMapper.delete(where);
			rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：菜单信息删除   操作：删除信息  状态：OK!");					
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：菜单信息删除  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}		
		return rr;
	}	
}
