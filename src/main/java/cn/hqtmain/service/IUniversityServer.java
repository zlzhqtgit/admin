package cn.hqtmain.service;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import cn.hqtmain.entity.ResponseResult;
import cn.hqtmain.entity.University;
import cn.hqtmain.entity.UniversityRelation;


public interface IUniversityServer
{
//	ResponseResult<Void> addUniversity(University university,HttpServletRequest request);	
	List<University> getUniversityAll();
	List<University> getUniversityById(Integer id);
	ResponseResult<Void> updateimg(University university,HttpServletRequest request);
//	List<University> getByMajorName();
//	//JSONObject getCompany(HttpServletRequest request);
	ResponseResult<Void> updateUniversity(University university,HttpServletRequest request);
//	ResponseResult<Void> deleteUniversity(Integer id,HttpServletRequest request);
	ResponseResult<List<UniversityRelation>> getUniversityRelationList(String where,HttpServletRequest request);
	ResponseResult<Void> insertUniversityRelation(UniversityRelation universityRelation,HttpServletRequest request);
	ResponseResult<Void> updateUniversityRelation(UniversityRelation universityRelation,HttpServletRequest request);
}
