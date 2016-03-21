package org.webim.dao;

import java.util.List;
import java.util.Map;

import org.webim.annotation.MyBatisAnnotation;
import org.webim.entity.FriendSet;

/**
 * @ClassName UserFriendSetDao
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-13 下午9:14:14
 * @version 1.0.0
 */
@MyBatisAnnotation
public interface UserFriendSetDao {

    /**
     * @Description 查询用户加友分组
     * @param userId
     * @return 分组对象
     */
    List<FriendSet> queryUserFriendSet(String userId);
}
