package org.webim.dao;

import org.webim.annotation.MyBatisAnnotation;
import org.webim.entity.UserGroup;

/**
 * @ClassName UserGroupDao
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-16 下午10:52:37
 * @version 1.0.0
 */
@MyBatisAnnotation
public interface UserGroupDao {
    
    /**
     * @Description 增加一个用户-群-群分组关系(用户加入指定群并将群分配到自己已有的某个群分组下)
     * @param userGroup
     */
    void addUserGroup(UserGroup userGroup);
}
