package cn.hqtmain.service;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.hqtmain.entity.University;
import cn.hqtmain.entity.UniversityRelation;
import cn.hqtmain.entity.ResponseResult;
import cn.hqtmain.mapper.UniversityMapper;
import cn.hqtmain.util.Constants;
import cn.hqtmain.util.LoginSession;


/**
* @Title: universityServerImpl.java
* @Package cn.hqtmain.service
* @Description:(用一句话描述该文件做什么)
* @author: ZhouLingZhang
* @date 2019年12月3日
* @Copyright:好前途教育
* @version V1.0
*/
@Service
public class UniversityServerImpl implements IUniversityServer{
	
	@Autowired
	private UniversityMapper universityMapper;
	
	private  static final  Logger logger = LogManager.getLogger(UniversityServerImpl.class.getName());
	
	
	
	@Override
	public List<University> getUniversityAll() {		
		return universityMapper.selectUniversityList(null, null, null, null);
	}

	@Override
	public List<University> getUniversityById(Integer id) {
		String where="u.id="+id;
		return universityMapper.selectUniversityList(where, null, null, null);
	}

	
	@Override
	public ResponseResult<Void> updateimg(University university, HttpServletRequest request) {
		ResponseResult<Void> rr;					
		try {			
			universityMapper.updateimg(university);
			rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：图片路径修改   操作：修改信息  状态：OK!");				
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：图片路径修改  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}		
		return rr;
	}
	@Override
	public ResponseResult<Void> updateUniversity(University university, HttpServletRequest request) {
		ResponseResult<Void> rr;					
		try {	
			String whereid="u.id="+university.getId();			
			String where1="u.universities_code='"+university.getUniversitiesCode()+"'";
			List<University> universityByid=universityMapper.selectUniversityList(whereid, null, null, null);
			List<University> listcode=universityMapper.selectUniversityList(where1, null, null, null);	
			if(listcode.size()>0 && !university.getUniversitiesCode().equals(universityByid.get(0).getUniversitiesCode())){
				rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":院校代码数据重复,请重新输入");
				logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：专业信息修改   操作：修改信息  状态：FAILED!");
			}else{
				String wherename="u.universities_name='"+university.getUniversitiesName()+"'";
				List<University> universityByname=universityMapper.selectUniversityList(wherename, null, null, null);
				if(universityByname.size()>0 && !universityByid.get(0).getUniversitiesName().equals(university.getUniversitiesName()) ){
					rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":院校名称数据重复,请重新输入");
					logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：院校信息修改   操作：修改信息  状态：FAILED!");
				}else{
					universityMapper.updateUniversity(university);
					rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
					logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：院校信息修改   操作：修改信息  状态：OK!");
				}
			}			
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：院校信息修改  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}		
		return rr;
	}
	@Override
	public ResponseResult<List<UniversityRelation>> getUniversityRelationList(String where,HttpServletRequest request) {
		ResponseResult<List<UniversityRelation>> rr;					
		try {	
			if(where==""){
				where=null;
			}
			List<UniversityRelation> selectUniversityRelationList = universityMapper.selectUniversityRelationList(where, null, null, null);
			System.out.println(selectUniversityRelationList);
			rr=new ResponseResult<List<UniversityRelation>>(ResponseResult.STATE_OK,selectUniversityRelationList);
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：院校分类信息修改   操作：修改信息  状态：OK!");						
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：院校分类信息修改  错误信息: "+e);
			rr=new ResponseResult<List<UniversityRelation>>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}		
		return rr;		
	}

	@Override
	public ResponseResult<Void> insertUniversityRelation(UniversityRelation universityRelation,HttpServletRequest request) {
		ResponseResult<Void> rr;					
		try {			
			 universityMapper.insertUniversityRelation(universityRelation);			
			rr=new ResponseResult<Void>(ResponseResult.STATE_OK,"");
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：院校分类信息修改   操作：修改信息  状态：OK!");						
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：院校分类信息修改  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}		
		return rr;
	}

	
	@Override
	public ResponseResult<Void> updateUniversityRelation(UniversityRelation universityRelation, HttpServletRequest request) {
		ResponseResult<Void> rr;					
		try {			
			 universityMapper.updateUniversityRelation(universityRelation);			
			rr=new ResponseResult<Void>(ResponseResult.STATE_OK,"");
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：院校分类信息修改   操作：修改信息  状态：OK!");						
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：院校分类信息修改  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}		
		return rr;
	}


}
