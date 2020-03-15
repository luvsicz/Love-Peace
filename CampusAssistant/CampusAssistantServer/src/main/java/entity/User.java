package entity;

import java.io.Serializable;

/**
 * @author Bamboo
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1484762078747742115L;
    /**
     * 登录账户名
     */
    private String username;
    /**
     * 登录密码
     */
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
