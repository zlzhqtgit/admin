package cn.hqtmain.entity;


import java.io.Serializable;




/**
 * @ClassName: Specialty
 * @Description: 专业数据信息实体类
 * @author: wuPeiLong
 * @date: 2019年11月26日
 * @Copyright:好前途教育
 * @version V1.0
 */
public class Specialty implements Serializable{



    /**
	* @Fields serialVersionUID :(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = -3870981740841766756L;

	/**
     * 主键ID
     */
    private Integer id;

    /**
     * 专业ID
     */
    private String specialtyId;

    /**
     * 专业名称
     */
    private String specialtyName;

    /**
     * 专业介绍
     */
    private String specialtyIntro;

    /**
     * 专业大类名字
     */
    private String specialtyMajorName;

    /**
     * 专业分类类名
     */
    private String specialtyClassName;

    /**
     * 专业门类
     */
    private String specialtyDivided;

    /**
     * 专业学科分类
     */
    private String specialtyDisciplines;

    /**
     * 学历层次
     */
    private String specialtyEducation;

    /**
     * 修业年限
     */
    private String studyDuration;

    /**
     * 授予学位
     */
    private String bachelorDegree;

    /**
     * 男女比例
     */
    private String maleFemaleRatio;

    /**
     * 专业简介
     */
    private String specialtySummary;

    /**
     * 培养要求
     */
    private String trainRequirement;

    /**
     * 学科要求
     */
    private String subjectRequirement;

    /**
     * 知识能力
     */
    private String knowledgeAbility;

    /**
     * 考研方向
     */
    private String postgraduateDirection;

    /**
     * 就业职业方向
     */
    private String employmentCareerDirection;

    /**
     * 就业行业分布
     */
    private String employmentIndustryDistribution;

    /**
     * 就业地区分布
     */
    private String employmentAreaDistribution;

    /**
     * 主要课程
     */
    private String majorCourses;

    /**
     * 培养目标
     */
    private String specialtyObjective;

    /**
     * 就业前景
     */
    private String specialtyEmployment;

    /**
     * 报考要求
     */
    private String specialtyRequirement;

    /**
     * 物理要求
     */
    private Double physicsPerformance;

    /**
     * 化学要求
     */
    private Double chemistryPerformance;

    /**
     * 生物要求
     */
    private Double biologyPerformance;

    /**
     * 政治要求
     */
    private Double politicPerformance;

    /**
     * 历史要求
     */
    private Double historyPerformance;

    /**
     * 地理要求
     */
    private Double geographyPerformance;

    /**
     * 语文要求
     */
    private Double chinesePerformance;

    /**
     * 数学要求
     */
    private Double mathPerformance;

    /**
     * 外语要求
     */
    private Double foreignPerformance;

    /**
     * 第四轮学科评估A+高校
     */
    private String aboveA;

    /**
     * 第四轮学科评估A高校
     */
    private String equalA;

    /**
     * 第四轮学科评估A-高校
     */
    private String belowA;

    /**
     * 第四轮学科评估B+高校
     */
    private String aboveB;

    /**
     * 开设院校
     */
    private String openCollege;

	/**
	* 创建一个新的实例 Specialty.
	*
	*/
	public Specialty() {
		super();
	}

