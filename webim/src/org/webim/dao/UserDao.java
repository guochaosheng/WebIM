package org.webim.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.webim.annotation.MyBatisAnnotation;
import org.webim.entity.User;

/**
 * @ClassName UserDao
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-13 下午2:48:38
 * @version 1.0.0
 */
@MyBatisAnnotation
public interface UserDao {

    /**
     * @Description 通过用户名称查询用户信息
     * @param username 用户名
     * @return 查询的用户
     */
    User queryUserByName(String username);
    
    /**
     * @Description 增加用户
     */
    void createUser(User user);

    /**
     * @Description 通过用户ID和好友分组的ID查询用户拥有的好友分组的列表
     * @param id
     * @param friendsetId
     */
    List<User> queryFriendsForSet(
            @Param("userId")String userId,
            @Param("friendsetId")String friendsetId);
}
