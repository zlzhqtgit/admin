package cn.hqtmain.service;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import cn.hqtmain.entity.ResponseResult;
import cn.hqtmain.entity.Specialty;


public interface ISpecialtyServer
{
	ResponseResult<Void> addSpecialty(Specialty specialty,HttpServletRequest request);	
	List<Specialty> getSpecialtyAll();
	List<Specialty> getSpecialtyBySpecialtyId(String specialtyId);
	List<Specialty> getByMajorName();
	//JSONObject getCompany(HttpServletRequest request);
	ResponseResult<Void> updateSpecialty(Specialty specialty,HttpServletRequest request);
	ResponseResult<Void> deleteSpecialty(Integer id,HttpServletRequest request);
}
