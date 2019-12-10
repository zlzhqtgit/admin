package cn.hqtmain.service;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import cn.hqtmain.entity.Company;
import cn.hqtmain.entity.ResponseResult;


public interface ICompanyServer
{
	ResponseResult<Void> addCompany(Company company,HttpServletRequest request);	
	List<Company> getCompanyAll();
	List<Company> getCompanyBycompanyId(Integer companyId);
	//JSONObject getCompany(HttpServletRequest request);
	ResponseResult<Void> updateCompany(Company company,HttpServletRequest request);
	ResponseResult<Void> deleteCompany(Integer companyId,HttpServletRequest request);
}
