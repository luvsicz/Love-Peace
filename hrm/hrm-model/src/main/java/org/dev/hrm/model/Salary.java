package org.dev.hrm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName Salary.java

 * @createTime 2020年03月29日 15:17:00
 */
@ApiModel(value = "org-dev-hrm-model-Salary")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salary implements Serializable {

  private static final long serialVersionUID = 1L;
  @ApiModelProperty(value = "")
  private Integer id;
  /**
   * 基本工资
   */
  @ApiModelProperty(value = "基本工资")
  private Integer basicSalary;
  /**
   * 奖金
   */
  @ApiModelProperty(value = "奖金")
  private Integer bonus;
  /**
   * 午餐补助
   */
  @ApiModelProperty(value = "午餐补助")
  private Integer lunchSalary;
  /**
   * 交通补助
   */
  @ApiModelProperty(value = "交通补助")
  private Integer trafficSalary;
  /**
   * 应发工资
   */
  @ApiModelProperty(value = "应发工资")
  private Integer allSalary;
  /**
   * 养老金基数
   */
  @ApiModelProperty(value = "养老金基数")
  private Integer pensionBase;
  /**
   * 养老金比率
   */
  @ApiModelProperty(value = "养老金比率")
  private Double pensionPer;
  /**
   * 启用时间
   */
  @ApiModelProperty(value = "启用时间")
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
  private Date createDate;
  /**
   * 医疗基数
   */
  @ApiModelProperty(value = "医疗基数")
  private Integer medicalBase;
  /**
   * 医疗保险比率
   */
  @ApiModelProperty(value = "医疗保险比率")
  private Double medicalPer;
  /**
   * 公积金基数
   */
  @ApiModelProperty(value = "公积金基数")
  private Integer accumulationFundBase;
  /**
   * 公积金比率
   */
  @ApiModelProperty(value = "公积金比率")
  private Double accumulationFundPer;
  @ApiModelProperty(value = "")
  private String name;
}