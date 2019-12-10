package cn.hqtmain.service;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.hqtmain.entity.Role;
import cn.hqtmain.entity.ResponseResult;
import cn.hqtmain.mapper.RoleMapper;
import cn.hqtmain.util.Constants;
import cn.hqtmain.util.LoginSession;

/**
* @Title: RoleServerImpl.java
* @Package cn.hqtmain.service
* @Description:(用一句话描述该文件做什么)
* @author: ZhouLingZhang
* @date 2019年12月3日
* @Copyright:好前途教育
* @version V1.0
*/
@Service
public class RoleServerImpl implements IRoleServer{
	
	@Autowired
	private RoleMapper RoleMapper;
	private  static final  Logger logger = LogManager.getLogger(RoleServerImpl.class.getName());

	
	@Override
	public ResponseResult<Void> addRole(Role role, HttpServletRequest request) {		
		ResponseResult<Void> rr;
		try {
			String where="role_name='"+role.getRoleName()+"'";
			List<Role> roleList=RoleMapper.select(where, null, null, null);
			boolean flas=false;
			for(int i=0;i<roleList.size();i++){
				if(role.getCid()==roleList.get(i).getCid()){
					flas=true;
				}
			}
			if(roleList.size()>0 && flas==true){
				rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED);
				logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：角色信息添加   操作：添加信息  状态：Faild!");
			}else{
				RoleMapper.insert(role);
				rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
				logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：角色信息添加   操作：添加信息  状态：OK!");	
			}					
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：角色信息添加  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}			
		return rr;		
	}

	@Override
	public List<Role> getRoleAll() {			
		return RoleMapper.select(null, null, null, null);
	}

	@Override
	public ResponseResult<Void> updateRole(Role role, HttpServletRequest request) {
		ResponseResult<Void> rr;					
		try {	
				String where="role_name='"+role.getRoleName()+"'";
				String where1="role_id="+role.getRoleId();
				List<Role> roleList=RoleMapper.select(where, null, null, null);
				List<Role> roleListByid=RoleMapper.select(where1, null, null, null);
				if(roleList.size()>0 && !roleList.get(0).getRoleName().equals(roleListByid.get(0).getRoleName())){
					rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据重复,请重新输入");
					logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：角色信息修改   操作：添加信息  状态：FAILED!");
				}else{
					role.setCid(roleListByid.get(0).getCid());
					role.setRoleAuthority(roleListByid.get(0).getRoleAuthority());
					RoleMapper.update(role);
					rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
					logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：角色信息修改   操作：修改信息  状态：OK!");
				}				
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：角色信息修改  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}		
		return rr;
	}

	@Override
	public ResponseResult<Void> deleteRole(Integer roleId, HttpServletRequest request) {
		ResponseResult<Void> rr;
		String where="Role_id="+roleId;
		try {			
			RoleMapper.delete(where);
			rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：角色信息删除   操作：删除信息  状态：OK!");					
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：角色信息删除  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}		
		return rr;
	}

	@Override
	public List<Role> getRoleByRoleId(Integer RoleId) {
		String where="Role_id="+RoleId;
		return RoleMapper.select(where, null, null, null);
	}
	@Override
	public ResponseResult<Void> updateAuthority(Integer roleId, String authority, HttpServletRequest request) {
		ResponseResult<Void> rr;
		try {					
			Role role=new Role();			
			role.setRoleId(roleId);
			role.setRoleAuthority(authority);			
			RoleMapper.updateAuthority(role);
			rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：用户角色权限修改   操作：修改角色权限   状态：OK!");	
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：用户角色权限修改  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}		
		return rr;
	}
	
	@Override
	public ResponseResult<List<Role>> getRoleByRoleCid(Integer cid) {
		ResponseResult<List<Role>> rr;
		String where="cid="+cid;
		List<Role> roleList=RoleMapper.select(where, null, null, null);
		logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：角色信息查询   操作：查询信息  状态：OK!");					
		rr=new ResponseResult<List<Role>>(ResponseResult.STATE_OK,roleList);
		return rr;
	}
	@Override
	public List<Role> getRoleByCid(Integer cid) {	
		String where="cid="+cid;
		List<Role> roleList=RoleMapper.select(where, null, null, null);		
		return roleList;
	}

}
