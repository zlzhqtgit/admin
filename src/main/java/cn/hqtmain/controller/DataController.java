package cn.hqtmain.controller;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import cn.hqtmain.entity.Personality;
import cn.hqtmain.entity.ResponseResult;
import cn.hqtmain.entity.Specialty;
import cn.hqtmain.entity.University;
import cn.hqtmain.entity.UniversityRelation;
import cn.hqtmain.entity.Vocation;
import cn.hqtmain.exception.MyRuntimeException;
import cn.hqtmain.service.IPersonalityServer;
import cn.hqtmain.service.ISpecialtyServer;
import cn.hqtmain.service.IUniversityServer;
import cn.hqtmain.service.IVocationServer;
import cn.hqtmain.util.LoginSession;
import net.sf.json.JSONArray;




/**
* @Title: DataController.java
* @Package cn.hqtmain.controller
* @Description:(用一句话描述该文件做什么)
* @author: ZhouLingZhang
* @date 2019年12月11日
* @Copyright:好前途教育
* @version V1.0
*/
@Controller
public class DataController {
	
	@Autowired
	public ISpecialtyServer specialtyServer;
	@Autowired
	public IVocationServer vocationServer;
	@Autowired
	public IPersonalityServer personalityServer;
	@Autowired
	public IUniversityServer universityServer;
	
	private  static final  Logger logger = LogManager.getLogger(DataController.class.getName());
	
	
	
