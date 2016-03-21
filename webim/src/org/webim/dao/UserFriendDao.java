package org.webim.dao;

import org.webim.annotation.MyBatisAnnotation;
import org.webim.entity.UserFriend;

/**
 * @ClassName UserFriend
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-13 下午4:07:35
 * @version 1.0.0
 */
@MyBatisAnnotation
public interface UserFriendDao {

    /**
     * @Description 增加一个用户好友并分配到自己已有的某个好友分组中
     * @param userFriend
     * @return
     */
    int addUserFriend(UserFriend userFriend);
}
