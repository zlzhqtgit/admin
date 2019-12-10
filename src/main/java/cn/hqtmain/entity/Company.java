package cn.hqtmain.entity;

import java.io.Serializable;
import java.util.Date;

/**
* @Title: Company.java
* @Package cn.hqtmain.entity
* @Description:(用一句话描述该文件做什么)
* @author: ZhouLingZhang
* @date 2019年12月3日
* @Copyright:好前途教育
* @version V1.0
*/
public class Company implements Serializable{
	
	/**
	* @Fields serialVersionUID :(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 3742834995148456516L;	
	private Integer companyId;
	private String companyNumber;
	private String companyName;
	private String companyAdress;
	private Date creationTime;
	/**
	* 创建一个新的实例 Company.
	*
	*/
	public Company() {
		super();
	}
	/**
	* 创建一个新的实例 Company.
	*
	* @param companyId
	* @param companyNumber
	* @param companyName
	* @param companyAdress
	* @param creationTime
	*/
	public Company(Integer companyId, String companyNumber, String companyName, String companyAdress,
			Date creationTime) {
		super();
		this.companyId = companyId;
		this.companyNumber = companyNumber;
		this.companyName = companyName;
		this.companyAdress = companyAdress;
		this.creationTime = creationTime;
	}
	/**
	 * @return the companyId
	 */
	public Integer getCompanyId() {
		return companyId;
	}
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	/**
	 * @return the companyNumber
	 */
	public String getCompanyNumber() {
		return companyNumber;
	}
	/**
	 * @param companyNumber the companyNumber to set
	 */
	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the companyAdress
	 */
	public String getCompanyAdress() {
		return companyAdress;
	}
	/**
	 * @param companyAdress the companyAdress to set
	 */
	public void setCompanyAdress(String companyAdress) {
		this.companyAdress = companyAdress;
	}
	/**
	 * @return the creationTime
	 */
	public Date getCreationTime() {
		return creationTime;
	}
	/**
	 * @param creationTime the creationTime to set
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	/* (非 Javadoc)
	* <p>Title: toString</p>
	* <p>Description: </p>
	* @return
	* @see java.lang.Object#toString()
	*/
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyNumber=" + companyNumber + ", companyName=" + companyName
				+ ", companyAdress=" + companyAdress + ", creationTime=" + creationTime + "]";
	}
	
}