	/**
	* 创建一个新的实例 Specialty.
	*
	* @param id
	* @param specialtyId
	* @param specialtyName
	* @param specialtyIntro
	* @param specialtyMajorName
	* @param specialtyClassName
	* @param specialtyDivided
	* @param specialtyDisciplines
	* @param specialtyEducation
	* @param studyDuration
	* @param bachelorDegree
	* @param maleFemaleRatio
	* @param specialtySummary
	* @param trainRequirement
	* @param subjectRequirement
	* @param knowledgeAbility
	* @param postgraduateDirection
	* @param employmentCareerDirection
	* @param employmentIndustryDistribution
	* @param employmentAreaDistribution
	* @param majorCourses
	* @param specialtyObjective
	* @param specialtyEmployment
	* @param specialtyRequirement
	* @param physicsPerformance
	* @param chemistryPerformance
	* @param biologyPerformance
	* @param politicPerformance
	* @param historyPerformance
	* @param geographyPerformance
	* @param chinesePerformance
	* @param mathPerformance
	* @param foreignPerformance
	* @param aboveA
	* @param equalA
	* @param belowA
	* @param aboveB
	* @param openCollege
	*/
	public Specialty(Integer id, String specialtyId, String specialtyName, String specialtyIntro,
			String specialtyMajorName, String specialtyClassName, String specialtyDivided, String specialtyDisciplines,
			String specialtyEducation, String studyDuration, String bachelorDegree, String maleFemaleRatio,
			String specialtySummary, String trainRequirement, String subjectRequirement, String knowledgeAbility,
			String postgraduateDirection, String employmentCareerDirection, String employmentIndustryDistribution,
			String employmentAreaDistribution, String majorCourses, String specialtyObjective,
			String specialtyEmployment, String specialtyRequirement, Double physicsPerformance,
			Double chemistryPerformance, Double biologyPerformance, Double politicPerformance,
			Double historyPerformance, Double geographyPerformance, Double chinesePerformance, Double mathPerformance,
			Double foreignPerformance, String aboveA, String equalA, String belowA, String aboveB, String openCollege) {
		super();
		this.id = id;
		this.specialtyId = specialtyId;
		this.specialtyName = specialtyName;
		this.specialtyIntro = specialtyIntro;
		this.specialtyMajorName = specialtyMajorName;
		this.specialtyClassName = specialtyClassName;
		this.specialtyDivided = specialtyDivided;
		this.specialtyDisciplines = specialtyDisciplines;
		this.specialtyEducation = specialtyEducation;
		this.studyDuration = studyDuration;
		this.bachelorDegree = bachelorDegree;
		this.maleFemaleRatio = maleFemaleRatio;
		this.specialtySummary = specialtySummary;
		this.trainRequirement = trainRequirement;
		this.subjectRequirement = subjectRequirement;
		this.knowledgeAbility = knowledgeAbility;
		this.postgraduateDirection = postgraduateDirection;
		this.employmentCareerDirection = employmentCareerDirection;
		this.employmentIndustryDistribution = employmentIndustryDistribution;
		this.employmentAreaDistribution = employmentAreaDistribution;
		this.majorCourses = majorCourses;
		this.specialtyObjective = specialtyObjective;
		this.specialtyEmployment = specialtyEmployment;
		this.specialtyRequirement = specialtyRequirement;
		this.physicsPerformance = physicsPerformance;
		this.chemistryPerformance = chemistryPerformance;
		this.biologyPerformance = biologyPerformance;
		this.politicPerformance = politicPerformance;
		this.historyPerformance = historyPerformance;
		this.geographyPerformance = geographyPerformance;
		this.chinesePerformance = chinesePerformance;
		this.mathPerformance = mathPerformance;
		this.foreignPerformance = foreignPerformance;
		this.aboveA = aboveA;
		this.equalA = equalA;
		this.belowA = belowA;
		this.aboveB = aboveB;
		this.openCollege = openCollege;
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
	 * @return the specialtyId
	 */
	public String getSpecialtyId() {
		return specialtyId;
	}

	/**
	 * @param specialtyId the specialtyId to set
	 */
	public void setSpecialtyId(String specialtyId) {
		this.specialtyId = specialtyId;
	}

	/**
	 * @return the specialtyName
	 */
	public String getSpecialtyName() {
		return specialtyName;
	}

	/**
	 * @param specialtyName the specialtyName to set
	 */
	public void setSpecialtyName(String specialtyName) {
		this.specialtyName = specialtyName;
	}

	/**
	 * @return the specialtyIntro
	 */
	public String getSpecialtyIntro() {
		return specialtyIntro;
	}

	/**
	 * @param specialtyIntro the specialtyIntro to set
	 */
	public void setSpecialtyIntro(String specialtyIntro) {
		this.specialtyIntro = specialtyIntro;
	}

	/**
	 * @return the specialtyMajorName
	 */
	public String getSpecialtyMajorName() {
		return specialtyMajorName;
	}

	/**
	 * @param specialtyMajorName the specialtyMajorName to set
	 */
	public void setSpecialtyMajorName(String specialtyMajorName) {
		this.specialtyMajorName = specialtyMajorName;
	}

	/**
	 * @return the specialtyClassName
	 */
	public String getSpecialtyClassName() {
		return specialtyClassName;
	}

	/**
	 * @param specialtyClassName the specialtyClassName to set
	 */
	public void setSpecialtyClassName(String specialtyClassName) {
		this.specialtyClassName = specialtyClassName;
	}

	/**
	 * @return the specialtyDivided
	 */
	public String getSpecialtyDivided() {
		return specialtyDivided;
	}

	/**
	 * @param specialtyDivided the specialtyDivided to set
	 */
	public void setSpecialtyDivided(String specialtyDivided) {
		this.specialtyDivided = specialtyDivided;
	}

	/**
	 * @return the specialtyDisciplines
	 */
	public String getSpecialtyDisciplines() {
		return specialtyDisciplines;
	}

	/**
	 * @param specialtyDisciplines the specialtyDisciplines to set
	 */
	public void setSpecialtyDisciplines(String specialtyDisciplines) {
		this.specialtyDisciplines = specialtyDisciplines;
	}

	/**
	 * @return the specialtyEducation
	 */
	public String getSpecialtyEducation() {
		return specialtyEducation;
	}

	/**
	 * @param specialtyEducation the specialtyEducation to set
	 */
	public void setSpecialtyEducation(String specialtyEducation) {
		this.specialtyEducation = specialtyEducation;
	}

	/**
	 * @return the studyDuration
	 */
	public String getStudyDuration() {
		return studyDuration;
	}

	/**
	 * @param studyDuration the studyDuration to set
	 */
	public void setStudyDuration(String studyDuration) {
		this.studyDuration = studyDuration;
	}

	/**
	 * @return the bachelorDegree
	 */
	public String getBachelorDegree() {
		return bachelorDegree;
	}

	/**
	 * @param bachelorDegree the bachelorDegree to set
	 */
	public void setBachelorDegree(String bachelorDegree) {
		this.bachelorDegree = bachelorDegree;
	}

	/**
	 * @return the maleFemaleRatio
	 */
	public String getMaleFemaleRatio() {
		return maleFemaleRatio;
	}

	/**
	 * @param maleFemaleRatio the maleFemaleRatio to set
	 */
	public void setMaleFemaleRatio(String maleFemaleRatio) {
		this.maleFemaleRatio = maleFemaleRatio;
	}

	/**
	 * @return the specialtySummary
	 */
	public String getSpecialtySummary() {
		return specialtySummary;
	}

	/**
	 * @param specialtySummary the specialtySummary to set
	 */
	public void setSpecialtySummary(String specialtySummary) {
		this.specialtySummary = specialtySummary;
	}

	/**
	 * @return the trainRequirement
	 */
	public String getTrainRequirement() {
		return trainRequirement;
	}

	/**
	 * @param trainRequirement the trainRequirement to set
	 */
	public void setTrainRequirement(String trainRequirement) {
		this.trainRequirement = trainRequirement;
	}

	/**
	 * @return the subjectRequirement
	 */
	public String getSubjectRequirement() {
		return subjectRequirement;
	}

	/**
	 * @param subjectRequirement the subjectRequirement to set
	 */
	public void setSubjectRequirement(String subjectRequirement) {
		this.subjectRequirement = subjectRequirement;
	}

	/**
	 * @return the knowledgeAbility
	 */
	public String getKnowledgeAbility() {
		return knowledgeAbility;
	}

	/**
	 * @param knowledgeAbility the knowledgeAbility to set
	 */
	public void setKnowledgeAbility(String knowledgeAbility) {
		this.knowledgeAbility = knowledgeAbility;
	}

	/**
	 * @return the postgraduateDirection
	 */
	public String getPostgraduateDirection() {
		return postgraduateDirection;
	}

	/**
	 * @param postgraduateDirection the postgraduateDirection to set
	 */
	public void setPostgraduateDirection(String postgraduateDirection) {
		this.postgraduateDirection = postgraduateDirection;
	}

	/**
	 * @return the employmentCareerDirection
	 */
	public String getEmploymentCareerDirection() {
		return employmentCareerDirection;
	}

	/**
	 * @param employmentCareerDirection the employmentCareerDirection to set
	 */
	public void setEmploymentCareerDirection(String employmentCareerDirection) {
		this.employmentCareerDirection = employmentCareerDirection;
	}

	/**
	 * @return the employmentIndustryDistribution
	 */
	public String getEmploymentIndustryDistribution() {
		return employmentIndustryDistribution;
	}

	/**
	 * @param employmentIndustryDistribution the employmentIndustryDistribution to set
	 */
	public void setEmploymentIndustryDistribution(String employmentIndustryDistribution) {
		this.employmentIndustryDistribution = employmentIndustryDistribution;
	}

	/**
	 * @return the employmentAreaDistribution
	 */
	public String getEmploymentAreaDistribution() {
		return employmentAreaDistribution;
	}

	/**
	 * @param employmentAreaDistribution the employmentAreaDistribution to set
	 */
	public void setEmploymentAreaDistribution(String employmentAreaDistribution) {
		this.employmentAreaDistribution = employmentAreaDistribution;
	}

	/**
	 * @return the majorCourses
	 */
	public String getMajorCourses() {
		return majorCourses;
	}

	/**
	 * @param majorCourses the majorCourses to set
	 */
	public void setMajorCourses(String majorCourses) {
		this.majorCourses = majorCourses;
	}

	/**
	 * @return the specialtyObjective
	 */
	public String getSpecialtyObjective() {
		return specialtyObjective;
	}

	/**
	 * @param specialtyObjective the specialtyObjective to set
	 */
	public void setSpecialtyObjective(String specialtyObjective) {
		this.specialtyObjective = specialtyObjective;
	}

	/**
	 * @return the specialtyEmployment
	 */
	public String getSpecialtyEmployment() {
		return specialtyEmployment;
	}

	/**
	 * @param specialtyEmployment the specialtyEmployment to set
	 */
	public void setSpecialtyEmployment(String specialtyEmployment) {
		this.specialtyEmployment = specialtyEmployment;
	}

	/**
	 * @return the specialtyRequirement
	 */
	public String getSpecialtyRequirement() {
		return specialtyRequirement;
	}

	/**
	 * @param specialtyRequirement the specialtyRequirement to set
	 */
	public void setSpecialtyRequirement(String specialtyRequirement) {
		this.specialtyRequirement = specialtyRequirement;
	}

	/**
	 * @return the physicsPerformance
	 */
	public Double getPhysicsPerformance() {
		return physicsPerformance;
	}

	/**
	 * @param physicsPerformance the physicsPerformance to set
	 */
	public void setPhysicsPerformance(Double physicsPerformance) {
		this.physicsPerformance = physicsPerformance;
	}

	/**
	 * @return the chemistryPerformance
	 */
	public Double getChemistryPerformance() {
		return chemistryPerformance;
	}

	/**
	 * @param chemistryPerformance the chemistryPerformance to set
	 */
	public void setChemistryPerformance(Double chemistryPerformance) {
		this.chemistryPerformance = chemistryPerformance;
	}

	/**
	 * @return the biologyPerformance
	 */
	public Double getBiologyPerformance() {
		return biologyPerformance;
	}

	/**
	 * @param biologyPerformance the biologyPerformance to set
	 */
	public void setBiologyPerformance(Double biologyPerformance) {
		this.biologyPerformance = biologyPerformance;
	}

	/**
	 * @return the politicPerformance
	 */
	public Double getPoliticPerformance() {
		return politicPerformance;
	}

	/**
	 * @param politicPerformance the politicPerformance to set
	 */
	public void setPoliticPerformance(Double politicPerformance) {
		this.politicPerformance = politicPerformance;
	}

	/**
	 * @return the historyPerformance
	 */
	public Double getHistoryPerformance() {
		return historyPerformance;
	}

	/**
	 * @param historyPerformance the historyPerformance to set
	 */
	public void setHistoryPerformance(Double historyPerformance) {
		this.historyPerformance = historyPerformance;
	}

	/**
	 * @return the geographyPerformance
	 */
	public Double getGeographyPerformance() {
		return geographyPerformance;
	}

	/**
	 * @param geographyPerformance the geographyPerformance to set
	 */
	public void setGeographyPerformance(Double geographyPerformance) {
		this.geographyPerformance = geographyPerformance;
	}

	/**
	 * @return the chinesePerformance
	 */
	public Double getChinesePerformance() {
		return chinesePerformance;
	}

	/**
	 * @param chinesePerformance the chinesePerformance to set
	 */
	public void setChinesePerformance(Double chinesePerformance) {
		this.chinesePerformance = chinesePerformance;
	}

	/**
	 * @return the mathPerformance
	 */
	public Double getMathPerformance() {
		return mathPerformance;
	}

	/**
	 * @param mathPerformance the mathPerformance to set
	 */
	public void setMathPerformance(Double mathPerformance) {
		this.mathPerformance = mathPerformance;
	}

	/**
	 * @return the foreignPerformance
	 */
	public Double getForeignPerformance() {
		return foreignPerformance;
	}

	/**
	 * @param foreignPerformance the foreignPerformance to set
	 */
	public void setForeignPerformance(Double foreignPerformance) {
		this.foreignPerformance = foreignPerformance;
	}

	/**
	 * @return the aboveA
	 */
	public String getAboveA() {
		return aboveA;
	}

	/**
	 * @param aboveA the aboveA to set
	 */
	public void setAboveA(String aboveA) {
		this.aboveA = aboveA;
	}

	/**
	 * @return the equalA
	 */
	public String getEqualA() {
		return equalA;
	}

	/**
	 * @param equalA the equalA to set
	 */
	public void setEqualA(String equalA) {
		this.equalA = equalA;
	}

	/**
	 * @return the belowA
	 */
	public String getBelowA() {
		return belowA;
	}

	/**
	 * @param belowA the belowA to set
	 */
	public void setBelowA(String belowA) {
		this.belowA = belowA;
	}

	/**
	 * @return the aboveB
	 */
	public String getAboveB() {
		return aboveB;
	}

	/**
	 * @param aboveB the aboveB to set
	 */
	public void setAboveB(String aboveB) {
		this.aboveB = aboveB;
	}

	/**
	 * @return the openCollege
	 */
	public String getOpenCollege() {
		return openCollege;
	}

	/**
	 * @param openCollege the openCollege to set
	 */
	public void setOpenCollege(String openCollege) {
		this.openCollege = openCollege;
	}

	
	@Override
	public String toString() {
		return "Specialty [id=" + id + ", specialtyId=" + specialtyId + ", specialtyName=" + specialtyName
				+ ", specialtyIntro=" + specialtyIntro + ", specialtyMajorName=" + specialtyMajorName
				+ ", specialtyClassName=" + specialtyClassName + ", specialtyDivided=" + specialtyDivided
				+ ", specialtyDisciplines=" + specialtyDisciplines + ", specialtyEducation=" + specialtyEducation
				+ ", studyDuration=" + studyDuration + ", bachelorDegree=" + bachelorDegree + ", maleFemaleRatio="
				+ maleFemaleRatio + ", specialtySummary=" + specialtySummary + ", trainRequirement=" + trainRequirement
				+ ", subjectRequirement=" + subjectRequirement + ", knowledgeAbility=" + knowledgeAbility
				+ ", postgraduateDirection=" + postgraduateDirection + ", employmentCareerDirection="
				+ employmentCareerDirection + ", employmentIndustryDistribution=" + employmentIndustryDistribution
				+ ", employmentAreaDistribution=" + employmentAreaDistribution + ", majorCourses=" + majorCourses
				+ ", specialtyObjective=" + specialtyObjective + ", specialtyEmployment=" + specialtyEmployment
				+ ", specialtyRequirement=" + specialtyRequirement + ", physicsPerformance=" + physicsPerformance
				+ ", chemistryPerformance=" + chemistryPerformance + ", biologyPerformance=" + biologyPerformance
				+ ", politicPerformance=" + politicPerformance + ", historyPerformance=" + historyPerformance
				+ ", geographyPerformance=" + geographyPerformance + ", chinesePerformance=" + chinesePerformance
				+ ", mathPerformance=" + mathPerformance + ", foreignPerformance=" + foreignPerformance + ", aboveA="
				+ aboveA + ", equalA=" + equalA + ", belowA=" + belowA + ", aboveB=" + aboveB + ", openCollege="
				+ openCollege + "]";
	}


}
