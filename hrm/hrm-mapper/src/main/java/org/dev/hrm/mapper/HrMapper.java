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
 * @Description TODO
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

}