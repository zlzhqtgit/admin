package cn.hqtmain.mapper;



import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.hqtmain.entity.Menu;



public interface MenuMapper
{
	Integer insert(Menu menu);
	List<Menu> select(
			@Param("where")String where,
			@Param("orderBy")String orderBy,
			@Param("offset")Integer offset,
			@Param("countPerPage")Integer countPerPage);
	Integer update(Menu menu);
	Integer delete(@Param("where")String where);
}
