
package cn.hqtmain.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/** 
  * 聊天信息  pojo类
  * @Author  gz
  * @CreateDate  2018年1月12日 下午3:23:46 
  * @Description  
  */
public class Message implements Serializable{
	

	/**
	* @Fields serialVersionUID :(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = -4205972736587534327L;
	private Integer mId;          //消息id 自增
	private String mContent;  //消息内容	
	private Date mTime;     //发送消息时间
	private String mFromuser;  //发送者id 
	private String mTouser;    //接收者id 

	/**
	* 创建一个新的实例 Message.
	*
	*/
	public Message() {
		super();
	}
	
	
	/**
	* 创建一个新的实例 Message.
	*
	* @param mId
	* @param mContent
	* @param mTime
	* @param mFromuser
	* @param mTouser
	*/
	public Message(String mContent, Date mTime, String mFromuser, String mTouser) {
		super();		
		this.mContent = mContent;
		this.mTime = mTime;
		this.mFromuser = mFromuser;
		this.mTouser = mTouser;
	}
	




	/**
	 * @return the mId
	 */
	public Integer getmId() {
		return mId;
	}


	/**
	 * @param mId the mId to set
	 */
	public void setmId(Integer mId) {
		this.mId = mId;
	}


	/**
	 * @return the mContent
	 */
	public String getmContent() {
		return mContent;
	}


	/**
	 * @param mContent the mContent to set
	 */
	public void setmContent(String mContent) {
		this.mContent = mContent;
	}


	/**
	 * @return the mTime
	 */
	public String getmTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		return sdf.format(mTime);
	}


	/**
	 * @param mTime the mTime to set
	 */
	public void setmTime(Date mTime) {
		this.mTime = mTime;
	}


	/**
	 * @return the mFromuser
	 */
	public String getmFromuser() {
		return mFromuser;
	}


	/**
	 * @param mFromuser the mFromuser to set
	 */
	public void setmFromuser(String mFromuser) {
		this.mFromuser = mFromuser;
	}


	/**
	 * @return the mTouser
	 */
	public String getmTouser() {
		return mTouser;
	}


	/**
	 * @param mTouser the mTouser to set
	 */
	public void setmTouser(String mTouser) {
		this.mTouser = mTouser;
	}

	@Override
	public String toString() {
		return "Message [mId=" + mId + ", mContent=" + mContent + ", mTime=" + mTime + ", mFromuser=" + mFromuser
				+ ", mTouser=" + mTouser + "]";
	}



	
	
	
	
	

}
