package cn.hqtmain.controller;

import org.apache.shiro.crypto.hash.SimpleHash;

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
		String hashAlgorithmName = "MD5";//加密方式
	    Object crdentials = "111111";//密码原值
	    Object salt = "E5160889-0ADC-47B7-90F4-EB0080752C73";//盐值
	    int hashIterations = 1024;//加密1024次
	    Object result = new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations);
	    System.out.println((result.toString()).toUpperCase());

	}

}
