package org.dev.hrm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName Employee.java
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@ApiModel(value = "org-dev-hrm-model-Employee")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

  /**
   * 员工编号
   */
  @ApiModelProperty(value = "员工编号")
  private Integer id;

  /**
   * 员工姓名
   */
  @ApiModelProperty(value = "员工姓名")
  private String name;

  /**
   * 性别
   */
  @ApiModelProperty(value = "性别")
  private String gender;

  /**
   * 出生日期
   */
  @ApiModelProperty(value = "出生日期")
  private LocalDate birthday;

  /**
   * 身份证号
   */
  @ApiModelProperty(value = "身份证号")
  private String idcard;

  /**
   * 婚姻状况
   */
  @ApiModelProperty(value = "婚姻状况")
  private Object wedlock;

  /**
   * 民族
   */
  @ApiModelProperty(value = "民族")
  private Integer nationid;

  /**
   * 籍贯
   */
  @ApiModelProperty(value = "籍贯")
  private String nativeplace;

  /**
   * 政治面貌
   */
  @ApiModelProperty(value = "政治面貌")
  private Integer politicid;

  /**
   * 邮箱
   */
  @ApiModelProperty(value = "邮箱")
  private String email;

  /**
   * 电话号码
   */
  @ApiModelProperty(value = "电话号码")
  private String phone;

  /**
   * 联系地址
   */
  @ApiModelProperty(value = "联系地址")
  private String address;

  /**
   * 所属部门
   */
  @ApiModelProperty(value = "所属部门")
  private Integer departmentid;

  /**
   * 职称ID
   */
  @ApiModelProperty(value = "职称ID")
  private Integer joblevelid;

  /**
   * 职位ID
   */
  @ApiModelProperty(value = "职位ID")
  private Integer posid;

  /**
   * 聘用形式
   */
  @ApiModelProperty(value = "聘用形式")
  private String engageform;

  /**
   * 最高学历
   */
  @ApiModelProperty(value = "最高学历")
  private Object tiptopdegree;

  /**
   * 所属专业
   */
  @ApiModelProperty(value = "所属专业")
  private String specialty;

  /**
   * 毕业院校
   */
  @ApiModelProperty(value = "毕业院校")
  private String school;

  /**
   * 入职日期
   */
  @ApiModelProperty(value = "入职日期")
  private LocalDate begindate;

  /**
   * 在职状态
   */
  @ApiModelProperty(value = "在职状态")
  private Object workstate;

  /**
   * 工号
   */
  @ApiModelProperty(value = "工号")
  private String workid;

  /**
   * 合同期限
   */
  @ApiModelProperty(value = "合同期限")
  private Double contractterm;

  /**
   * 转正日期
   */
  @ApiModelProperty(value = "转正日期")
  private LocalDate conversiontime;

  /**
   * 离职日期
   */
  @ApiModelProperty(value = "离职日期")
  private LocalDate notworkdate;

  /**
   * 合同起始日期
   */
  @ApiModelProperty(value = "合同起始日期")
  private LocalDate begincontract;

  /**
   * 合同终止日期
   */
  @ApiModelProperty(value = "合同终止日期")
  private LocalDate endcontract;

  /**
   * 工龄
   */
  @ApiModelProperty(value = "工龄")
  private Integer workage;

  private static final long serialVersionUID = 1L;

  public static EmployeeBuilder builder() {
    return new EmployeeBuilder();
  }
}