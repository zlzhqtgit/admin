package cn.hqtmain.mapper;



import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.hqtmain.entity.Role;




public interface RoleMapper
{
	Integer insert(Role role);
	List<Role> select(
			@Param("where")String where,
			@Param("orderBy")String orderBy,
			@Param("offset")Integer offset,
			@Param("countPerPage")Integer countPerPage);
	Integer update(Role role);
	Integer delete(@Param("where")String where);
	Integer updateAuthority(Role role);
}
