package cn.hqtmain.service;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import cn.hqtmain.entity.Personality;
import cn.hqtmain.entity.ResponseResult;



public interface IPersonalityServer
{
	ResponseResult<Void> addPersonality(Personality personality,HttpServletRequest request);	
	List<Personality> getPersonalityAll();
	List<Personality> getPersonalityByPersonalityId(Integer personalityId);	
	ResponseResult<Void> updatePersonality(Personality personality,HttpServletRequest request);
	ResponseResult<Void> deletePersonality(Integer personalityId,HttpServletRequest request);
}
