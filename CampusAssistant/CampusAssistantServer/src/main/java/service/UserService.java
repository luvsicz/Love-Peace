package service;

import java.util.Map;

public interface UserService {
    /**
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public Map<String, Object> checkNP(String username, String password) throws Exception; //查找用户名和密码

    public void regist(Map<String, Object> valueMap);
}
