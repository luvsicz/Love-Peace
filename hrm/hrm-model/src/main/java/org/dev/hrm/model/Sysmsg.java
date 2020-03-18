package org.dev.hrm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Sysmsg.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@ApiModel(value="org-dev-hrm-model-Sysmsg")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sysmsg implements Serializable {
    @ApiModelProperty(value="")
    private Integer id;

    /**
    * 消息id
    */
    @ApiModelProperty(value="消息id")
    private Integer mid;

    /**
    * 0表示群发消息
    */
    @ApiModelProperty(value="0表示群发消息")
    private Integer type;

    /**
    * 这条消息是给谁的
    */
    @ApiModelProperty(value="这条消息是给谁的")
    private Integer hrid;

    /**
    * 0 未读 1 已读
    */
    @ApiModelProperty(value="0 未读 1 已读")
    private Integer state;

    private static final long serialVersionUID = 1L;
}