package cn.hqtmain.controller;


import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.hqtmain.entity.Company;
import cn.hqtmain.entity.ResponseResult;
import cn.hqtmain.service.ICompanyServer;


/**
* @Title: CompanyController.java
* @Package cn.hqtmain.controller
* @Description:(用一句话描述该文件做什么)
* @author: ZhouLingZhang
* @date 2019年12月3日
* @Copyright:好前途教育
* @version V1.0
*/
@Controller
public class SystemController {
	
	@Resource
	public ICompanyServer companyServer;
	
	
	
	@RequestMapping("/hqt_system")
	public String  hanldSystem(){		
		return "system/hqt_system";		
	}
	
	@RequestMapping("/hqt_company")
	public String hanldCompany(ModelMap map){
		List<Company> companyList=companyServer.getCompanyAll();		
		map.addAttribute("companyList", companyList);
		return "system/hqt_company";		
	}
	
	@RequestMapping("/hqt_companyadd")
	public String hanldCompanyAdd(){
		return "system/hqt_companyadd";
	}
	@RequestMapping("/hqt_companyedit")
	public String hanldCompanyEdit(ModelMap map,Integer companyId){
		List<Company> companyList=companyServer.getCompanyBycompanyId(companyId);
		map.addAttribute("companyList",companyList);
		return "system/hqt_companyedit";
	}
	@RequestMapping(value = "/companyadd", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleAdd(Company company, HttpSession session,HttpServletRequest request)
	{			
		ResponseResult<Void> rr=companyServer.addCompany(company, request);		
		return rr;
	}
	@RequestMapping(value = "/companydel", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleDel(Integer companyId, HttpSession session,HttpServletRequest request)
	{			
		ResponseResult<Void> rr=companyServer.deleteCompany(companyId, request);		
		return rr;
	}
	@RequestMapping(value = "/companyedit", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleEdit(Company company, HttpSession session,HttpServletRequest request)
	{			
		ResponseResult<Void> rr=companyServer.updateCompany(company, request);		
		return rr;
	}
}
