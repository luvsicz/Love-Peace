package org.dev.hrm.model;


import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Employeeec.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @createTime 2020年04月02日 19:59:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employeeec implements Serializable {

    private Integer id;

    /**
    * 员工编号
    */

    private Integer eid;

    /**
    * 奖罚日期
    */

    private Date ecDate;

    /**
    * 奖罚原因
    */

    private String ecReason;

    /**
    * 奖罚分
    */

    private Integer ecPoint;

    /**
    * 奖罚类别，0：奖，1：罚
    */

    private Integer ecType;

    /**
    * 备注
    */

    private String remark;

    private static final long serialVersionUID = 1L;
}