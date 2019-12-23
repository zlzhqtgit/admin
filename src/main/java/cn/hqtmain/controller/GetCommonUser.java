package cn.hqtmain.controller;


import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.crypto.hash.SimpleHash;
import cn.hqtmain.entity.Menu;
import net.sf.json.JSONArray;

/**
* @Title: GetCommonUser.java
* @Package cn.hqtzytb.controller
* @Description:(用一句话描述该文件做什么)
* @author: ZhouLingZhang
* @date 2019年11月11日
* @Copyright:好前途教育
* @version V1.0
 */
public class GetCommonUser {
	
	private  static final  Logger logger = LogManager.getLogger(GetCommonUser.class.getName());
	public  List<List<String>>  getJson(String jsonstr,HttpServletRequest request){		
		try {
			JSONArray jsonArray=JSONArray.fromObject(jsonstr);
			if(jsonArray.size()>0){
				List<List<String>> listTest = new ArrayList<List<String>>();
				 for (int j = 0; j < jsonArray.size(); j++) {
			            List<String> columnList = new ArrayList<String>();
			            for(int i=0;i<jsonArray.getJSONArray(j).size();i++){
			            	 columnList.add(i,(String) jsonArray.getJSONArray(j).getString(i));
			            }			         
			            listTest.add(j, columnList);           	
				 }  
				return listTest;
			}else{
				return null;
			}		 	
		} catch (Exception e) {
			logger.error("访问路径："+request.getRequestURI()+"操作： 二维数组转List 错误信息: "+e);
			return null;
		}			
	}
	
	//菜单信息排序
	public List<Menu> sort(int parentId, List<Menu> listB, List<Menu> listA) {
        for (Menu menu : listB) {
            if (menu.getParentId().equals(parentId)) {
                listA.add(menu);
                sort(menu.getMenuId(), listB, listA);
            }
        }
        return listA;
    }
	
	//MD5加密方法 	 
	public String getEncrpytedPassword(String hashAlgorithmName,String password, String uuid,int  hashIterations) {    
	    Object result = new SimpleHash(hashAlgorithmName,password,uuid,hashIterations);	   
		return (result.toString()).toUpperCase();
	}


}
