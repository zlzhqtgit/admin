package cn.hqtmain.mapper;



import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.hqtmain.entity.Specialty;




public interface SpecialtyMapper
{
	Integer insert(Specialty specialty);
	List<Specialty> select(
			@Param("where")String where,
			@Param("orderBy")String orderBy,
			@Param("offset")Integer offset,
			@Param("countPerPage")Integer countPerPage);
	List<Specialty> selectByMajorName();
	List<Specialty> selectBySpecialtyId(@Param("where")String where);
	Integer update(Specialty specialty);
	Integer delete(@Param("where")String where);
}
