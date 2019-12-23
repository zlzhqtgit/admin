package cn.hqtmain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.hqtmain.entity.University;
import cn.hqtmain.entity.UniversityRelation;
/**
 * @ClassName: UniversityMapper
 * @Description: TODO
 * @Author: WuPeiLong
 * @Date: 2019年12月03日
 * @Copyright:好前途教育
 * @Version V1.0
 */
public interface UniversityMapper {
	
	Integer updateimg(University university);
    Integer insertUniversity(University university);
    Integer updateUniversity(University university);
    Integer deleteUniversity(University university);
    List<University> selectUniversityList(@Param("where")String where,
                                      @Param("orderBy")String orderBy,
                                      @Param("offset")Integer offset,
                                      @Param("countPerPage")Integer countPerPage);


    Integer insertUniversityRelation(UniversityRelation universityRelation);
    Integer updateUniversityRelation(UniversityRelation universityRelation);
    Integer deleteUniversityRelation(UniversityRelation universityRelation);
    List<UniversityRelation> selectUniversityRelationList(@Param("where")String where,
                                      @Param("orderBy")String orderBy,
                                      @Param("offset")Integer offset,
                                      @Param("countPerPage")Integer countPerPage);

    /**
     * 获得院校省份信息
     * @return
     *//*
   /* List<String> selectUniversityProvince();
    
    Integer insertUniversityAdmission(UniversityRelation university);
    Integer UniversityAdmission(UniversityRelation university);
    Integer deleteUniversityAdmission(UniversityRelation university);
    List<UniversityRelation> selectUniversityAdmissionList(@Param("where")String where,
                                      @Param("orderBy")String orderBy,
                                      @Param("offset")Integer offset,
                                      @Param("countPerPage")Integer countPerPage);*/
}
