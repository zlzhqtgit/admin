package cn.hqtmain.entity;


import java.io.Serializable;


/**
 * @ClassName: Vocation
 * @Description: 职业数据信息实体类
 * @author: wuPeiLong
 * @date: 2019年11月26日
 * @Copyright:好前途教育
 * @version V1.0
 */
public class Vocation implements Serializable {





    /**
	* @Fields serialVersionUID :(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = -439186021378806785L;

	/**
     * 主键ID
     */
    private Integer vId;

    /**
     * 职业ID
     */
    private String vocationId;

    /**
     * 名称
     */
    private String vocationName;

    /**
     * 行业名称
     */
    private String industryName;

    /**
     * 行业大类
     */
    private String industryMajorName;

    /**
     * 职业介绍
     */
    private String vocationBrief;

    /**
     * 职业前景
     */
    private String prospect;

    /**
     * 工作经验
     */
    private String workExperience;

    /**
     * 工作内容
     */
    private String workContent;

    /**
     * 教育要求
     */
    private String educationCredential;

    /**
     * 关联专业
     */
    private String relationSpecialty;

    /**
     * 薪资趋势
     */
    private String salaryTrend;

    /**
     * 薪资分布
     */
    private String salaryDistribution;

    /**
     * 就业趋势(按学历)
     */
    private String employmentSituationEducation;

    /**
     * 就业趋势(按经验)
     */
    private String employmentSituationExperience;

    /**
     * 从业资格要求
     */
    private String requirementQualification;

    /**
     * 学历要求
     */
    private String educationQualification;

    /**
     * 专业知识
     */
    private String specialtyKnow;

    /**
     * 专业技能
     */
    private String specialtySkill;

    /**
     * 工作年限
     */
    private String workYear;

    /**
     * 工作成果
     */
    private String workAchieved;

    /**
     * 组织能力
     */
    private String organizationAbility;

    /**
     * 统筹能力
     */
    private String planAbility;

	/**
	* 创建一个新的实例 Vocation.
	*
	*/
	public Vocation() {
		super();
	}

	/**
	* 创建一个新的实例 Vocation.
	*
	* @param vId
	* @param vocationId
	* @param vocationName
	* @param industryName
	* @param industryMajorName
	* @param vocationBrief
	* @param prospect
	* @param workExperience
	* @param workContent
	* @param educationCredential
	* @param relationSpecialty
	* @param salaryTrend
	* @param salaryDistribution
	* @param employmentSituationEducation
	* @param employmentSituationExperience
	* @param requirementQualification
	* @param educationQualification
	* @param specialtyKnow
	* @param specialtySkill
	* @param workYear
	* @param workAchieved
	* @param organizationAbility
	* @param planAbility
	*/
	public Vocation(Integer vId, String vocationId, String vocationName, String industryName, String industryMajorName,
			String vocationBrief, String prospect, String workExperience, String workContent,
			String educationCredential, String relationSpecialty, String salaryTrend, String salaryDistribution,
			String employmentSituationEducation, String employmentSituationExperience, String requirementQualification,
			String educationQualification, String specialtyKnow, String specialtySkill, String workYear,
			String workAchieved, String organizationAbility, String planAbility) {
		super();
		this.vId = vId;
		this.vocationId = vocationId;
		this.vocationName = vocationName;
		this.industryName = industryName;
		this.industryMajorName = industryMajorName;
		this.vocationBrief = vocationBrief;
		this.prospect = prospect;
		this.workExperience = workExperience;
		this.workContent = workContent;
		this.educationCredential = educationCredential;
		this.relationSpecialty = relationSpecialty;
		this.salaryTrend = salaryTrend;
		this.salaryDistribution = salaryDistribution;
		this.employmentSituationEducation = employmentSituationEducation;
		this.employmentSituationExperience = employmentSituationExperience;
		this.requirementQualification = requirementQualification;
		this.educationQualification = educationQualification;
		this.specialtyKnow = specialtyKnow;
		this.specialtySkill = specialtySkill;
		this.workYear = workYear;
		this.workAchieved = workAchieved;
		this.organizationAbility = organizationAbility;
		this.planAbility = planAbility;
	}

	/**
	 * @return the vId
	 */
	public Integer getvId() {
		return vId;
	}

	/**
	 * @param vId the vId to set
	 */
	public void setvId(Integer vId) {
		this.vId = vId;
	}

	/**
	 * @return the vocationId
	 */
	public String getVocationId() {
		return vocationId;
	}

	/**
	 * @param vocationId the vocationId to set
	 */
	public void setVocationId(String vocationId) {
		this.vocationId = vocationId;
	}

	/**
	 * @return the vocationName
	 */
	public String getVocationName() {
		return vocationName;
	}

	/**
	 * @param vocationName the vocationName to set
	 */
	public void setVocationName(String vocationName) {
		this.vocationName = vocationName;
	}

	/**
	 * @return the industryName
	 */
	public String getIndustryName() {
		return industryName;
	}

	/**
	 * @param industryName the industryName to set
	 */
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	/**
	 * @return the industryMajorName
	 */
	public String getIndustryMajorName() {
		return industryMajorName;
	}

	/**
	 * @param industryMajorName the industryMajorName to set
	 */
	public void setIndustryMajorName(String industryMajorName) {
		this.industryMajorName = industryMajorName;
	}

	/**
	 * @return the vocationBrief
	 */
	public String getVocationBrief() {
		return vocationBrief;
	}

	/**
	 * @param vocationBrief the vocationBrief to set
	 */
	public void setVocationBrief(String vocationBrief) {
		this.vocationBrief = vocationBrief;
	}

	/**
	 * @return the prospect
	 */
	public String getProspect() {
		return prospect;
	}

