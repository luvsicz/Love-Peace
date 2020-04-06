package org.dev.hrm.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.dev.hrm.mapper.HrMapper;
import org.dev.hrm.mapper.HrRoleMapper;
import org.dev.hrm.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName HrService.java
 * @Description HrService
 * @createTime 2019年12月29日 22:03:00
 */
@Service
@AllArgsConstructor
public class HrService implements UserDetailsService {

  private HrMapper hrMapper;
  private HrRoleMapper hrRoleMapper;


  public int deleteByPrimaryKey(Integer id) {
    return hrMapper.deleteByPrimaryKey(id);
  }


  public int insert(Hr record) {
    return hrMapper.insert(record);
  }


  public int insertSelective(Hr record) {
    return hrMapper.insertSelective(record);
  }


  public Hr selectByPrimaryKey(Integer id) {
    return hrMapper.selectByPrimaryKey(id);
  }

  /**
   * 选择性更新
   *
   * @param record
   * @return
   */
  public int updateByPrimaryKeySelective(Hr record) {
    return hrMapper.updateByPrimaryKeySelective(record);
  }

  /**
   * 强制更新
   *
   * @param record
   * @return
   */
  public int updateByPrimaryKey(Hr record) {
    return hrMapper.updateByPrimaryKey(record);
  }

  public boolean updateHrPassById(String oldPass, String newPass,
      Integer hrId) {
    Hr hr = hrMapper.selectByPrimaryKey(hrId);
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    if (encoder.matches(oldPass, hr.getPassword())) {
      String encryptedPass = encoder.encode(newPass);
      Integer result = hrMapper.updatePassById(hrId, encryptedPass);
      return result == 1;
    }
    return false;
  }

  @Override
  public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
    Hr hr = hrMapper.getUserByUserName(username);
    if (null == hr) {
      throw new UsernameNotFoundException("用户名不存在!");
    }
    hr.setRoles(hrMapper.getRoleById(hr.getId()));
    return hr;
  }

  public List<Hr> selectByNameLikeKeyWords(String name) {
    Hr currentHr = ((Hr) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal());

    return hrMapper.selectByNameLikeKeyWords(currentHr.getId(), name);
  }

  public List<Hr> selectOtherHrs() {
    Hr currentHr = ((Hr) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal());
    return hrMapper.selectOtherHrs(currentHr.getId());
  }

  @Transactional(rollbackFor = Exception.class)
  public boolean updateHrRole(Integer hrid, Integer[] rids) {
    //先清空hr的所有角色，再重新添加进去
    hrMapper.deleteByHrId(hrid);
    return hrRoleMapper.insertHrWithRoles(hrid, rids) == rids.length;
  }
}

