package org.webim.dao.test;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.webim.dao.UserFriendDao;
import org.webim.dao.UserGroupDao;
import org.webim.entity.FriendSet;
import org.webim.entity.UserFriend;
import org.webim.entity.Group;
import org.webim.entity.UserGroup;
import org.webim.util.UUIDUtil;

/**
 * @ClassName UserGroupDaoTest
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-13 下午4:10:01
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml" })
@ActiveProfiles("test")
public class UserGroupDaoTest {
    @Resource
    private UserGroupDao userGroupDao;

    @Test
    public void addUserGroupTest() {
        UserGroup userGroup = new UserGroup();
        userGroup.setGroupId("b787b8305a5d4163a72e96d217d610cb");
        userGroup.setGroupSetId("16d49f60fe704ad9be821cebfc8bc4da");
        userGroup.setUserGroupId(UUIDUtil.getUUID());
        userGroup.setUserId("e0c4e68264284a0988f6746bbf9b0d28");
        userGroupDao.addUserGroup(userGroup);
    }
}
