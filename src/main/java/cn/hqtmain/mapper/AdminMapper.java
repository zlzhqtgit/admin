package cn.hqtmain.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.hqtmain.entity.Admin;



public interface AdminMapper
{
	Integer insert(Admin admin);
	Integer update(Admin admin);
	Integer delete(@Param("where")String where);
	List<Admin> select(
			@Param("where")String where,
			@Param("orderBy")String orderBy,
			@Param("offset")Integer offset,
			@Param("countPerPage")Integer countPerPage);	
	Integer updatePwd(Admin admin);
	Integer updateAuthority(Admin admin);
	/**
	 * 查询单个用户(用于登陆验证)
	 * @param userName 用户名
	 * @param password 密码
	 * @return User
	 */
	 Admin queryAdmin(@Param("username")String username);
	 Admin getAdminByUsername(String username);
}
