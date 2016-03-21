package org.webim.dao.test;

import java.util.List;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.webim.dao.GroupDao;
import org.webim.entity.Group;
import org.webim.entity.User;
import org.webim.util.UUIDUtil;

/**
 * @ClassName GroupDaoTest
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-13 下午3:26:16
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml" })
@ActiveProfiles("test")
public class GroupDaoTest {
    @Resource
    private GroupDao groupDao;

    @Test
    public void createGroupTest() {
        Group group = new Group();
        group.setId(UUIDUtil.getUUID());
        group.setName("DDD群");
        group.setFace("images/1.png");
        groupDao.createGroup(group);
    }
    
    @Test
    public void queryGroupsForSetTest() {
        String userId = "31169b16459547bca6cd1c71f02334a7";
        String groupSetId = "48aa18ad39cd4358b488ce787ac8401a";
        List<Group> groupsForSet = groupDao.queryGroupsForSet(userId, groupSetId);
        for(Group group:groupsForSet) {
            System.out.println(
                    group.getId()
                  + group.getName()
                  + group.getFace());
        }
    }
    
    @Test
    public void queryUsersByGroupIdTest() {
        String groupId = "232dd2c0c5b046b9819eac447022c76b";
        List<User> users = groupDao.queryUsersByGroupId(groupId);
        for (User user:users) {
            System.out.println(
                    user.getId()
                  + user.getName()
                  + user.getFace());
        }
    }
}
