package org.dev.hrm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.dev.hrm.model.Sysmsg;
import org.dev.hrm.model.SysmsgExample;

/**
 * @ClassName SysmsgMapper.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月18日 15:49:00
 */
@Mapper
public interface SysmsgMapper {
    long countByExample(SysmsgExample example);

    int deleteByExample(SysmsgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sysmsg record);

    int insertSelective(Sysmsg record);

    List<Sysmsg> selectByExample(SysmsgExample example);

    Sysmsg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sysmsg record, @Param("example") SysmsgExample example);

    int updateByExample(@Param("record") Sysmsg record, @Param("example") SysmsgExample example);

    int updateByPrimaryKeySelective(Sysmsg record);

    int updateByPrimaryKey(Sysmsg record);
}