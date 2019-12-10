package cn.hqtmain.mapper;



import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.hqtmain.entity.Company;




public interface CompanyMapper
{
	Integer insert(Company company);
	List<Company> select(
			@Param("where")String where,
			@Param("orderBy")String orderBy,
			@Param("offset")Integer offset,
			@Param("countPerPage")Integer countPerPage);
	Integer update(Company company);
	Integer delete(@Param("where")String where);
}
