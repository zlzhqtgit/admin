package cn.hqtmain.entity;

import java.io.Serializable;

/**
* @Title: AdminMenu.java
* @Package cn.hqtmain.entity
* @Description:(用一句话描述该文件做什么)
* @author: ZhouLingZhang
* @date 2019年11月29日
* @Copyright:好前途教育
* @version V1.0
*/
public class Menu implements Serializable {
	

	/**
	* @Fields serialVersionUID :(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 5424406809111970295L;
	private Integer menuId;
	private String menuName;
	private String menuUrl;
	private String menuIcon;
	private String authority;
	private Integer isMenu;
	private Integer parentId;
	/**
	* 创建一个新的实例 AdminMenu.
	*
	*/
	public Menu() {
		super();
	}
	/**
	* 创建一个新的实例 AdminMenu.
	*
	* @param menuId
	* @param menuName
	* @param menuUrl
	* @param menuIcon
	* @param authority
	* @param isMenu
	* @param parentId
	*/
	public Menu(Integer menuId, String menuName, String menuUrl, String menuIcon, String authority, Integer isMenu,
			Integer parentId) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.menuIcon = menuIcon;
		this.authority = authority;
		this.isMenu = isMenu;
		this.parentId = parentId;
	}
	/**
	 * @return the menuId
	 */
	public Integer getMenuId() {
		return menuId;
	}
	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	/**
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}
	/**
	 * @param menuName the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/**
	 * @return the menuUrl
	 */
	public String getMenuUrl() {
		return menuUrl;
	}
	/**
	 * @param menuUrl the menuUrl to set
	 */
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	/**
	 * @return the menuIcon
	 */
	public String getMenuIcon() {
		return menuIcon;
	}
	/**
	 * @param menuIcon the menuIcon to set
	 */
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	/**
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}
	/**
	 * @param authority the authority to set
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	/**
	 * @return the isMenu
	 */
	public Integer getIsMenu() {
		return isMenu;
	}
	/**
	 * @param isMenu the isMenu to set
	 */
	public void setIsMenu(Integer isMenu) {
		this.isMenu = isMenu;
	}
	/**
	 * @return the parentId
	 */
	public Integer getParentId() {
		return parentId;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	/* (非 Javadoc)
	* <p>Title: toString</p>
	* <p>Description: </p>
	* @return
	* @see java.lang.Object#toString()
	*/
	@Override
	public String toString() {
		return "AdminMenu [menuId=" + menuId + ", menuName=" + menuName + ", menuUrl=" + menuUrl + ", menuIcon="
				+ menuIcon + ", authority=" + authority + ", isMenu=" + isMenu + ", parentId=" + parentId + "]";
	}
	
	
}
