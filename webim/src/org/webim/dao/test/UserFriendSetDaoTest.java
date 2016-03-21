package org.webim.dao.test;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.webim.dao.UserFriendSetDao;
import org.webim.entity.FriendSet;

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
public class UserFriendSetDaoTest {
    @Resource
    private UserFriendSetDao userFriendSetDao;

    @Test
    public void addUserFriendTest() {
        List<FriendSet> userFriendSets
        = userFriendSetDao.queryUserFriendSet("2b002ee1137048a5815cbbb57638736d");
        for (FriendSet fs:userFriendSets) {
            System.out.println(
                    "id:" + fs.getId() +
                    " name:" + fs.getName() +
                    " nums:" + fs.getNums() +
                    " item:" + fs.getItem());
        }
    }
}
