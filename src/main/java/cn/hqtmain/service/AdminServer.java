package cn.hqtmain.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.hqtmain.controller.GetCommonUser;
import cn.hqtmain.entity.Admin;
import cn.hqtmain.entity.ResponseResult;
import cn.hqtmain.entity.Role;
import cn.hqtmain.mapper.AdminMapper;
import cn.hqtmain.mapper.RoleMapper;
import cn.hqtmain.util.Constants;
import cn.hqtmain.util.LoginSession;


@Service
public class AdminServer implements IAdminServer
{
	@Autowired
	public AdminMapper adminMapper;
	@Autowired
	public RoleMapper roleMapper;
	
	private  static final  Logger logger = LogManager.getLogger(RoleServerImpl.class.getName());
	
	
	public ResponseResult<Void> addAdmin(Admin admin,HttpServletRequest request)
	{
		ResponseResult<Void> rr;
		try {
			String where="username='"+admin.getUsername()+"'";
			List<Admin> adminList=adminMapper.select(where, null, null, null);	
			String aWhere="rid="+admin.getRid();
			List <Admin> aqdminListByRid=adminMapper.select(aWhere, null, null, null);
			String rWhere="role_id="+admin.getRid();
			List <Role> roleList=roleMapper.select(rWhere, null, null, null);
			if(adminList.size()>0){
				rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":用户已经存在");
				logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：用户信息添加   操作：添加信息  状态：Faild!");
			}else if(aqdminListByRid.size()>0 && aqdminListByRid.get(0).getRoleName().equals("超级管理员")){
				rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":已有超级管理员用户");
				logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：用户信息添加   操作：添加信息  状态：Faild!");
			}else if(roleList.get(0).getRoleAuthority()==null || roleList.get(0).getRoleAuthority()==""){
				rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":该角色未设置相应的权限");
				logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：用户信息添加   操作：添加信息  状态：Faild!");		
			}else{
				String uuid = UUID.randomUUID().toString().toUpperCase();				
				GetCommonUser get=new GetCommonUser();
				String md5Password = get.getEncrpytedPassword("MD5", admin.getPassword(), uuid,1024);
				admin.setPassword(md5Password);
				admin.setUuid(uuid);		
				admin.setCreatTime(new Date());
				adminMapper.insert(admin);
				rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
				logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：用户信息添加   操作：添加信息  状态：OK!");	
			}					
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：用户信息添加  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}			
		return rr;
	}

	public ResponseResult<Void> updateAdmin(Admin admin,HttpServletRequest request)
	{			
		ResponseResult<Void> rr;
		try {
			String where="username='"+admin.getUsername()+"'";
			String where1="id="+admin.getId();
			List<Admin> adminList=adminMapper.select(where, null, null, null);	
			List<Admin> adminListById=adminMapper.select(where1, null, null, null);		
			if(adminList.size()>0 && !adminListById.get(0).getUsername().equals(adminList.get(0).getUsername())){
				rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+"数据信息重复");
				logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：用户信息修改    操作：修改信息  状态：Faild!");
			}else{				
				admin.setCreatTime(new Date());
				adminMapper.update(admin);
				rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
				logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：用户信息修改  操作：修改信息  状态：OK!");	
			}			
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：用户信息修改  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}
		return rr;
	}

	public ResponseResult<Void> deleteAdmin(Integer id,HttpServletRequest request)
	{	
		ResponseResult<Void> rr;
		String where="id="+id;
		try {			
			adminMapper.delete(where);
			rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：用户信息删除   操作：删除信息  状态：OK!");					
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：用户信息删除  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}
		return rr;				
	}

	public List<Admin> getuser(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
		String where="creat_time>='"+format+"'";	
		List<Admin> list=adminMapper.select(where, null, null, null);
		return list;
	}
	
	
	public List<Admin> getuserAll() {
		String orderBy="creat_time";
		return adminMapper.select(null, orderBy, null, null);
	}
	
	public ResponseResult<Void>  updateReset(Integer id,String password,HttpServletRequest request) {	
		ResponseResult<Void> rr;
		try {
			List<Admin> adminList=getuserByid(id);
			GetCommonUser get=new GetCommonUser();
			String md5Password = get.getEncrpytedPassword("MD5",password, adminList.get(0).getUuid(),1024);	
			Admin admin=new Admin();
			admin.setPassword(md5Password);
			admin.setId(id);
			admin.setCreatTime(new Date());
			adminMapper.updatePwd(admin);
			rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：用户密码重置   操作：重置密码  状态：OK!");	
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：用户密码重置  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}		
		return rr;
	}

	@Override
	public ResponseResult<Void> updateAuthority(Integer id, String authority, HttpServletRequest request) {
		ResponseResult<Void> rr;
		try {					
			Admin admin=new Admin();			
			admin.setId(id);
			admin.setUserAuthority(authority);
			admin.setCreatTime(new Date());
			adminMapper.updateAuthority(admin);
			rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：用户权限修改   操作：修改权限   状态：OK!");	
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：用户权限修改  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}		
		return rr;
	}

	public List<Admin> getuserByid(Integer id) {
		String where="id="+id;
		return adminMapper.select(where, null, null, null);
	}
	
	@Override
	public Admin queryAdmin(String username) {		
		return adminMapper.queryAdmin(username);
	}
	@Override
	public Admin getAdminByUsername(String username) {	
		return adminMapper.getAdminByUsername(username);
	}
	@Override
	public Admin doLogin(String username, String password) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(username, password);
		try {
			subject.login(token);
			Admin admin=getAdminByUsername(username);		
			Session session=subject.getSession();
			session.setAttribute(Constants.SYSTEM_USER,admin);			
			return admin;
		} catch (AuthenticationException e) {
			/*e.printStackTrace();*/
			return null;
		}		
	}

	
	
	
}
