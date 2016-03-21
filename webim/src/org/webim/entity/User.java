package org.webim.entity;


/**
 * @ClassName User
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-13 下午3:11:30
 * @version 1.0.0
 */
public class User {
    /**
     * @Field userId : 用户ID
     */
    private String id;
    /**
     * @Field userName : 用户名称
     */
    private String name;
    /**
     * @Field userPassword : 用户密码
     */
    private String userPassword;
    /**
     * @Field face : 头像
     */
    private String face;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public String getUserPassword() {
        return userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    public String getFace() {
        return face;
    }
    
    public void setFace(String face) {
        this.face = face;
    }
}