	/**
	 * @param prospect the prospect to set
	 */
	public void setProspect(String prospect) {
		this.prospect = prospect;
	}

	/**
	 * @return the workExperience
	 */
	public String getWorkExperience() {
		return workExperience;
	}

	/**
	 * @param workExperience the workExperience to set
	 */
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}

	/**
	 * @return the workContent
	 */
	public String getWorkContent() {
		return workContent;
	}

	/**
	 * @param workContent the workContent to set
	 */
	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	/**
	 * @return the educationCredential
	 */
	public String getEducationCredential() {
		return educationCredential;
	}

	/**
	 * @param educationCredential the educationCredential to set
	 */
	public void setEducationCredential(String educationCredential) {
		this.educationCredential = educationCredential;
	}

	/**
	 * @return the relationSpecialty
	 */
	public String getRelationSpecialty() {
		return relationSpecialty;
	}

	/**
	 * @param relationSpecialty the relationSpecialty to set
	 */
	public void setRelationSpecialty(String relationSpecialty) {
		this.relationSpecialty = relationSpecialty;
	}

	/**
	 * @return the salaryTrend
	 */
	public String getSalaryTrend() {
		return salaryTrend;
	}

	/**
	 * @param salaryTrend the salaryTrend to set
	 */
	public void setSalaryTrend(String salaryTrend) {
		this.salaryTrend = salaryTrend;
	}

	/**
	 * @return the salaryDistribution
	 */
	public String getSalaryDistribution() {
		return salaryDistribution;
	}

	/**
	 * @param salaryDistribution the salaryDistribution to set
	 */
	public void setSalaryDistribution(String salaryDistribution) {
		this.salaryDistribution = salaryDistribution;
	}

	/**
	 * @return the employmentSituationEducation
	 */
	public String getEmploymentSituationEducation() {
		return employmentSituationEducation;
	}

	/**
	 * @param employmentSituationEducation the employmentSituationEducation to set
	 */
	public void setEmploymentSituationEducation(String employmentSituationEducation) {
		this.employmentSituationEducation = employmentSituationEducation;
	}

	/**
	 * @return the employmentSituationExperience
	 */
	public String getEmploymentSituationExperience() {
		return employmentSituationExperience;
	}

	/**
	 * @param employmentSituationExperience the employmentSituationExperience to set
	 */
	public void setEmploymentSituationExperience(String employmentSituationExperience) {
		this.employmentSituationExperience = employmentSituationExperience;
	}

	/**
	 * @return the requirementQualification
	 */
	public String getRequirementQualification() {
		return requirementQualification;
	}

	/**
	 * @param requirementQualification the requirementQualification to set
	 */
	public void setRequirementQualification(String requirementQualification) {
		this.requirementQualification = requirementQualification;
	}

	/**
	 * @return the educationQualification
	 */
	public String getEducationQualification() {
		return educationQualification;
	}

	/**
	 * @param educationQualification the educationQualification to set
	 */
	public void setEducationQualification(String educationQualification) {
		this.educationQualification = educationQualification;
	}

	/**
	 * @return the specialtyKnow
	 */
	public String getSpecialtyKnow() {
		return specialtyKnow;
	}

	/**
	 * @param specialtyKnow the specialtyKnow to set
	 */
	public void setSpecialtyKnow(String specialtyKnow) {
		this.specialtyKnow = specialtyKnow;
	}

	/**
	 * @return the specialtySkill
	 */
	public String getSpecialtySkill() {
		return specialtySkill;
	}

	/**
	 * @param specialtySkill the specialtySkill to set
	 */
	public void setSpecialtySkill(String specialtySkill) {
		this.specialtySkill = specialtySkill;
	}

	/**
	 * @return the workYear
	 */
	public String getWorkYear() {
		return workYear;
	}

	/**
	 * @param workYear the workYear to set
	 */
	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}

	/**
	 * @return the workAchieved
	 */
	public String getWorkAchieved() {
		return workAchieved;
	}

	/**
	 * @param workAchieved the workAchieved to set
	 */
	public void setWorkAchieved(String workAchieved) {
		this.workAchieved = workAchieved;
	}

	/**
	 * @return the organizationAbility
	 */
	public String getOrganizationAbility() {
		return organizationAbility;
	}

	/**
	 * @param organizationAbility the organizationAbility to set
	 */
	public void setOrganizationAbility(String organizationAbility) {
		this.organizationAbility = organizationAbility;
	}

	/**
	 * @return the planAbility
	 */
	public String getPlanAbility() {
		return planAbility;
	}

	/**
	 * @param planAbility the planAbility to set
	 */
	public void setPlanAbility(String planAbility) {
		this.planAbility = planAbility;
	}
	
	@Override
	public String toString() {
		return "Vocation [vId=" + vId + ", vocationId=" + vocationId + ", vocationName=" + vocationName
				+ ", industryName=" + industryName + ", industryMajorName=" + industryMajorName + ", vocationBrief="
				+ vocationBrief + ", prospect=" + prospect + ", workExperience=" + workExperience + ", workContent="
				+ workContent + ", educationCredential=" + educationCredential + ", relationSpecialty="
				+ relationSpecialty + ", salaryTrend=" + salaryTrend + ", salaryDistribution=" + salaryDistribution
				+ ", employmentSituationEducation=" + employmentSituationEducation + ", employmentSituationExperience="
				+ employmentSituationExperience + ", requirementQualification=" + requirementQualification
				+ ", educationQualification=" + educationQualification + ", specialtyKnow=" + specialtyKnow
				+ ", specialtySkill=" + specialtySkill + ", workYear=" + workYear + ", workAchieved=" + workAchieved
				+ ", organizationAbility=" + organizationAbility + ", planAbility=" + planAbility + "]";
	}



}
