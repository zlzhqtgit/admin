package cn.hqtmain.entity;

import java.io.Serializable;
import java.util.Date;


public class Admin extends Role implements Serializable
{

	/**
	* @Fields serialVersionUID :(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = -4271677869442993989L;
	private Integer id;
	private String username;
	private String password;
	private Integer userSex;	
	private String phone;
	private String email;
	private Integer rid;
	private String userAuthority;
	private String comment;	
	private String uuid;
	private Date creatTime;
	/**
	* 创建一个新的实例 Admin.
	*
	*/
	public Admin() {
		super();
	}
	/**
	* 创建一个新的实例 Admin.
	*
	* @param id
	* @param username
	* @param password
	* @param userSex
	* @param phone
	* @param email
	* @param rid
	* @param userAuthority
	* @param comment
	* @param uuid
	* @param creatTime
	*/
	public Admin(Integer id, String username, String password, Integer userSex, String phone, String email, Integer rid,
			String userAuthority, String comment, String uuid, Date creatTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.userSex = userSex;
		this.phone = phone;
		this.email = email;
		this.rid = rid;
		this.userAuthority = userAuthority;
		this.comment = comment;
		this.uuid = uuid;
		this.creatTime = creatTime;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the userSex
	 */
	public Integer getUserSex() {
		return userSex;
	}
	/**
	 * @param userSex the userSex to set
	 */
	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the rid
	 */
	public Integer getRid() {
		return rid;
	}
	/**
	 * @param rid the rid to set
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	/**
	 * @return the userAuthority
	 */
	public String getUserAuthority() {
		return userAuthority;
	}
	/**
	 * @param userAuthority the userAuthority to set
	 */
	public void setUserAuthority(String userAuthority) {
		this.userAuthority = userAuthority;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}
	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	/**
	 * @return the creatTime
	 */
	public Date getCreatTime() {
		return creatTime;
	}
	/**
	 * @param creatTime the creatTime to set
	 */
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	/* (非 Javadoc)
	* <p>Title: toString</p>
	* <p>Description: </p>
	* @return
	* @see java.lang.Object#toString()
	*/
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password=" + password + ", userSex=" + userSex
				+ ", phone=" + phone + ", email=" + email + ", rid=" + rid + ", userAuthority=" + userAuthority
				+ ", comment=" + comment + ", uuid=" + uuid + ", creatTime=" + creatTime + "]";
	}
	
}
