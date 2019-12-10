
package cn.hqtmain.entity;

import cn.hqtmain.util.Status;

/** 
  * 用户 pojo类
  * @Author  gz
  * @CreateDate  2017年12月25日 下午2:50:26 
  * @Description  
  */
public class UserChat {
	
	private String id;	
	private String adminid;
	private String username;	
	private String usertype;
	
	/**
	 * 枚举 记录用户在线状态
	 * 设置默认不在线
	 */
	private Status status=Status.offline;
	
	
	public String getAdminid() {
		return adminid;
	}
	
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String getUsername() {
		return username;
	}
	

	public void setUsername(String username) {
		this.username = username;
	}


	public String getUsertype() {
		return usertype;
	}
	


	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getId() {
		return id;
	}
	

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", adminid=" + adminid + ", username=" + username + ", usertype=" + usertype + ", status=" + status + "]";
	}
	

	
	
	

}
