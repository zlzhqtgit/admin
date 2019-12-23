package cn.hqtmain.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import cn.hqtmain.entity.ResponseResult;
import cn.hqtmain.entity.Vocation;


public interface IVocationServer
{	
	List<Vocation> getVocationAll();
	List<Vocation> getVocationByVocationId(String vocationId);
	ResponseResult<Void> updateVocation(Vocation vocation,HttpServletRequest request);
	ResponseResult<Void> insertVocation(Vocation vocation,HttpServletRequest request);
	/**
	 * 删除职业数据信息
	 * @param vId
	 * @return
	 */
	ResponseResult<Void> deleteVocationById(Integer vId,HttpServletRequest request);
	
}
