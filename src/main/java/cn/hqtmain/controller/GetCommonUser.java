package cn.hqtmain.controller;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.shiro.crypto.hash.SimpleHash;
import cn.hqtmain.entity.Menu;


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
	public List<Menu> sort(int parentId, List<Menu> listB, List<Menu> listA) {
        for (Menu menu : listB) {
            if (menu.getParentId().equals(parentId)) {
                listA.add(menu);
                sort(menu.getMenuId(), listB, listA);
            }
        }
        return listA;
    }
	/**
	 * MD5加密方法 
	 * @param password密码
	 * @param uuid 密码加密处理的uuid
	 * @return MD5 返回加密好的字符串
	 */
	public String getEncrpytedPassword(String hashAlgorithmName,String password, String uuid,int  hashIterations) {    
	    Object result = new SimpleHash(hashAlgorithmName,password,uuid,hashIterations);	   
		return (result.toString()).toUpperCase();
	}

	public List<String> gethld(Map<String, Integer> cpFengshu) {
		// 排序以后截取前3个类型代码
		List<String> mobileList = cpFengshu.entrySet().stream()
				.sorted((Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) -> o2.getValue() - o1.getValue())
				.map(entry -> entry.getKey()).collect(Collectors.toList()).subList(0, 3);
		return mobileList;
	}

	public String getMbti(Map<String, Integer> cpFengshu) {
		String cpresult = "";
		// 判断第一层面E-I,属于那种，如果分数相同取I
		if (cpFengshu.get("E") > cpFengshu.get("I")) {
			cpresult += "E";
		} else {
			cpresult += "I";
		}
		// 判断第二层面S-N,属于那种，如果分数相同取N
		if (cpFengshu.get("S") > cpFengshu.get("N")) {
			cpresult += "S";
		} else {
			cpresult += "N";
		}
		// 判断第三层面T-F,属于那种，如果分数相同取F
		if (cpFengshu.get("T") > cpFengshu.get("F")) {
			cpresult += "T";
		} else {
			cpresult += "F";
		}
		// 判断第四层面J-P,属于那种，如果分数相同取P
		if (cpFengshu.get("J") > cpFengshu.get("P")) {
			cpresult += "J";
		} else {
			cpresult += "P";
		}
		return cpresult;
	}

}
