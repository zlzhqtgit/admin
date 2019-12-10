package cn.hqtmain.service;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hqtmain.entity.Company;
import cn.hqtmain.entity.ResponseResult;
import cn.hqtmain.mapper.CompanyMapper;
import cn.hqtmain.util.Constants;
import cn.hqtmain.util.LoginSession;

/**
* @Title: CompanyServerImpl.java
* @Package cn.hqtmain.service
* @Description:(用一句话描述该文件做什么)
* @author: ZhouLingZhang
* @date 2019年12月3日
* @Copyright:好前途教育
* @version V1.0
*/
@Service
public class CompanyServerImpl implements ICompanyServer{
	
	@Autowired
	private CompanyMapper companyMapper;
	private  static final  Logger logger = LogManager.getLogger(CompanyServerImpl.class.getName());

	
	@Override
	public ResponseResult<Void> addCompany(Company company, HttpServletRequest request) {		
		ResponseResult<Void> rr;
		try {
			String where="company_number='"+company.getCompanyNumber()+"' or company_name='"+company.getCompanyName()+"'";
			List<Company> companylist=companyMapper.select(where, null, null, null);
			if(companylist.size()>0){
				rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据重复,请重新输入");
				logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：单位信息添加   操作：添加信息  状态：FAILED!");
			}else{
				Date now=new Date();
				company.setCreationTime(now);
				companyMapper.insert(company);
				rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
				logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：单位信息添加   操作：添加信息  状态：OK!");
			}			
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：单位信息添加  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}			
		return rr;		
	}

	@Override
	public List<Company> getCompanyAll() {		
		return companyMapper.select(null, null, null, null);
	}

	@Override
	public ResponseResult<Void> updateCompany(Company company, HttpServletRequest request) {
		ResponseResult<Void> rr;					
		try {	
			String where="company_id="+company.getCompanyId();
			List<Company> companylistById=companyMapper.select(where, null, null, null);
			String where1="company_number='"+company.getCompanyNumber()+"' or company_name='"+company.getCompanyName()+"'";
			List<Company> companylist=companyMapper.select(where1, null, null, null);			
			if(companylist.size()>0 && !companylist.get(0).getCompanyNumber().equals(companylistById.get(0).getCompanyNumber())&& 
					!companylist.get(0).getCompanyName().equals(companylistById.get(0).getCompanyName())){
				rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据重复,请重新输入");
				logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：单位信息修改   操作：添加信息  状态：FAILED!");
			}else{
				Date now=new Date();
				company.setCreationTime(now);
				companyMapper.update(company);
				rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
				logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：单位信息修改   操作：修改信息  状态：OK!");
			}			
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：单位信息修改  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}		
		return rr;
	}

	@Override
	public ResponseResult<Void> deleteCompany(Integer companyId, HttpServletRequest request) {
		ResponseResult<Void> rr;
		String where="Company_id="+companyId;
		try {			
			companyMapper.delete(where);
			rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：单位信息删除   操作：删除信息  状态：OK!");					
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：单位信息删除  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}		
		return rr;
	}

	@Override
	public List<Company> getCompanyBycompanyId(Integer companyId) {
		String where="company_id="+companyId;
		return companyMapper.select(where, null, null, null);
	}

}
