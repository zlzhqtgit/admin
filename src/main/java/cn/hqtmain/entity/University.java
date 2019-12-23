package cn.hqtmain.entity;


import java.util.Date;
import java.util.List;
import java.io.Serializable;

/**
 * @ClassName: Vocation
 * @Description: 大学信息实体类
 * @author: wuPeiLong
 * @date: 2019年12月03日
 * @Copyright:好前途教育
 * @version V1.0
 */
public class University implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 主鍵ID
     */
    private Integer id;

    /**
     * 大学编码
     */
    private String universitiesCode;

    /**
     * 大学名字
     */
    private String universitiesName;

    /**
     * 省份信息
     */
    private String province;

    /**
     * 城市信息
     */
    private String city;

    /**
     * 创建时间: 2019-10-01
     */
    private String establishedTime;

    /**
     * 办学性质：公办、民办、独立院校、中外合作办学
     */
    private String universitiesNature;

    /**
     * 隶属于
     */
    private String belongTo;

    /**
     * 学校地址
     */
    private String address;

    /**
     * 地图坐标
     */
    private String mapCoordinates;

    /**
     * 学校介绍
     */
    private String universitiesIntroduction;

    /**
     * 院校属性
     */
    private String universitiesAttributes;

    /**
     * 院校类型
     */
    private String universitiesType;
    
    /**
     * 院校logo
     */
    private String universitiesLogo;

    /**
     * 大学校图
     */
    private String universitiesImage;

    /**
     * 校园生活
     */
    private String universitiesLife;

    /**
     * 食宿条件
     */
    private String roomAndBoard;

    /**
     * 奖助学金
     */
    private String scholarships;

    /**
     * 教研教学
     */
    private String teachingResearch;

    /**
     * 男女比例
     */
    private String maleFemaleRatio;

    /**
     * 师资力量
     */
    private String teachersResources;

    /**
     * 重点专业
     */
    private String coreSpecialty;

    /**
     * 重点学科
     */
    private String coreSubject;

    /**
     * 重点实验室及科研中心
     */
    private String coreLaboratoriesAndResearchCenters;

    /**
     * 录取批次
     */
    private String admissionLot;

    /**
     * 录取概率
     */
    private String admissionProbability;

    /**
     * 学校官网
     */
    private String universitiesWebsite;

    /**
     * 学校电话
     */
    private String universitiesPhone;

    /**
     * 校友会排名
     */
    private String alumniAssociationRanking;

    /**
     * 武书连排名
     */
    private String martialBookAssociationRanking;

    /**
     * 软科中国两岸四地大学百强排名
     */
    private String softScienceRanking;

    /**
     * 世界大学排名:QS排名
     */
    private String quacquarelliSymondsRanking;

    /**
     * 美国大学排名:USNews
     */
    private String usNewsRanking;

    /**
     * 录取平均分排行
     */
    private String admissionAverageRanking;

    /**
     * 综合排名
     */
    private String totalRanking;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 学校拓展信息清单
     */
    List<UniversityRelation> universRelationList;

    /**
     * 学校招生章程/简章
     */
    List<UniversityAdmission> universityAdmissionList;
    
	public University() {
		super();
	}


	public University(Integer id, String universitiesCode, String universitiesName, String province, String city,
			String establishedTime, String universitiesNature, String belongTo, String address, String mapCoordinates,
			String universitiesIntroduction, String universitiesAttributes, String universitiesType,
			String universitiesLogo, String universitiesImage, String universitiesLife, String roomAndBoard,
			String scholarships, String teachingResearch, String maleFemaleRatio, String teachersResources,
			String coreSpecialty, String coreSubject, String coreLaboratoriesAndResearchCenters, String admissionLot,
			String admissionProbability, String universitiesWebsite, String universitiesPhone,
			String alumniAssociationRanking, String martialBookAssociationRanking, String softScienceRanking,
			String quacquarelliSymondsRanking, String usNewsRanking, String admissionAverageRanking,
			String totalRanking, Date createTime, String createBy, Date updateTime, String updateBy) {
		super();
		this.id = id;
		this.universitiesCode = universitiesCode;
		this.universitiesName = universitiesName;
		this.province = province;
		this.city = city;
		this.establishedTime = establishedTime;
		this.universitiesNature = universitiesNature;
		this.belongTo = belongTo;
		this.address = address;
		this.mapCoordinates = mapCoordinates;
		this.universitiesIntroduction = universitiesIntroduction;
		this.universitiesAttributes = universitiesAttributes;
		this.universitiesType = universitiesType;
		this.universitiesLogo = universitiesLogo;
		this.universitiesImage = universitiesImage;
		this.universitiesLife = universitiesLife;
		this.roomAndBoard = roomAndBoard;
		this.scholarships = scholarships;
		this.teachingResearch = teachingResearch;
		this.maleFemaleRatio = maleFemaleRatio;
		this.teachersResources = teachersResources;
		this.coreSpecialty = coreSpecialty;
		this.coreSubject = coreSubject;
		this.coreLaboratoriesAndResearchCenters = coreLaboratoriesAndResearchCenters;
		this.admissionLot = admissionLot;
		this.admissionProbability = admissionProbability;
		this.universitiesWebsite = universitiesWebsite;
		this.universitiesPhone = universitiesPhone;
		this.alumniAssociationRanking = alumniAssociationRanking;
		this.martialBookAssociationRanking = martialBookAssociationRanking;
		this.softScienceRanking = softScienceRanking;
		this.quacquarelliSymondsRanking = quacquarelliSymondsRanking;
		this.usNewsRanking = usNewsRanking;
		this.admissionAverageRanking = admissionAverageRanking;
		this.totalRanking = totalRanking;
		this.createTime = createTime;
		this.createBy = createBy;
		this.updateTime = updateTime;
		this.updateBy = updateBy;
	}


	
	public University(Integer id, String universitiesCode, String universitiesName, String province, String city,
			String establishedTime, String universitiesNature, String belongTo, String address, String mapCoordinates,
			String universitiesIntroduction, String universitiesAttributes, String universitiesType,
			String universitiesLogo, String universitiesImage, String universitiesLife, String roomAndBoard,
			String scholarships, String teachingResearch, String maleFemaleRatio, String teachersResources,
			String coreSpecialty, String coreSubject, String coreLaboratoriesAndResearchCenters, String admissionLot,
			String admissionProbability, String universitiesWebsite, String universitiesPhone,
			String alumniAssociationRanking, String martialBookAssociationRanking, String softScienceRanking,
			String quacquarelliSymondsRanking, String usNewsRanking, String admissionAverageRanking,
			String totalRanking, Date createTime, String createBy, Date updateTime, String updateBy,
			List<UniversityRelation> universRelationList, List<UniversityAdmission> universityAdmissionList) {
		super();
		this.id = id;
		this.universitiesCode = universitiesCode;
		this.universitiesName = universitiesName;
		this.province = province;
		this.city = city;
		this.establishedTime = establishedTime;
		this.universitiesNature = universitiesNature;
		this.belongTo = belongTo;
		this.address = address;
		this.mapCoordinates = mapCoordinates;
		this.universitiesIntroduction = universitiesIntroduction;
		this.universitiesAttributes = universitiesAttributes;
		this.universitiesType = universitiesType;
		this.universitiesLogo = universitiesLogo;
		this.universitiesImage = universitiesImage;
		this.universitiesLife = universitiesLife;
		this.roomAndBoard = roomAndBoard;
		this.scholarships = scholarships;
		this.teachingResearch = teachingResearch;
		this.maleFemaleRatio = maleFemaleRatio;
		this.teachersResources = teachersResources;
		this.coreSpecialty = coreSpecialty;
		this.coreSubject = coreSubject;
		this.coreLaboratoriesAndResearchCenters = coreLaboratoriesAndResearchCenters;
		this.admissionLot = admissionLot;
		this.admissionProbability = admissionProbability;
		this.universitiesWebsite = universitiesWebsite;
		this.universitiesPhone = universitiesPhone;
		this.alumniAssociationRanking = alumniAssociationRanking;
		this.martialBookAssociationRanking = martialBookAssociationRanking;
		this.softScienceRanking = softScienceRanking;
		this.quacquarelliSymondsRanking = quacquarelliSymondsRanking;
		this.usNewsRanking = usNewsRanking;
		this.admissionAverageRanking = admissionAverageRanking;
		this.totalRanking = totalRanking;
		this.createTime = createTime;
		this.createBy = createBy;
		this.updateTime = updateTime;
		this.updateBy = updateBy;
		this.universRelationList = universRelationList;
		this.universityAdmissionList = universityAdmissionList;
	}


	public Integer getId() {
		return id;
	}


	public University setId(Integer id) {
		this.id = id;
		return this;
	}


	public String getUniversitiesCode() {
		return universitiesCode;
	}


	public University setUniversitiesCode(String universitiesCode) {
		this.universitiesCode = universitiesCode;
		return this;
	}


	public String getUniversitiesName() {
		return universitiesName;
	}


	public University setUniversitiesName(String universitiesName) {
		this.universitiesName = universitiesName;
		return this;
	}


	public String getProvince() {
		return province;
	}


	public University setProvince(String province) {
		this.province = province;
		return this;
	}


	public String getCity() {
		return city;
	}


	public University setCity(String city) {
		this.city = city;
		return this;
	}


	public String getEstablishedTime() {
		return establishedTime;
	}


	public University setEstablishedTime(String establishedTime) {
		this.establishedTime = establishedTime;
		return this;
	}


	public String getUniversitiesNature() {
		return universitiesNature;
	}


	public University setUniversitiesNature(String universitiesNature) {
		this.universitiesNature = universitiesNature;
		return this;
	}


	public String getBelongTo() {
		return belongTo;
	}


	public University setBelongTo(String belongTo) {
		this.belongTo = belongTo;
		return this;
	}


	public String getAddress() {
		return address;
	}


	public University setAddress(String address) {
		this.address = address;
		return this;
	}


	public String getMapCoordinates() {
		return mapCoordinates;
	}


	public University setMapCoordinates(String mapCoordinates) {
		this.mapCoordinates = mapCoordinates;
		return this;
	}


	public String getUniversitiesIntroduction() {
		return universitiesIntroduction;
	}


	public University setUniversitiesIntroduction(String universitiesIntroduction) {
		this.universitiesIntroduction = universitiesIntroduction;
		return this;
	}


	public String getUniversitiesAttributes() {
		return universitiesAttributes;
	}


	public University setUniversitiesAttributes(String universitiesAttributes) {
		this.universitiesAttributes = universitiesAttributes;
		return this;
	}


	public String getUniversitiesType() {
		return universitiesType;
	}


	public University setUniversitiesType(String universitiesType) {
		this.universitiesType = universitiesType;
		return this;
	}

	
	

	public String getUniversitiesLogo() {
		return universitiesLogo;
	}


	public University setUniversitiesLogo(String universitiesLogo) {
		this.universitiesLogo = universitiesLogo;
		return this;
	}


	public String getUniversitiesImage() {
		return universitiesImage;
	}


	public University setUniversitiesImage(String universitiesImage) {
		this.universitiesImage = universitiesImage;
		return this;
	}


	public String getUniversitiesLife() {
		return universitiesLife;
	}


	public University setUniversitiesLife(String universitiesLife) {
		this.universitiesLife = universitiesLife;
		return this;
	}


	public String getRoomAndBoard() {
		return roomAndBoard;
	}


	public University setRoomAndBoard(String roomAndBoard) {
		this.roomAndBoard = roomAndBoard;
		return this;
	}


	public String getScholarships() {
		return scholarships;
	}


	public University setScholarships(String scholarships) {
		this.scholarships = scholarships;
		return this;
	}


	public String getTeachingResearch() {
		return teachingResearch;
	}


	public University setTeachingResearch(String teachingResearch) {
		this.teachingResearch = teachingResearch;
		return this;
	}


	public String getMaleFemaleRatio() {
		return maleFemaleRatio;
	}


	public University setMaleFemaleRatio(String maleFemaleRatio) {
		this.maleFemaleRatio = maleFemaleRatio;
		return this;
	}


	public String getTeachersResources() {
		return teachersResources;
	}


	public University setTeachersResources(String teachersResources) {
		this.teachersResources = teachersResources;
		return this;
	}


	public String getCoreSpecialty() {
		return coreSpecialty;
	}


	public University setCoreSpecialty(String coreSpecialty) {
		this.coreSpecialty = coreSpecialty;
		return this;
	}


	public String getCoreSubject() {
		return coreSubject;
	}


	public University setCoreSubject(String coreSubject) {
		this.coreSubject = coreSubject;
		return this;
	}


	public String getCoreLaboratoriesAndResearchCenters() {
		return coreLaboratoriesAndResearchCenters;
	}


	public University setCoreLaboratoriesAndResearchCenters(String coreLaboratoriesAndResearchCenters) {
		this.coreLaboratoriesAndResearchCenters = coreLaboratoriesAndResearchCenters;
		return this;
	}


	public String getAdmissionLot() {
		return admissionLot;
	}


	public University setAdmissionLot(String admissionLot) {
		this.admissionLot = admissionLot;
		return this;
	}


	public String getAdmissionProbability() {
		return admissionProbability;
	}


	public University setAdmissionProbability(String admissionProbability) {
		this.admissionProbability = admissionProbability;
		return this;
	}


	public String getUniversitiesWebsite() {
		return universitiesWebsite;
	}


	public University setUniversitiesWebsite(String universitiesWebsite) {
		this.universitiesWebsite = universitiesWebsite;
		return this;
	}


	public String getUniversitiesPhone() {
		return universitiesPhone;
	}


	public University setUniversitiesPhone(String universitiesPhone) {
		this.universitiesPhone = universitiesPhone;
		return this;
	}


	public String getAlumniAssociationRanking() {
		return alumniAssociationRanking;
	}


	public University setAlumniAssociationRanking(String alumniAssociationRanking) {
		this.alumniAssociationRanking = alumniAssociationRanking;
		return this;
	}


	public String getMartialBookAssociationRanking() {
		return martialBookAssociationRanking;
	}


	public University setMartialBookAssociationRanking(String martialBookAssociationRanking) {
		this.martialBookAssociationRanking = martialBookAssociationRanking;
		return this;
	}


	public String getSoftScienceRanking() {
		return softScienceRanking;
	}


	public University setSoftScienceRanking(String softScienceRanking) {
		this.softScienceRanking = softScienceRanking;
		return this;
	}


	public String getQuacquarelliSymondsRanking() {
		return quacquarelliSymondsRanking;
	}


	public University setQuacquarelliSymondsRanking(String quacquarelliSymondsRanking) {
		this.quacquarelliSymondsRanking = quacquarelliSymondsRanking;
		return this;
	}


	public String getUsNewsRanking() {
		return usNewsRanking;
	}


	public University setUsNewsRanking(String usNewsRanking) {
		this.usNewsRanking = usNewsRanking;
		return this;
	}


	public String getAdmissionAverageRanking() {
		return admissionAverageRanking;
	}


	public University setAdmissionAverageRanking(String admissionAverageRanking) {
		this.admissionAverageRanking = admissionAverageRanking;
		return this;
	}


	public String getTotalRanking() {
		return totalRanking;
	}


	public University setTotalRanking(String totalRanking) {
		this.totalRanking = totalRanking;
		return this;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public University setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}


	public String getCreateBy() {
		return createBy;
	}


	public University setCreateBy(String createBy) {
		this.createBy = createBy;
		return this;
	}


	public Date getUpdateTime() {
		return updateTime;
	}


	public University setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}


	public String getUpdateBy() {
		return updateBy;
	}


	public University setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
		return this;
	}


	public List<UniversityRelation> getUniversRelationList() {
		return universRelationList;
	}


	public University setUniversRelationList(List<UniversityRelation> universRelationList) {
		this.universRelationList = universRelationList;
		return this;
	}

	

	public List<UniversityAdmission> getUniversityAdmissionList() {
		return universityAdmissionList;
	}


	public University setUniversityAdmissionList(List<UniversityAdmission> universityAdmissionList) {
		this.universityAdmissionList = universityAdmissionList;
		return this;
	}


	@Override
	public String toString() {
		return "University [id=" + id + ", universitiesCode=" + universitiesCode + ", universitiesName="
				+ universitiesName + ", province=" + province + ", city=" + city + ", establishedTime="
				+ establishedTime + ", universitiesNature=" + universitiesNature + ", belongTo=" + belongTo
				+ ", address=" + address + ", mapCoordinates=" + mapCoordinates + ", universitiesIntroduction="
				+ universitiesIntroduction + ", universitiesAttributes=" + universitiesAttributes
				+ ", universitiesType=" + universitiesType + ", universitiesLogo=" + universitiesLogo
				+ ", universitiesImage=" + universitiesImage + ", universitiesLife=" + universitiesLife
				+ ", roomAndBoard=" + roomAndBoard + ", scholarships=" + scholarships + ", teachingResearch="
				+ teachingResearch + ", maleFemaleRatio=" + maleFemaleRatio + ", teachersResources=" + teachersResources
				+ ", coreSpecialty=" + coreSpecialty + ", coreSubject=" + coreSubject
				+ ", coreLaboratoriesAndResearchCenters=" + coreLaboratoriesAndResearchCenters + ", admissionLot="
				+ admissionLot + ", admissionProbability=" + admissionProbability + ", universitiesWebsite="
				+ universitiesWebsite + ", universitiesPhone=" + universitiesPhone + ", alumniAssociationRanking="
				+ alumniAssociationRanking + ", martialBookAssociationRanking=" + martialBookAssociationRanking
				+ ", softScienceRanking=" + softScienceRanking + ", quacquarelliSymondsRanking="
				+ quacquarelliSymondsRanking + ", usNewsRanking=" + usNewsRanking + ", admissionAverageRanking="
				+ admissionAverageRanking + ", totalRanking=" + totalRanking + ", createTime=" + createTime
				+ ", createBy=" + createBy + ", updateTime=" + updateTime + ", updateBy=" + updateBy
				+ ", universRelationList=" + universRelationList + ", universityAdmissionList="
				+ universityAdmissionList + "]";
	}




	
    
}
