package cn.hqtmain.service;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.hqtmain.entity.Personality;
import cn.hqtmain.entity.ResponseResult;
import cn.hqtmain.mapper.PersonalityMapper;
import cn.hqtmain.util.Constants;
import cn.hqtmain.util.LoginSession;


/**
* @Title: PersonalityServerImpl.java
* @Package cn.hqtmain.service
* @Description:(用一句话描述该文件做什么)
* @author: ZhouLingZhang
* @date 2019年12月3日
* @Copyright:好前途教育
* @version V1.0
*/
@Service
public class PersonalityServerImpl implements IPersonalityServer{
	
	@Autowired
	private PersonalityMapper personalityMapper;
	private  static final  Logger logger = LogManager.getLogger(PersonalityServerImpl.class.getName());

	
	@Override
	public ResponseResult<Void> addPersonality(Personality personality, HttpServletRequest request){		
		ResponseResult<Void> rr;
		try {
			String whereCode="personality_code='"+personality.getPersonalityCode()+"'";				
			List<Personality> PersonalityByCode=personalityMapper.select(whereCode, null, null, null);				
			if(PersonalityByCode.size()>0){
				rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":测评编码数据重复,请重新输入");
				logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：测评信息添加  操作：添加信息  状态：FAILED!");
			}else{
				String wherename="personality_name='"+personality.getPersonalityName()+"'";
				List<Personality> PersonalityByname=personalityMapper.select(wherename, null, null, null);
				if(PersonalityByname.size()>0){
					rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":测评名称数据重复,请重新输入");
					logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：测评信息添加   操作：添加信息  状态：FAILED!");
				}else{
					personalityMapper.insert(personality);
					rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
					logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：测评信息添加   操作：修改添加  状态：OK!");
				}
			}		
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：测评信息添加  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");			
		}			
		return rr;		
	}

	@Override
	public List<Personality> getPersonalityAll() {		
		return personalityMapper.select(null, null, null, null);
	}
	@Override
	public List<Personality> getPersonalityByPersonalityId(Integer personalityId) {
		String where="personality_id="+personalityId;
		return personalityMapper.select(where, null, null, null);
	}
	@Override
	public ResponseResult<Void> updatePersonality(Personality personality, HttpServletRequest request) {
		ResponseResult<Void> rr;					
		try {	
			String whereCode="personality_code='"+personality.getPersonalityCode()+"'";			
			String where1="personality_id="+personality.getPersonalityId();
			List<Personality> personalityByCode=personalityMapper.select(whereCode, null, null, null);
			List<Personality> listid=personalityMapper.select(where1, null, null, null);	
			if(personalityByCode.size()>0 && !personality.getPersonalityCode().equals(listid.get(0).getPersonalityCode())){
				rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":测评代码数据重复,请重新输入");
				logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：测评信息修改   操作：修改信息  状态：FAILED!");
			}else{
				String wherename="personality_name='"+personality.getPersonalityName()+"'";
				List<Personality> personalityByname=personalityMapper.select(wherename, null, null, null);
				if(personalityByname.size()>0 && !listid.get(0).getPersonalityName().equals(personality.getPersonalityName()) ){
					rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":测评名称数据重复,请重新输入");
					logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：测评信息修改   操作：修改信息  状态：FAILED!");
				}else{
					personalityMapper.update(personality);
					rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
					logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：测评信息修改   操作：修改信息  状态：OK!");
				}
			}			
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：测评信息修改  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}		
		return rr;
	}

	@Override
	public ResponseResult<Void> deletePersonality(Integer personalityId, HttpServletRequest request) {
		ResponseResult<Void> rr;
		String where="personality_id="+personalityId;
		try {			
			personalityMapper.delete(where);
			rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：测评信息删除   操作：删除信息  状态：OK!");					
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：测评信息删除  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}		
		return rr;
	}	
	
}
