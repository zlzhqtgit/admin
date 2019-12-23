package cn.hqtmain.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;

import net.sf.json.JSONArray;

/**
* @Title: Wdfds.java
* @Package cn.hqtmain.controller
* @Description:(用一句话描述该文件做什么)
* @author: ZhouLingZhang
* @date 2019年11月28日
* @Copyright:好前途教育
* @version V1.0
*/
public class Wdfds {

	/**
	* @Title: main
	* @Description: (这里用一句话描述这个方法的作用)
	* @param @param args    
	* @return void    
	* @throws
	*/
	public static void main(String[] args) {

//		String hashAlgorithmName = "MD5";//加密方式
//	    Object crdentials = "111111";//密码原值
//	    Object salt = "E5160889-0ADC-47B7-90F4-EB0080752C73";//盐值
//	    int hashIterations = 1024;//加密1024次
//	    Object result = new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations);
//	    System.out.println((result.toString()).toUpperCase());
		String str="[1[],[]]";
		//String[] str1=[];
		JSONArray jsonArray = JSONArray.fromObject(str);
		//System.out.println(fromObject);
//		try {
//			if(jsonArray.size()>0){
//				List<List<String>> listTest = new ArrayList<List<String>>();
//				 for (int j = 0; j < jsonArray.size(); j++) {
//			            List<String> columnList = new ArrayList<String>();
//			            for(int i=0;i<jsonArray.getJSONArray(j).size();i++){
//			            	 columnList.add(i,(String) jsonArray.getJSONArray(j).getString(i));
//			            }			         
//			            listTest.add(j, columnList);           	
//				 }  
//				//return listTest;
//			}else{
//				//return null;
//			}		 	
//		} catch (Exception e) {
//			e.printStackTrace();
//			//logger.error("访问路径："+request.getRequestURI()+"操作： 二维数组转List 错误信息: "+e);
//			//return null;
//		}			

	}

}
