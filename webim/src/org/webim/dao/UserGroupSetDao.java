package org.webim.dao;

import java.util.List;

import org.webim.annotation.MyBatisAnnotation;
import org.webim.entity.GroupSet;
import org.webim.entity.UserGroup;

/**
 * @ClassName UserGroupSetDao
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-17 上午11:34:05
 * @version 1.0.0
 */
@MyBatisAnnotation
public interface UserGroupSetDao {

    /**
     * @Description TODO(这里用一句话描述这个方法的作用)
     * @param userId
     * @return
     */
    List<GroupSet> queryUserGroupSet(String userId);
}
