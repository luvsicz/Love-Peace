package service.impl;

import service.UserService;
import tools.DBUtils;

import java.sql.SQLException;
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
    public void regist(Map<String, Object> valueMap) {
        //   String regSql="insert into user values('"+ username+ "','"+ password+ "') ";
        try {
            DBUtils.insert("User", valueMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
