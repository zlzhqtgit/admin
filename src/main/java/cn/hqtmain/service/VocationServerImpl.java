package cn.hqtmain.service;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.hqtmain.entity.ResponseResult;
import cn.hqtmain.entity.Vocation;
import cn.hqtmain.mapper.VocationMapper;
import cn.hqtmain.util.Constants;
import cn.hqtmain.util.LoginSession;


/**
* @Title: VocationServerImpl.java
* @Package cn.hqtmain.service
* @Description:(用一句话描述该文件做什么)
* @author: ZhouLingZhang
* @date 2019年12月3日
* @Copyright:好前途教育
* @version V1.0
*/
@Service
public class VocationServerImpl implements IVocationServer{
	
	@Autowired
	private VocationMapper vocationMapper;
	private  static final  Logger logger = LogManager.getLogger(VocationServerImpl.class.getName());


	@Override
	public List<Vocation> getVocationAll() {		
		return vocationMapper.select(null, null, null, null);
	}	

	@Override
	public List<Vocation> getVocationByVocationId(String vocationId) {
		String where="vocation_id='"+vocationId+"'";
		return vocationMapper.selectByVocationId(where, null, null, null);
	}
	
	@Override
	public ResponseResult<Void> updateVocation(Vocation vocation, HttpServletRequest request) {
		ResponseResult<Void> rr;					
		try {				
			String whereid="vocation_id='"+vocation.getVocationId()+"'";			
			String where1="v_id="+vocation.getvId();
			List<Vocation> vocationByid=vocationMapper.select(whereid, null, null, null);
			List<Vocation> listid=vocationMapper.select(where1, null, null, null);	
			if(vocationByid.size()>0 && !vocation.getVocationId().equals(listid.get(0).getVocationId())){
				rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":职业代码数据重复,请重新输入");
				logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：职业信息修改   操作：修改信息  状态：FAILED!");
			}else{
				String wherename="vocation_name='"+vocation.getVocationName()+"'";
				List<Vocation> vocationByname=vocationMapper.select(wherename, null, null, null);
				if(vocationByname.size()>0 && !listid.get(0).getVocationName().equals(vocation.getVocationName()) ){
					rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":职业名称数据重复,请重新输入");
					logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：职业信息修改   操作：修改信息  状态：FAILED!");
				}else{
					vocationMapper.updateVocationById(vocation);
					rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
					logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：职业信息修改   操作：修改信息  状态：OK!");
				}
			}			
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：职业信息修改  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}		
		return rr;
	}

	@Override
	public ResponseResult<Void> insertVocation(Vocation vocation, HttpServletRequest request) {
		ResponseResult<Void> rr;					
		try {	
			String whereid="vocation_id='"+vocation.getVocationId()+"'";		
			List<Vocation> vocationByid=vocationMapper.select(whereid, null, null, null);			
			if(vocationByid.size()>0){
				rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":职业代码数据重复,请重新输入");
				logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：职业信息添加    操作：添加 信息  状态：FAILED!");
			}else{
				String wherename="vocation_name='"+vocation.getVocationName()+"'";
				List<Vocation> vocationByname=vocationMapper.select(wherename, null, null, null);
				if(vocationByname.size()>0){
					rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":职业名称数据重复,请重新输入");
					logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：职业信息添加    操作：添加 信息  状态：FAILED!");
				}else{
					vocationMapper.insertVocation(vocation);
					rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
					logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：职业信息添加    操作：添加 信息  状态：OK!");
				}
			}			
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：职业信息添加  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}		
		return rr;
	}	
	@Override
	public ResponseResult<Void> deleteVocationById(Integer vId, HttpServletRequest request) {
		ResponseResult<Void> rr;					
		try {						
			vocationMapper.deleteVocationById(vId);
			rr=new ResponseResult<Void>(ResponseResult.STATE_OK,Constants.OPERATION_SUCCEED);
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：职业信息删除   操作：删除信息  状态：OK!");					
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：职业信息删除  错误信息: "+e);
			rr=new ResponseResult<Void>(ResponseResult.ERR,Constants.OPERATION_FAILED+":数据存在异常，请联系工作人员处理！");
		}		
		return rr;
	}	

}
