package cn.hqtmain.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: UniversityAdmission
 * @Description: 院校招生信息表
 * @author: wuPeiLong
 * @date: 2019年12月21日
 * @Copyright:好前途教育
 * @version V1.0
 */
public class UniversityAdmission implements Serializable{
	
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2143525176468326337L;

	/**
	 * 主键ID
	 */
    private Integer id;

    /**
     * 大学编码
     */
    private String universitiesCode;

    /**
     * 年份
     */
    private String uaYear;
    
    /**
     * 招生简章
     */
    private String admissionsBrochure;

    /**
     * 招生章程
     */
    private String admissionsRegulations;
    

    /**
     * 简章浏览数
     */
    private String brochureBrowseCount;
    
    /**
     * 章程浏览数
     */
    private Integer regulationsBrowseCount;

    /**
     * 发布时间
     */
    private Date pubdate;

	public UniversityAdmission() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public UniversityAdmission(Integer id, String universitiesCode, String uaYear, String admissionsBrochure,
			String admissionsRegulations, String brochureBrowseCount, Integer regulationsBrowseCount, Date pubdate) {
		super();
		this.id = id;
		this.universitiesCode = universitiesCode;
		this.uaYear = uaYear;
		this.admissionsBrochure = admissionsBrochure;
		this.admissionsRegulations = admissionsRegulations;
		this.brochureBrowseCount = brochureBrowseCount;
		this.regulationsBrowseCount = regulationsBrowseCount;
		this.pubdate = pubdate;
	}



	public Integer getId() {
		return id;
	}

	public UniversityAdmission setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getUniversitiesCode() {
		return universitiesCode;
	}

	public UniversityAdmission setUniversitiesCode(String universitiesCode) {
		this.universitiesCode = universitiesCode;
		return this;
	}

	public String getUaYear() {
		return uaYear;
	}

	public UniversityAdmission setUaYear(String uaYear) {
		this.uaYear = uaYear;
		return this;
	}

	public String getAdmissionsBrochure() {
		return admissionsBrochure;
	}

	public UniversityAdmission setAdmissionsBrochure(String admissionsBrochure) {
		this.admissionsBrochure = admissionsBrochure;
		return this;
	}

	public String getAdmissionsRegulations() {
		return admissionsRegulations;
	}

	public UniversityAdmission setAdmissionsRegulations(String admissionsRegulations) {
		this.admissionsRegulations = admissionsRegulations;
		return this;
	}


	public String getBrochureBrowseCount() {
		return brochureBrowseCount;
	}



	public UniversityAdmission setBrochureBrowseCount(String brochureBrowseCount) {
		this.brochureBrowseCount = brochureBrowseCount;
		return this;
	}



	public Integer getRegulationsBrowseCount() {
		return regulationsBrowseCount;
	}



	public UniversityAdmission setRegulationsBrowseCount(Integer regulationsBrowseCount) {
		this.regulationsBrowseCount = regulationsBrowseCount;
		return this;
	}



	public Date getPubdate() {
		return pubdate;
	}

	public UniversityAdmission setPubdate(Date pubdate) {
		this.pubdate = pubdate;
		return this;
	}

	@Override
	public String toString() {
		return "UniversityAdmission [id=" + id + ", universitiesCode=" + universitiesCode + ", uaYear=" + uaYear
				+ ", admissionsBrochure=" + admissionsBrochure + ", admissionsRegulations=" + admissionsRegulations
				+ ", brochureBrowseCount=" + brochureBrowseCount + ", regulationsBrowseCount=" + regulationsBrowseCount
				+ ", pubdate=" + pubdate + "]";
	}
    
    
  
}