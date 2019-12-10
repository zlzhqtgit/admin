package cn.hqtmain.service;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import cn.hqtmain.entity.Role;
import cn.hqtmain.entity.ResponseResult;



public interface IRoleServer
{
	ResponseResult<Void> addRole(Role role,HttpServletRequest request);	
	List<Role> getRoleAll();
	List<Role> getRoleByRoleId(Integer roleId);
	ResponseResult<List<Role>> getRoleByRoleCid(Integer cid);
	List<Role> getRoleByCid(Integer cid);
	ResponseResult<Void> updateAuthority(Integer roleId,String authority,HttpServletRequest request);
	//JSONObject getRole(HttpServletRequest request);
	ResponseResult<Void> updateRole(Role role,HttpServletRequest request);
	ResponseResult<Void> deleteRole(Integer roleId,HttpServletRequest request);
}
