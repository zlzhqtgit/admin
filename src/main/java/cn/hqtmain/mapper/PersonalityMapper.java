package cn.hqtmain.mapper;



import java.util.List;
import org.apache.ibatis.annotations.Param;

import cn.hqtmain.entity.Personality;





public interface PersonalityMapper
{
	Integer insert(Personality personality);
	List<Personality> select(
			@Param("where")String where,
			@Param("orderBy")String orderBy,
			@Param("offset")Integer offset,
			@Param("countPerPage")Integer countPerPage);	
	Integer update(Personality personality);
	Integer delete(@Param("where")String where);
}
