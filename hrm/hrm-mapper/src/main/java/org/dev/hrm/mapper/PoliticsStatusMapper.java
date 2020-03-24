package org.dev.hrm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.dev.hrm.model.PoliticsStatus;

/**
 * @ClassName PoliticsStatusMapper.java
 * @author 冷嘉贤
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月24日 15:50:00
 */
@Mapper
public interface PoliticsStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PoliticsStatus record);

    int insertSelective(PoliticsStatus record);

    PoliticsStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PoliticsStatus record);

    int updateByPrimaryKey(PoliticsStatus record);

    List<PoliticsStatus> getAllPoliticsStatus();
}