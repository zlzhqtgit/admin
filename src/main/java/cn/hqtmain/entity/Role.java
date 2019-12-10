package cn.hqtmain.entity;

import java.io.Serializable;

public class Role extends Company implements Serializable{	

	
	/**
	* @Fields serialVersionUID :(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 6567692348963636265L;
	private Integer roleId;
	private Integer cid;
	private String roleName;
	private String roleAuthority;
	private String roleDescription;
	/**
	* 创建一个新的实例 Role.
	*
	*/
	public Role() {
		super();
	}
	/**
	* 创建一个新的实例 Role.
	*
	* @param roleId
	* @param cid
	* @param roleName
	* @param roleAuthority
	* @param roleDescription
	*/
	public Role(Integer roleId, Integer cid, String roleName, String roleAuthority, String roleDescription) {
		super();
		this.roleId = roleId;
		this.cid = cid;
		this.roleName = roleName;
		this.roleAuthority = roleAuthority;
		this.roleDescription = roleDescription;
	}
	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the cid
	 */
	public Integer getCid() {
		return cid;
	}
	/**
	 * @param cid the cid to set
	 */
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the roleAuthority
	 */
	public String getRoleAuthority() {
		return roleAuthority;
	}
	/**
	 * @param roleAuthority the roleAuthority to set
	 */
	public void setRoleAuthority(String roleAuthority) {
		this.roleAuthority = roleAuthority;
	}
	/**
	 * @return the roleDescription
	 */
	public String getRoleDescription() {
		return roleDescription;
	}
	/**
	 * @param roleDescription the roleDescription to set
	 */
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", cid=" + cid + ", roleName=" + roleName + ", roleAuthority=" + roleAuthority
				+ ", roleDescription=" + roleDescription + "]";
	}
	
}
