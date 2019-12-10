package cn.hqtmain.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.hqtmain.entity.Admin;
import cn.hqtmain.entity.ResponseResult;


public interface IAdminServer
{
	ResponseResult<Void> addAdmin(Admin admin,HttpServletRequest request);
	ResponseResult<Void> updateAdmin(Admin admin,HttpServletRequest request);
	ResponseResult<Void> updateReset(Integer id,String password,HttpServletRequest request);
	ResponseResult<Void> updateAuthority(Integer id,String authority,HttpServletRequest request);
	ResponseResult<Void> deleteAdmin(Integer id,HttpServletRequest request);
	List<Admin> getuser(Date date);	
	List<Admin> getuserByid(Integer id);	
	List<Admin> getuserAll();
	Admin queryAdmin(String username);
	Admin getAdminByUsername(String username);
	Admin doLogin(String username,String password);

}
