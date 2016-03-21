package org.webim.dao.test;

import java.util.List;
import javax.annotation.Resource;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.webim.dao.UserDao;
import org.webim.entity.User;
import org.webim.util.UUIDUtil;

/**
 * @ClassName UserDaoTest
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-13 下午3:26:16
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml" })
@ActiveProfiles("test")
public class UserDaoTest {
    @Resource
    private UserDao userDao;

    /**
     * @Description 测试创建用户
     * @param user
     */
    @Test
    public void createUserTest() {
        User user = new User();
        user.setId(UUIDUtil.getUUID());
        user.setName("十一路");
        user.setUserPassword("123456");
        userDao.createUser(user);
    }

    @Test
    public void queryFriendsForSetTest() {
        String userId = "2b002ee1137048a5815cbbb57638736d";
        String friendSetId = "1f5f005d7bbb433da81d5dded0ea28f6";
        List<User> friendSetUser
            = userDao.queryFriendsForSet(userId, friendSetId);
        for (User user:friendSetUser) {
            System.out.println(user.getId() + user.getName() + user.getFace());
        }
    }

    @Test
    public void queryUserByNameTest() {
        String userName = "十尾巴";
        User user = userDao.queryUserByName(userName);
        Assert.assertEquals("2b002ee1137048a5815cbbb57638736d", user.getId());
        Assert.assertEquals("4QrcOUm6Wau+VuBX8g+IPg==", user.getUserPassword());
        Assert.assertEquals("images/1.png", user.getFace());
    }
}
