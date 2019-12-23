package cn.hqtmain.mapper;



import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.hqtmain.entity.Vocation;




public interface VocationMapper
{
	Integer insertVocation(Vocation vocation);
	List<Vocation> select(
			@Param("where")String where,
			@Param("orderBy")String orderBy,
			@Param("offset")Integer offset,
			@Param("countPerPage")Integer countPerPage);	
	List<Vocation> selectByVocationId(
			@Param("where")String where,
			@Param("orderBy")String orderBy,
			@Param("offset")Integer offset,
			@Param("countPerPage")Integer countPerPage);
	Integer updateVocationById(Vocation vocation);
	/**
	 * 删除职业数据信息
	 * @param vId
	 * @return
	 */
	Integer deleteVocationById(Integer vId);
}
