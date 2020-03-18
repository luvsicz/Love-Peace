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

    public Integer register(String username, String password) throws Exception;

    public Map<String, Object> checkName(String username) throws Exception;


}
