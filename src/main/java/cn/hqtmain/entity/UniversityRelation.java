package cn.hqtmain.entity;


import java.io.Serializable;

import net.sf.json.JSONArray;

/**
 * @ClassName: Vocation
 * @Description: 大学招生信息实体类
 * @author: wuPeiLong
 * @date: 2019年12月03日
 * @Copyright:好前途教育
 * @version V1.0
 */
public class UniversityRelation implements Serializable {

	/**
	 * serialVersionUID
	 */
    private static final long serialVersionUID = 1L;

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
    private String urYear;
    
    /**
     * 省份
     */
    private String urProvince;

    /**
     * 选科类型
     */
    private String subjectType;

    /**
     * 录取批次
     */
    private String admissionBatch;
    
    /**
     * 院校分数线
     */
    private String collegeScoreLine;
    private JSONArray collegeScoreLineList;
    

    /**
     * 招生计划
     */
    private String enrollmentPlan;

    /**
     * 专业录取分数线
     */
    private String professionalAdmissionScore;

	public UniversityRelation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UniversityRelation(Integer id, String universitiesCode, String urYear, String urProvince, String subjectType,
			String admissionBatch, String collegeScoreLine, String enrollmentPlan, String professionalAdmissionScore) {
		super();
		this.id = id;
		this.universitiesCode = universitiesCode;
		this.urYear = urYear;
		this.urProvince = urProvince;
		this.subjectType = subjectType;
		this.admissionBatch = admissionBatch;
		this.collegeScoreLine = collegeScoreLine;
		this.enrollmentPlan = enrollmentPlan;
		this.professionalAdmissionScore = professionalAdmissionScore;
	}

	public Integer getId() {
		return id;
	}

	public UniversityRelation setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getUniversitiesCode() {
		return universitiesCode;
	}

	public UniversityRelation setUniversitiesCode(String universitiesCode) {
		this.universitiesCode = universitiesCode;
		return this;
	}

	public String getUrYear() {
		return urYear;
	}

	public UniversityRelation setUrYear(String urYear) {
		this.urYear = urYear;
		return this;
	}

	public String getUrProvince() {
		return urProvince;
	}

	public UniversityRelation setUrProvince(String urProvince) {
		this.urProvince = urProvince;
		return this;
	}

	public String getSubjectType() {
		return subjectType;
	}

	public UniversityRelation setSubjectType(String subjectType) {
		this.subjectType = subjectType;
		return this;
	}

	public String getAdmissionBatch() {
		return admissionBatch;
	}

	public UniversityRelation setAdmissionBatch(String admissionBatch) {
		this.admissionBatch = admissionBatch;
		return this;
	}

	public String getCollegeScoreLine() {
		return collegeScoreLine;
	}

	public UniversityRelation setCollegeScoreLine(String collegeScoreLine) {
		this.collegeScoreLine = collegeScoreLine;
		return this;
	}
	
	public JSONArray getCollegeScoreLineList() {
		return collegeScoreLineList;
	}

	public UniversityRelation setCollegeScoreLineList(JSONArray collegeScoreLineList) {
		this.collegeScoreLineList = collegeScoreLineList;
		return this;
	}

	public String getEnrollmentPlan() {
		return enrollmentPlan;
	}

	public UniversityRelation setEnrollmentPlan(String enrollmentPlan) {
		this.enrollmentPlan = enrollmentPlan;
		return this;
	}

	public String getProfessionalAdmissionScore() {
		return professionalAdmissionScore;
	}

	public UniversityRelation setProfessionalAdmissionScore(String professionalAdmissionScore) {
		this.professionalAdmissionScore = professionalAdmissionScore;
		return this;
	}
	
	

	@Override
	public String toString() {
		return "UniversityRelation [id=" + id + ", universitiesCode=" + universitiesCode + ", urYear=" + urYear
				+ ", urProvince=" + urProvince + ", subjectType=" + subjectType + ", admissionBatch=" + admissionBatch
				+ ", collegeScoreLine=" + collegeScoreLine + ", enrollmentPlan=" + enrollmentPlan
				+ ", professionalAdmissionScore=" + professionalAdmissionScore + "]";
	}

	
    

}
