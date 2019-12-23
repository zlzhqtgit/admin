package cn.hqtmain.entity;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName: Personality
 * @Description: 认知测评结果数据信息表
 * @author: wuPeiLong
 * @date: 2019年11月26日
 * @Copyright:好前途教育
 * @version V1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor()
@AllArgsConstructor()
public class Personality implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Integer personalityId;

    /**
     * 测评编码
     */
    private String personalityCode;

    /**
     * 测评结果名称
     */
    private String personalityName;

    /**
     * 测试类型
     */
    private String testName;

    /**
     * 个性简介
     */
    private String personalityBrief;

    /**
     * 个性特质
     */
    private String personalityDetial;

    /**
     * 适合的专业名称
     */
    private String personalitySpecialty;

    /**
     * 适合的职业
     */
    private String personalityVocation;


}
