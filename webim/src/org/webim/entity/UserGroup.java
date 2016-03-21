package org.webim.entity;


/**
 * @ClassName UserGroup
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-13 下午3:59:13
 * @version 1.0.0
 */
public class UserGroup {
    /**
     * @Field userId : 用户ID
     */
    private String userId;
    /**
     * @Field groupId : 群ID
     */
    private String groupId;
    /**
     * @Field groupSetId : 群组的ID
     */
    private String groupSetId;
    /**
     * @Field userGroupId : 用户-群-群组表每条记录的唯一标识
     */
    private String userGroupId;
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getGroupId() {
        return groupId;
    }
    
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    
    public String getGroupSetId() {
        return groupSetId;
    }
    
    public void setGroupSetId(String groupSetId) {
        this.groupSetId = groupSetId;
    }
    
    public String getUserGroupId() {
        return userGroupId;
    }
    
    public void setUserGroupId(String userGroupId) {
        this.userGroupId = userGroupId;
    }
}
