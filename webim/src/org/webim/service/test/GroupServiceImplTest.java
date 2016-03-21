package org.webim.service.test;

import java.util.List;
import javax.annotation.Resource;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.webim.entity.FriendSet;
import org.webim.entity.Group;
import org.webim.entity.GroupSet;
import org.webim.entity.User;
import org.webim.service.GroupService;
import org.webim.service.UserService;
import org.webim.util.AjaxResult;


/**
 * @ClassName UserServiceImplTest
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-12 下午9:27:48
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml" })
@ActiveProfiles("test")
public class GroupServiceImplTest {
    @Resource
    private GroupService groupService;

    @Test
    @Transactional
    @Rollback(false)
    public void findGroupsTest() {
        String userId = "2b002ee1137048a5815cbbb57638736d";
        AjaxResult result = groupService.findGroups(userId);
        List<GroupSet> groupSets = (List<GroupSet>) result.getData();
        for (GroupSet groupSet:groupSets) {
            System.out.print(groupSet.getId() +":"+ groupSet.getName());
            for (Group group:groupSet.getItem()) {
                System.out.println(
                        group.getId()
                      + group.getName()
                      + group.getFace());
            }
            System.out.println();
        }
    }
    
    @Test
    @Transactional
    @Rollback(false)
    public void findGroupUsersTest() {
        String groupId = "232dd2c0c5b046b9819eac447022c76b";
        AjaxResult result = groupService.findGroupUsers(groupId);
        List<User> users = (List<User>) result.getData();
        for (User user:users) {
            System.out.println(
                    user.getId()
                  + user.getName()
                  + user.getFace());
        }
    }
}
