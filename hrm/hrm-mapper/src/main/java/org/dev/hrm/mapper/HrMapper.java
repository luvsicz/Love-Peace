package org.dev.hrm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.dev.hrm.model.Hr;
import org.dev.hrm.model.Role;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName HrMapper.java
 * @createTime 2020年03月18日 15:49:00
 */
@Mapper
public interface HrMapper {


  int deleteByPrimaryKey(Integer id);

  int insert(Hr record);

  int insertSelective(Hr record);


  Hr selectByPrimaryKey(Integer id);


  int updateByPrimaryKeySelective(Hr record);

  int updateByPrimaryKey(Hr record);

  List<Role> getRoleById(Integer id);

  Hr getUserByUserName(String username);

  Integer updatePassById(@Param("id") Integer id, @Param("password") String encryptedPass);

  /**
   * 查询出除了当前HR以外的HR
   *
   * @param name 关键字
   * @return HR集合
   */
  List<Hr> selectByNameLikeKeyWords(@Param("hrid") Integer hrid, @Param("name") String name);

  /**
   * 删除指定HR的Role信息
   *
   * @param hrid hrid
   * @return 影响的行数
   */
  Integer deleteByHrId(@Param("hrid") Integer hrid);

  List<Hr> selectOtherHrs(@Param("hrid") Integer id);
}