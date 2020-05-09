package cn.sihai.domain;

public class User {
    private Integer id;

    private String username;

    public User() {
    }

    public User(Integer id, String username, String loginacct, String userpswd, String email, String createtime) {
        this.id = id;
        this.username = username;
        this.loginacct = loginacct;
        this.userpswd = userpswd;
        this.email = email;
        this.createtime = createtime;
    }

    private String loginacct;

    private String userpswd;

    private String email;

    private String createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getLoginacct() {
        return loginacct;
    }

    public void setLoginacct(String loginacct) {
        this.loginacct = loginacct == null ? null : loginacct.trim();
    }

    public String getUserpswd() {
        return userpswd;
    }

    public void setUserpswd(String userpswd) {
        this.userpswd = userpswd == null ? null : userpswd.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}