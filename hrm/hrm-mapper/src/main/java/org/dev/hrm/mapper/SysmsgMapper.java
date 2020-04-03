package org.dev.hrm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.dev.hrm.model.Hr;
import org.dev.hrm.model.Sysmsg;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName SysmsgMapper.java
 * @createTime 2020年04月01日 15:20:00
 */
@Mapper
public interface SysmsgMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(Sysmsg record);

  int insertSelective(Sysmsg record);

  Sysmsg selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Sysmsg record);

  int updateByPrimaryKey(Sysmsg record);

  int insertHrsMsg(@Param("hrList") List<Hr> hrList, @Param("id") Integer id);

  List<Sysmsg> getAllNotices(@Param("page") Integer page,
      @Param("size") Integer size, @Param("hrId") Integer hrId);

  long getTotal(@Param("hrId") Integer id);

  int deleteMyNotifications(@Param("mid") Integer mid, @Param("id") Integer id);

  int updateByPrimaryKeysSelective(@Param("ids") String[] ids,
      @Param("hrId") Integer hrid);

}