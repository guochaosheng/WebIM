package org.webim.dao.test;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.webim.dao.UserFriendDao;
import org.webim.entity.FriendSet;
import org.webim.entity.UserFriend;
import org.webim.util.UUIDUtil;

/**
 * @ClassName UserFriendTest
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-13 下午4:10:01
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml" })
@ActiveProfiles("test")
public class UserFriendDaoTest {
    @Resource
    private UserFriendDao userFriendDao;

    @Test
    public void addUserFriendTest() {
        UserFriend userFriend = new UserFriend();
        userFriend.setUserFriendId(UUIDUtil.getUUID());
        userFriend.setUserId("31169b16459547bca6cd1c71f02334a7");
        userFriend.setFriendId("2b002ee1137048a5815cbbb57638736d");
        userFriend.setFriendSetId("5a2c539b889d46b99757b5ddd7355445");
        userFriendDao.addUserFriend(userFriend);
    }
}
