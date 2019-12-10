package cn.hqtmain.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import cn.hqtmain.entity.Admin;

/**
* @Title: LoginSession.java
* @Package cn.hqtmain.util
* @Description:(用一句话描述该文件做什么)
* @author: ZhouLingZhang
* @date 2019年11月30日
* @Copyright:好前途教育
* @version V1.0
*/
public class LoginSession {
	
	public static   Admin getSession(){
		Subject subject = SecurityUtils.getSubject();
		Session session=subject.getSession();
		Admin admin=new Admin();
		if(session.getAttribute(Constants.SYSTEM_USER)!=null){
			admin=(Admin) session.getAttribute(Constants.SYSTEM_USER);
			return admin;
		}		
		return null;		
	}
}
