package cn.hqtmain.service;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.hqtmain.entity.Specialty;
import cn.hqtmain.entity.ResponseResult;
import cn.hqtmain.mapper.SpecialtyMapper;
import cn.hqtmain.util.Constants;
import cn.hqtmain.util.LoginSession;


/**
* @Title: SpecialtyServerImpl.java
* @Package cn.hqtmain.service
* @Description:(用一句话描述该文件做什么)
* @author: ZhouLingZhang
* @date 2019年12月3日
* @Copyright:好前途教育
* @version V1.0
*/
@Service
public class SpecialtyServerImpl implements ISpecialtyServer{
	
	@Autowired
	private SpecialtyMapper specialtyMapper;
	private  static final  Logger logger = LogManager.getLogger(SpecialtyServerImpl.class.getName());

	
	@Override
	public ResponseResult<Void> addSpecialty(Specialty specialty, HttpServletRequest request){		
		ResponseResult<Void> rr;
		try {
			String whereid="specialty_id='"+specialty.getSpecialtyId()+"'";				
			List<Specialty> SpecialtyByid=specialtyMapper.select(whereid, null, null, null);				
			if(SpecialtyByid.size()>0){
				rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":专业代码数据重复,请重新输入");
				logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：专业信息添加  操作：添加信息  状态：FAILED!");
			}else{
				String wherename="specialty_name='"+specialty.getSpecialtyName()+"'";
				List<Specialty> SpecialtyByname=specialtyMapper.select(wherename, null, null, null);
				if(SpecialtyByname.size()>0){
					rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":专业名称数据重复,请重新输入");
					logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：专业信息添加   操作：添加信息  状态：FAILED!");
				}else{
					specialtyMapper.insert(specialty);
					rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
					logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：专业信息添加   操作：修改添加  状态：OK!");
				}
			}		
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：专业信息添加  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");			
		}			
		return rr;		
	}

	@Override
	public List<Specialty> getSpecialtyAll() {		
		return specialtyMapper.select(null, null, null, null);
	}

	@Override
	public ResponseResult<Void> updateSpecialty(Specialty specialty, HttpServletRequest request) {
		ResponseResult<Void> rr;					
		try {	
			String whereid="specialty_id='"+specialty.getSpecialtyId()+"'";			
			String where1="id="+specialty.getId();
			List<Specialty> SpecialtyByid=specialtyMapper.select(whereid, null, null, null);
			List<Specialty> listid=specialtyMapper.select(where1, null, null, null);	
			if(SpecialtyByid.size()>0 && !specialty.getSpecialtyId().equals(listid.get(0).getSpecialtyId())){
				rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":专业代码数据重复,请重新输入");
				logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：专业信息修改   操作：修改信息  状态：FAILED!");
			}else{
				String wherename="specialty_name='"+specialty.getSpecialtyName()+"'";
				List<Specialty> SpecialtyByname=specialtyMapper.select(wherename, null, null, null);
				if(SpecialtyByname.size()>0 && !listid.get(0).getSpecialtyName().equals(specialty.getSpecialtyName()) ){
					rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":专业名称数据重复,请重新输入");
					logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：专业信息修改   操作：修改信息  状态：FAILED!");
				}else{
					specialtyMapper.update(specialty);
					rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
					logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：专业信息修改   操作：修改信息  状态：OK!");
				}
			}			
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：专业信息修改  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}		
		return rr;
	}

	@Override
	public ResponseResult<Void> deleteSpecialty(Integer id, HttpServletRequest request) {
		ResponseResult<Void> rr;
		String where="id="+id;
		try {			
			specialtyMapper.delete(where);
			rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：专业信息删除   操作：删除信息  状态：OK!");					
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：专业信息删除  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}		
		return rr;
	}

	@Override
	public List<Specialty> getSpecialtyBySpecialtyId(String specialtyId) {
		String where="Specialty_id='"+specialtyId+"'";
		return specialtyMapper.selectBySpecialtyId(where);
	}

	@Override
	public List<Specialty> getByMajorName() {		
		return specialtyMapper.selectByMajorName();
	}

}