	/**
	* @Title: showhqtData
	* @Description: (在线咨询页面)
	* @param @param map
	* @param @param session
	* @param @param response
	* @param @param request
	* @param @return
	* @param @throws MyRuntimeException    
	* @return String    
	* @throws
	 */
	@RequestMapping("/hqt_data")	
	public String showhqtData(ModelMap map,HttpSession session,HttpServletResponse response,HttpServletRequest request) throws MyRuntimeException{	
		try {
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：数据中心模块  操作：进入模块  状态：OK!");
			return "data/hqt_data";	
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：数据中心页面  错误信息: "+e);
			throw new MyRuntimeException(e);
		}						
	}
	/**
	 * @throws MyRuntimeException 
	* @Title: showHqtSpecialty
	* @Description: (专业信息响应页面)
	* @param @param map
	* @param @param session
	* @param @param response
	* @param @param request
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("/hqt_specialty")	
	public String showHqtSpecialty(ModelMap map,HttpSession session,HttpServletResponse response,HttpServletRequest request) throws MyRuntimeException{
		try {
			List<Specialty> specialtyAll = specialtyServer.getSpecialtyAll();		
			map.addAttribute("specialtyAll", specialtyAll);
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：专业库信息模块  操作：进入模块  状态：OK!");
			return "data/hqt_specialty";
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：专业信息页面  错误信息: "+e);
			throw new MyRuntimeException(e);
		}						
	}
	/**
	* @Title: showhqtEdit
	* @Description: (专业信息编辑页面)
	* @param @param specialtyId
	* @param @param map
	* @param @param session
	* @param @param response
	* @param @param request
	* @param @return
	* @param @throws MyRuntimeException    
	* @return String    
	* @throws
	 */
	@RequestMapping("/hqt_specialtyedit")	
	public String showhqtEdit(String specialtyId,ModelMap map,HttpSession session,HttpServletResponse response,HttpServletRequest request) throws MyRuntimeException{	
		try {
			List<Specialty> specialtyBySpecialtyId = specialtyServer.getSpecialtyBySpecialtyId(specialtyId);		
			map.addAttribute("specialtyBySpecialtyId", specialtyBySpecialtyId);		
			GetCommonUser get=new GetCommonUser();
			//就业职业方向
			List<List<String>> listjyzyfx = get.getJson(specialtyBySpecialtyId.get(0).getEmploymentCareerDirection(),request);			
			if(listjyzyfx==null){
				map.addAttribute("listStr1",specialtyBySpecialtyId.get(0).getEmploymentCareerDirection());			
			}
			map.addAttribute("listjyzyfx",listjyzyfx);			
			//就业行业分布
			List<List<String>> listjyhyfb = get.getJson(specialtyBySpecialtyId.get(0).getEmploymentIndustryDistribution(),request);			
			if(listjyhyfb==null){
				map.addAttribute("listStr2",specialtyBySpecialtyId.get(0).getEmploymentIndustryDistribution());			
			}
			map.addAttribute("listjyhyfb",listjyhyfb);			
			
			//就业地区分布
			List<List<String>> listjydqfb = get.getJson(specialtyBySpecialtyId.get(0).getEmploymentAreaDistribution(),request);			
			if(listjydqfb==null){
				map.addAttribute("listStr3",specialtyBySpecialtyId.get(0).getEmploymentAreaDistribution());			
			}
			map.addAttribute("listjydqfb",listjydqfb);			
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：数据中心模块  操作：进入模块  状态：OK!");
			return "data/hqt_specialtyedit";				
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：专业信息编辑页面  错误信息: "+e);
			throw new MyRuntimeException(e);
		}	
	}
	/**
	* @Title: handleSEdit
	* @Description: (专业信息编辑实现方法)
	* @param @param specialty
	* @param @param session
	* @param @param request
	* @param @return    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping(value = "/specialtyedit", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleSEdit(Specialty specialty, HttpSession session,HttpServletRequest request)
	{	
		ResponseResult<Void> rr=specialtyServer.updateSpecialty(specialty, request);	
		return rr;
	}
	/**
	* @Title: showhqtAdd
	* @Description: (专业信息添加页面)
	* @param @param map
	* @param @param session
	* @param @param response
	* @param @param request
	* @param @return
	* @param @throws MyRuntimeException    
	* @return String    
	* @throws
	 */
	@RequestMapping("/hqt_specialtyadd")	
	public String showhqtAdd(ModelMap map,HttpSession session,HttpServletResponse response,HttpServletRequest request) throws MyRuntimeException{
		try {
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：专业信息添加模块  操作：进入模块  状态：OK!");
			return "data/hqt_specialtyadd";
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：专业信息添加页面  错误信息: "+e);
			throw new MyRuntimeException(e);
		}					
	}
	/**
	* @Title: handleSAdd
	* @Description: (专业信息添加实现方法)
	* @param @param specialty
	* @param @param session
	* @param @param request
	* @param @return    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping(value = "/specialtyadd", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleSAdd(Specialty specialty, HttpSession session,HttpServletRequest request)
	{	
		ResponseResult<Void> rr=specialtyServer.addSpecialty(specialty, request);
		return rr;
	}
	/**
	* @Title: handleSDel
	* @Description: (专业信息删除方法)
	* @param @param id
	* @param @param session
	* @param @param request
	* @param @return    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping(value = "/specialtydel", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleSDel(Integer id, HttpSession session,HttpServletRequest request)
	{	
		ResponseResult<Void> rr=specialtyServer.deleteSpecialty(id, request);		
		return rr;
	}
	/**
	* @Title: showHqtVocation
	* @Description: (职业信息页面)
	* @param @param map
	* @param @param session
	* @param @param response
	* @param @param request
	* @param @return
	* @param @throws MyRuntimeException    
	* @return String    
	* @throws
	 */
	@RequestMapping("/hqt_vocation")	
	public String showHqtVocation(ModelMap map,HttpSession session,HttpServletResponse response,HttpServletRequest request) throws MyRuntimeException{
		try {
			List<Vocation> vocationAll = vocationServer.getVocationAll();		
			map.addAttribute("vocationAll", vocationAll);
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：职业信息模块  操作：进入模块  状态：OK!");
			return "data/hqt_vocation";	
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：职业信息页面  错误信息: "+e);
			throw new MyRuntimeException(e);
		}			 			
	}
	/**
	* @Title: showHqtVocationAdd
	* @Description: (职业信息添加页面)
	* @param @param map
	* @param @param session
	* @param @param response
	* @param @param request
	* @param @return
	* @param @throws MyRuntimeException    
	* @return String    
	* @throws
	 */
	@RequestMapping("/hqt_vocationadd")	
	public String showHqtVocationAdd(ModelMap map,HttpSession session,HttpServletResponse response,HttpServletRequest request) throws MyRuntimeException{	
		try {
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：职业信息添加模块  操作：进入模块  状态：OK!");
			return "data/hqt_vocationadd";
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：职业信息添加页面  错误信息: "+e);
			throw new MyRuntimeException(e);
		}						
	}
	/**
	* @Title: handleadd
	* @Description: (职业信息添加实现方法)
	* @param @param vocation
	* @param @param session
	* @param @param request
	* @param @return    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping(value = "/vocationadd", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleadd(Vocation vocation, HttpSession session,HttpServletRequest request)
	{	
		ResponseResult<Void> rr=vocationServer.insertVocation(vocation, request);
		return rr;
	}
	/**
	* @Title: showHqtVocationEdit
	* @Description: (职业信息编辑页面)
	* @param @param map
	* @param @param vocationId
	* @param @param session
	* @param @param response
	* @param @param request
	* @param @return
	* @param @throws MyRuntimeException    
	* @return String    
	* @throws
	 */
	@RequestMapping("/hqt_vocationedit")	
	public String showHqtVocationEdit(ModelMap map,String vocationId,HttpSession session,HttpServletResponse response,HttpServletRequest request) throws MyRuntimeException{	
		try {
			List<Vocation> vocationByVocationId = vocationServer.getVocationByVocationId(vocationId);
			map.addAttribute("vocationByVocationId", vocationByVocationId);
			 GetCommonUser get=new GetCommonUser();
			//就业前景			 
			 if(vocationByVocationId.get(0).getProspect() !=null && vocationByVocationId.get(0).getProspect().indexOf("[") == 0) {
				JSONArray jyqj = JSONArray.fromObject(vocationByVocationId.get(0).getProspect());       
				List<List<String>> listhyfb = get.getJson(jyqj.get(0).toString(),request);	
				List<List<String>> listdqfb = get.getJson(jyqj.get(1).toString(),request);				
				if(listhyfb==null){
					map.addAttribute("listStr1",jyqj.get(0).toString());
				}
				if(listdqfb==null){
					map.addAttribute("listStr2",jyqj.get(1).toString());
				}
				map.addAttribute("listhyfb",listhyfb);
				map.addAttribute("listdqfb",listdqfb);
			 }			  
			//薪资趋势	
			List<List<String>> listxzqs = get.getJson(vocationByVocationId.get(0).getSalaryTrend(),request);			
			if(listxzqs==null){
				map.addAttribute("listStr3",vocationByVocationId.get(0).getSalaryTrend());			
			}
			map.addAttribute("listxzqs",listxzqs);								
			//薪资分布	
			List<List<String>> listxzfb = get.getJson(vocationByVocationId.get(0).getSalaryDistribution(),request);			
			if(listxzfb==null){
				map.addAttribute("listStr4",vocationByVocationId.get(0).getSalaryDistribution());			
			}
			map.addAttribute("listxzfb",listxzfb);			 			 
			//就业趋势(按学历)
			List<List<String>> listjyqsxl = get.getJson(vocationByVocationId.get(0).getEmploymentSituationEducation(),request);			
			if(listjyqsxl==null){
				map.addAttribute("listStr5",vocationByVocationId.get(0).getEmploymentSituationEducation());			
			}
			map.addAttribute("listjyqsxl",listjyqsxl);			 			 
			//'就业趋势(按经验)	
			List<List<String>> listjyqsjy = get.getJson(vocationByVocationId.get(0).getEmploymentSituationExperience(),request);			
			if(listjyqsjy==null){
				map.addAttribute("listStr6",vocationByVocationId.get(0).getEmploymentSituationExperience());			
			}
			map.addAttribute("listjyqsjy",listjyqsjy);				
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：专业库信息编辑模块  操作：进入模块  状态：OK!");
			return "data/hqt_vocationedit";
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：职业信息编辑页面  错误信息: "+e);
			throw new MyRuntimeException(e);
		}							
	}
	/**
	* @Title: handleedit
	* @Description: (职业信息编辑实现方法)
	* @param @param vocation
	* @param @param session
	* @param @param request
	* @param @return    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping(value = "/vocationedit", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleedit(Vocation vocation,HttpServletRequest request)
	{	
		ResponseResult<Void> rr=vocationServer.updateVocation(vocation, request);	
		return rr;
	}
	/**
	* @Title: handleDel
	* @Description: (职业信息删除方法)
	* @param @param vId
	* @param @param session
	* @param @param request
	* @param @return    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping(value = "/vocationdel", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handleDel(Integer vId,HttpServletRequest request)
	{	
		ResponseResult<Void> rr=vocationServer.deleteVocationById(vId, request);	
		return rr;
	}
	/**
	* @Title: showHqtPersonality
	* @Description: (测评响应页面)
	* @param @param map
	* @param @param request
	* @param @return
	* @param @throws MyRuntimeException    
	* @return String    
	* @throws
	 */
	@RequestMapping("/hqt_personality")	
	public String showHqtPersonality(ModelMap map,HttpServletRequest request) throws MyRuntimeException{	
		try {
			List<Personality> personalityAll = personalityServer.getPersonalityAll();
			map.addAttribute("personalityAll", personalityAll);
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：测评信息模块  操作：进入模块  状态：OK!");
			return "data/hqt_personality";
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：测评信息模块页面  错误信息: "+e);
			throw new MyRuntimeException(e);
		}						
	}
	@RequestMapping("/hqt_personalityedit")	
	public String showHqtPersonalityEdit(ModelMap map,Integer personalityId,HttpServletRequest request) throws MyRuntimeException{	
		try {
			List<Personality> personalityByPersonalityId = personalityServer.getPersonalityByPersonalityId(personalityId);
			map.addAttribute("ListById", personalityByPersonalityId);
			GetCommonUser get=new GetCommonUser();
			//测评相关的专业			
			List<List<String>> listSpecialty = get.getJson(personalityByPersonalityId.get(0).getPersonalitySpecialty(),request);			
			if(listSpecialty==null){
				map.addAttribute("listStr",personalityByPersonalityId.get(0).getPersonalitySpecialty());			
			}
			map.addAttribute("listSpecialty",listSpecialty);				  
			//测评相关的职业	
			 List<List<String>> listVocation = get.getJson(personalityByPersonalityId.get(0).getPersonalityVocation(),request);			
			if(listVocation==null){
				map.addAttribute("listStr1",personalityByPersonalityId.get(0).getPersonalityVocation());			
			}
			map.addAttribute("listVocation",listVocation);
				
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：测评信息编辑模块  操作：进入模块  状态：OK!");
			return "data/hqt_personalityedit";
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：测评信息编辑模块页面  错误信息: "+e);
			throw new MyRuntimeException(e);
		}						
	}
	@RequestMapping(value = "/personalityedit", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handlePersonalityEdit(Personality personality,HttpServletRequest request)
	{	
		ResponseResult<Void> rr=personalityServer.updatePersonality(personality, request);		
		return rr;
	}
	@RequestMapping("/hqt_personalityadd")	
	public String showHqtPersonalityAdd(ModelMap map,HttpServletRequest request) throws MyRuntimeException{	
		try {			
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：测评信息模块  操作：进入模块  状态：OK!");
			return "data/hqt_personalityadd";
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：测评信息模块页面  错误信息: "+e);
			throw new MyRuntimeException(e);
		}						
	}
	@RequestMapping(value = "/personalityadd", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handlePersonalityAdd(Personality personality,HttpServletRequest request)
	{	
		ResponseResult<Void> rr=personalityServer.addPersonality(personality, request);	
		return rr;
	}
	@RequestMapping(value = "/personalitydel", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handlePersonalityDel(Integer personalityId,HttpServletRequest request)
	{	
		ResponseResult<Void> rr=personalityServer.deletePersonality(personalityId, request);	
		return rr;
	}
	/**
	* @Title: handldelimg
	* @Description: (用于学校图片删除)
	* @param @param id
	* @param @param path
	* @param @param request
	* @param @return
	* @param @throws IllegalStateException
	* @param @throws IOException    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping(value = "/universitydelimg", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handldelimg(Integer id,String path,HttpServletRequest request) throws IllegalStateException, IOException{
		ResponseResult<Void> rr;
		List<University> universityById = universityServer.getUniversityById(id);		
		String classpath = this.getClass().getResource("/").getPath(); 				
		String path1 = classpath.replaceAll("/WEB-INF/classes/", "");//+"static/images/university/10001/";
		File file5 = new File(path1+path);
	    if (file5.exists()) {	        	
	    	file5.delete();       	
	    }
	    String newpath="";
	    String[] pathimg=universityById.get(0).getUniversitiesLife().split(";");
		for(int i=0;i<pathimg.length;i++){
			if(!pathimg[i].equals(path)){
				if(i==pathimg.length-1){
					newpath+=pathimg[i];
				}else{
					newpath+=pathimg[i]+";";
				}	
			}					
		}
		University university=new University();
		university.setId(id);
		university.setUniversitiesLife(newpath);
		university.setUniversitiesLogo(universityById.get(0).getUniversitiesLogo());
		rr=universityServer.updateimg(university, request);
		if(rr.getState()==1){
			rr=new ResponseResult<Void>(ResponseResult.STATE_OK,newpath);
		}
		return rr;		
	}
	/**
	* @Title: handlexyghReg
	* @Description: (用于图片上传)
	* @param @param file
	* @param @param oldpath
	* @param @param id
	* @param @param name
	* @param @param request
	* @param @return
	* @param @throws IllegalStateException
	* @param @throws IOException    
	* @return ResponseResult<Void>    
	* @throws
	 */
	@RequestMapping(value = "/universityimg", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handlexyghReg(@RequestParam(value="unimg",required=false)MultipartFile file,String oldpath,Integer id,String name,HttpServletRequest request) throws IllegalStateException, IOException{
		ResponseResult<Void> rr;
		List<University> universityById = universityServer.getUniversityById(id);
		String classpath = this.getClass().getResource("/").getPath(); 				
		String path = classpath.replaceAll("/WEB-INF/classes/", "");//+"static/images/university/10001/";
		University university=new University();
		university.setId(id);
		long time = new Date().getTime();
	    String extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		File file5 = new File(path+"/static/images/university/"+universityById.get(0).getUniversitiesCode());
	    if (!file5.exists()) {
	        file5.mkdirs();	       			
	    }else{
	    	file5 = new File(path+oldpath);
	    	if (file5.exists()) {	    	
	    		file5.delete();	    		
	    	}	    	
	    }	 
	    file.transferTo(new File(path+"/static/images/university/"+universityById.get(0).getUniversitiesCode()+"/"+time+extName));	
		String newpath="";
		if(name.equals("yysh")){		
			if(universityById.get(0).getUniversitiesLife()!=null){
				String[] pathimg=universityById.get(0).getUniversitiesLife().split(";");
				for(int i=0;i<pathimg.length;i++){
					if(pathimg[i].equals(oldpath)){					
						pathimg[i]="/static/images/university/"+universityById.get(0).getUniversitiesCode()+"/"+time+extName;
					}
					if(i==pathimg.length-1){
						newpath+=pathimg[i];
					}else{
						newpath+=pathimg[i]+";";
					}				
				}
				if(oldpath==null ||oldpath.equals("undefined")){
					newpath+=";/static/images/university/"+universityById.get(0).getUniversitiesCode()+"/"+time+extName;
				}
			}else{
				newpath="/static/images/university/"+universityById.get(0).getUniversitiesCode()+"/"+time+extName;
			}
			university.setUniversitiesLife(newpath);
			university.setUniversitiesLogo(universityById.get(0).getUniversitiesLogo());			
		}else{
			newpath="/static/images/university/"+universityById.get(0).getUniversitiesCode()+"/"+time+extName;
			university.setUniversitiesLife(universityById.get(0).getUniversitiesLife());
			university.setUniversitiesLogo(newpath);			
		}
		rr=universityServer.updateimg(university, request);
		if(rr.getState()==1){
			rr=new ResponseResult<Void>(ResponseResult.STATE_OK,newpath);
		}
		return rr;		
	}
	/**
	* @Title: showHqtUniversity
	* @Description: (学校信息响应页面)
	* @param @param map
	* @param @param request
	* @param @return
	* @param @throws MyRuntimeException    
	* @return String    
	* @throws
	 */
	@RequestMapping("/hqt_university")	
	public String showHqtUniversity(ModelMap map,HttpServletRequest request) throws MyRuntimeException{	
		try {	
			List<University> universityAll = universityServer.getUniversityAll();			
			map.addAttribute("universityAll", universityAll);
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：学校信息模块  操作：进入模块  状态：OK!");
			return "data/hqt_university";
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：学校信息模块页面  错误信息: "+e);
			throw new MyRuntimeException(e);
		}						
	}
	/**
	* @Title: showHqtUniversityEdit
	* @Description: (学校信息编辑页面)
	* @param @param map
	* @param @param id
	* @param @param request
	* @param @return
	* @param @throws MyRuntimeException    
	* @return String    
	* @throws
	 */
	@RequestMapping("/hqt_universityedit")	
	public String showHqtUniversityEdit(ModelMap map,Integer  id,HttpServletRequest request) throws MyRuntimeException{	
		try {	
			List<University> universityById = universityServer.getUniversityById(id);
			universityById.get(0).getUniversitiesIntroduction();
			map.addAttribute("universityById", universityById.get(0));
			GetCommonUser get=new GetCommonUser();
			//院校属性
			if(universityById.get(0).getUniversitiesAttributes()==null || universityById.get(0).getUniversitiesAttributes().indexOf("[")==-1){
				map.addAttribute("listStrAttributes",universityById.get(0).getUniversitiesAttributes());
			}else{
				JSONArray universitiesAttributes = JSONArray.fromObject(universityById.get(0).getUniversitiesAttributes());
				map.addAttribute("universitiesAttributes",universitiesAttributes);			
			}
			//院校风采
			if(universityById.get(0).getUniversitiesLife()==null || universityById.get(0).getUniversitiesLife()==""){
				map.addAttribute("listStruniversitiesLife",universityById.get(0).getUniversitiesLife());
			}else{
				String[] universitiesLife= universityById.get(0).getUniversitiesLife().split(";");
				map.addAttribute("universitiesLife",universitiesLife);			
			}	
			//教研教学		
			List<List<String>> teachingResearch = get.getJson(universityById.get(0).getTeachingResearch(),request);			
			if(teachingResearch==null){
				map.addAttribute("listStr",universityById.get(0).getTeachingResearch());			
			}
			map.addAttribute("teachingResearch", teachingResearch);
			//重点专业		
			List<List<String>> coreSpecialty = get.getJson(universityById.get(0).getCoreSpecialty(),request);			
			if(coreSpecialty==null){
				map.addAttribute("listStrSpecialty",universityById.get(0).getCoreSpecialty());			
			}
			map.addAttribute("coreSpecialty",coreSpecialty);
			
			//重点学科
			List<List<List<String>>> coreLaboratoriesList = new ArrayList<List<List<String>>>();
		    List<List<String>> coreSubject = get.getJson(universityById.get(0).getCoreSubject(),request);
		    if(coreSubject==null){
				map.addAttribute("listStrSubject",universityById.get(0).getCoreSubject());			
			}else{
				for(int i=0;i<coreSubject.size();i++){
				       List<List<String>> list = get.getJson(coreSubject.get(i).toString(),request);
				       coreLaboratoriesList.add(i,list);   
				 }
			}		
			map.addAttribute("coreSubject",coreLaboratoriesList);
			
			//重点实验室及科研中心
			List<List<List<String>>> coreLaboratoriesList2 = new ArrayList<List<List<String>>>();
		    List<List<String>> researchCenters = get.getJson(universityById.get(0).getCoreLaboratoriesAndResearchCenters(),request);		   
		    if(researchCenters==null){
				map.addAttribute("listStrResearchCenters",universityById.get(0).getCoreLaboratoriesAndResearchCenters());			
			}else{
				for(int i=0;i<researchCenters.size();i++){
				       List<List<String>> list = get.getJson(researchCenters.get(i).toString(),request);
				       coreLaboratoriesList2.add(i,list);   
				 }
			}		
			map.addAttribute("researchCenters",coreLaboratoriesList2);
			//录取批次
			if(universityById.get(0).getAdmissionLot()==null || universityById.get(0).getAdmissionLot().indexOf("[")==-1){
				map.addAttribute("listStradmissionLot",universityById.get(0).getAdmissionLot());
			}else{
				JSONArray admissionLot = JSONArray.fromObject(universityById.get(0).getAdmissionLot());
				map.addAttribute("admissionLot",admissionLot);			
			}			
			logger.info("用户名："+LoginSession.getSession().getUsername()+" 模块名：学校信息模块  操作：进入模块  状态：OK!");
			return "data/hqt_universityedit";
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作：学校信息模块页面  错误信息: "+e);
			throw new MyRuntimeException(e);
		}						
	}
	@RequestMapping(value = "/universityedit", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<Void> handldeledit(University university,HttpServletRequest request){
		ResponseResult<Void> rr=universityServer.updateUniversity(university, request);		
		return rr;		
	}
	@RequestMapping(value = "/universityRelationedit", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<List<UniversityRelation>> handlUniversityRelationedit(String universitiesCode,String urYear,String urProvince,String subjectType,String admissionBatch,String  collegeScoreLine,String enrollmentPlan,String professionalAdmissionScore,String where,HttpServletRequest request){
		ResponseResult<List<UniversityRelation>> rr=universityServer.getUniversityRelationList(where, request);	
		UniversityRelation universityRelation=new UniversityRelation();
		universityRelation.setCollegeScoreLine(collegeScoreLine);
		universityRelation.setEnrollmentPlan(enrollmentPlan);
		universityRelation.setProfessionalAdmissionScore(professionalAdmissionScore);
		System.out.println(where);
		if(rr.getData().size()>0){
			universityRelation.setId(rr.getData().get(0).getId());
			universityServer.updateUniversityRelation(universityRelation,request);
		}else{
			universityRelation.setUniversitiesCode(universitiesCode);
			universityRelation.setUrYear(urYear);
			universityRelation.setUrProvince(urProvince);
			universityRelation.setSubjectType(subjectType);
			universityRelation.setAdmissionBatch(admissionBatch);
			universityServer.insertUniversityRelation(universityRelation, request);
		}
		return rr;		
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/universityRelation", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult<List<List<List<String>>>> handldUniversityRelation(String where,HttpServletRequest request){
		ResponseResult<List<List<List<String>>>> rr;
		ResponseResult<List<UniversityRelation>> rr1=universityServer.getUniversityRelationList(where, request);
		List<List<String>> datelist=new ArrayList<List<String>>();
		List<List<List<String>>> result=new ArrayList<List<List<String>>>();
		GetCommonUser get=new GetCommonUser();
		try {
			if(rr1.getState()!=0){
				rr1.getData().get(0).getCollegeScoreLine();
				//院校分数线			
				JSONArray admissionLot = JSONArray.fromObject(rr1.getData().get(0).getCollegeScoreLine());
				
				if(admissionLot.size()>1){					
					datelist.add(admissionLot);	
					result.addAll((Collection<? extends List<List<String>>>) datelist);		
				}else{
					List<List<String>> zylqfsx1=new ArrayList<List<String>>();
					result.add(zylqfsx1);
				}				
				//招生计划		
				List<List<String>> zsjh = get.getJson(rr1.getData().get(0).getEnrollmentPlan(),request);
				if(zsjh==null){
					List<List<String>> zylqfsx1=new ArrayList<List<String>>();
					result.add(zylqfsx1);
				}else{
					result.add(zsjh);
				}		
				//专业录取分数线	
				List<List<String>> zylqfsx = get.getJson(rr1.getData().get(0).getProfessionalAdmissionScore(),request);
				if(zylqfsx==null){
					List<List<String>> zylqfsx1=new ArrayList<List<String>>();
					result.add(zylqfsx1);
				}else{
					result.add(zylqfsx);
				}							
			}
		} catch (Exception e) {			
		}		
		rr=new ResponseResult<List<List<List<String>>>>(ResponseResult.STATE_OK,result);
		return rr;		
	}
}
