package org.webim.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.webim.annotation.MyBatisAnnotation;
import org.webim.entity.Group;
import org.webim.entity.GroupSet;
import org.webim.entity.User;

/**
 * @ClassName GroupDao
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-16 下午10:12:51
 * @version 1.0.0
 */
@MyBatisAnnotation
public interface GroupDao {

    /**
     * @Description 增加群
     */
    void createGroup(Group group);

    /**
     * @Description 通过用户ID和群组ID查询用户拥有的群分组的列表
     * @param userId
     * @param groupSetId
     * @return
     */
    List<Group> queryGroupsForSet(
            @Param("userId")String userId,
            @Param("groupSetId")String groupSetId);

    /**
     * @Description 通过群ID查询群的成员列表
     * @param groupId
     * @return
     */
    List<User> queryUsersByGroupId(String groupId);
}
