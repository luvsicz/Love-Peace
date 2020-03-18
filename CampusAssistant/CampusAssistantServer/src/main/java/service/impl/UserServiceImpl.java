package service.impl;

import service.UserService;
import tools.DBUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    @Override
    public Map<String, Object> checkNP(String username, String password) throws Exception {
        String sql = "select * from User where username=? and password=?";
        Map<String, Object> condiMap = new HashMap<String, Object>();
        condiMap.put("username", username);
        condiMap.put("password", password);
        List<Map<String, Object>> eList = DBUtils.query("User", condiMap);
        if (null != eList && eList.size() > 0) {
            return eList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer register(String username, String password) throws Exception {

        Map<String, Object> condiMap = new HashMap<String, Object>();
        condiMap.put("username", username);
        condiMap.put("password", password);
        int eList = DBUtils.insert("User", condiMap);
        if (eList == 1) {
            return eList;
        } else {
            return null;
        }

    }

    @Override
    public Map<String, Object> checkName(String username) throws Exception {
        String sql = "select * from User where username=?";
        Map<String, Object> condiMap = new HashMap<String, Object>();
        condiMap.put("username", username);
        List<Map<String, Object>> eList = DBUtils.query("User", condiMap);
        if (null != eList && eList.size() > 0) {
            return eList.get(0);
        } else {
            return null;
        }
    }


}


