package org.webim.entity;


/**
 * @ClassName UserFriends
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-13 下午3:45:50
 * @version 1.0.0
 */
public class UserFriend {
    /**
     * @Field userId : 用户ID
     */
    private String userId;
    /**
     * @Field friendId : 好友ID
     */
    private String friendId;
    /**
     * @Field friendSetId : 好友所在的分组的ID
     */
    private String friendSetId;
    /**
     * @Field UserFriendId : 用户-好友-好友分组表每条记录自身的唯一标识
     */
    private String UserFriendId;
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getFriendId() {
        return friendId;
    }
    
    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }
    
    public String getFriendSetId() {
        return friendSetId;
    }
    
    public void setFriendSetId(String friendSetId) {
        this.friendSetId = friendSetId;
    }
    
    public String getUserFriendId() {
        return UserFriendId;
    }
    
    public void setUserFriendId(String userFriendId) {
        UserFriendId = userFriendId;
    }
}
