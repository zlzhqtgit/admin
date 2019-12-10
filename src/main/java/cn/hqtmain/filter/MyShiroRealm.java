package cn.hqtmain.filter;



import java.util.Arrays;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import cn.hqtmain.entity.Admin;
import cn.hqtmain.service.IAdminServer;
import cn.hqtmain.util.LoginSession;

/**
* @Title: MyShiroRealm.java
* @Package cn.hqtmain.filter
* @Description:(用一句话描述该文件做什么)
* @author: ZhouLingZhang
* @date 2019年11月27日
* @Copyright:好前途教育
* @version V1.0
*/
public class MyShiroRealm extends AuthorizingRealm{
	
	@Autowired
	public IAdminServer adminServer;

	//每次验证权限执行
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {		
		String[] ids=LoginSession.getSession().getUserAuthority().split(";");			
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if(ids.length > 0){
			for(int i=0;i<ids.length;i++){
				info.addStringPermission(ids[i]);
			}			
			return info;
		}
		return null; 		
	}

	//登录执行
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {		
		String username=(String)token.getPrincipal();		
		Admin admin=adminServer.getAdminByUsername(username);
		if(admin!=null){
			ByteSource byteSource=ByteSource.Util.bytes(admin.getUuid());
			SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(username,admin.getPassword(),getName());
			info.setCredentialsSalt(byteSource);
			return  info;
		}
		return null;
	}

}
