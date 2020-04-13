package org.dev.hrm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName Employee.java
 * @createTime 2020年03月18日 15:49:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Employee implements Serializable {

  private static final long serialVersionUID = 1L;
  /**
   * 员工编号
   */

  private Integer id;
  /**
   * 员工姓名
   */

  private String name;
  /**
   * 性别
   */

  private String gender;
  /**
   * 出生日期
   */

  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
  private Date birthday;
  /**
   * 身份证号
   */

  private String idCard;
  /**
   * 婚姻状况
   */

  private String wedlock;
  /**
   * 民族
   */

  private Integer nationId;
  /**
   * 籍贯
   */

  private String nativePlace;
  /**
   * 政治面貌
   */

  private Integer politicId;
  /**
   * 邮箱
   */

  private String email;
  /**
   * 电话号码
   */

  private String phone;
  /**
   * 联系地址
   */

  private String address;
  /**
   * 所属部门
   */

  private Integer departmentId;
  /**
   * 职称ID
   */

  private Integer jobLevelId;
  /**
   * 职位ID
   */

  private Integer posId;
  /**
   * 聘用形式
   */

  private String engageForm;
  /**
   * 最高学历
   */

  private String tiptopDegree;
  /**
   * 所属专业
   */

  private String specialty;
  /**
   * 毕业院校
   */

  private String school;
  /**
   * 入职日期
   */

  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
  private Date beginDate;
  /**
   * 在职状态
   */

  private String workState;
  /**
   * 工号
   */

  private String workID;
  /**
   * 合同期限
   */

  private Double contractTerm;
  /**
   * 转正日期
   */

  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
  private Date conversionTime;
  /**
   * 离职日期
   */

  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
  private Date notworkDate;
  /**
   * 合同起始日期
   */

  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
  private Date beginContract;
  /**
   * 合同终止日期
   */

  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
  private Date endContract;
  /**
   * 工龄
   */

  private Integer workAge;
  private Nation nation;
  private PoliticsStatus politicsstatus;
  private Department department;
  private AdjustSalary adjustSalary;
  private JobLevel jobLevel;
  private Position position;
  private Salary salary;
  private Integer salaryWithBonus;

  public Employee(String name) {
    this.name = name;
  }

  public Integer getSalaryWithBonus() {
    if (null != this.salary && null != this.salary.getAllSalary()) {
      if (null != this.adjustSalary && null != this.adjustSalary.getAmount()) {
        return this.salary.getAllSalary() + this.adjustSalary.getAmount();
      }
      return this.salary.getAllSalary();
    }
    return 0;
  }
}