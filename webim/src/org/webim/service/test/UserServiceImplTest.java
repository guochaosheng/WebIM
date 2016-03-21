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
import org.webim.entity.User;
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
public class UserServiceImplTest {
    @Resource
    private UserService userService;
    
    @Test
    @Transactional
    @Rollback(false)
    public void findFrinedsTest() {
        String userId = "31169b16459547bca6cd1c71f02334a7";
        AjaxResult result = userService.findFrineds(userId);
        Assert.assertEquals(1, result.getStatus());
        Assert.assertEquals("加载分组好友成功", result.getMsg());
        List<FriendSet> friendSetList = (List<FriendSet>) result.getData();
        for (FriendSet friendSet:friendSetList) {
            System.out.println("id:" + friendSet.getId());
            System.out.println("name:" + friendSet.getName());
            System.out.println("nums:" + friendSet.getNums());
            for (User friend:friendSet.getItem()) {
                System.out.println(
                        "id:" + friend.getId()
                      + " name:" + friend.getName()
                      + " face:" + friend.getFace()
                      );
            }
        }
    }

    @Test
    @Transactional
    @Rollback(false)
    public void checkLoginTest() {
        // 用户名错误(优先验证用户名)
        AjaxResult result1
            = userService.checkLogin("xiaolei", "123456");
        Assert.assertEquals(-1, result1.getStatus());
        Assert.assertEquals("账号错误", result1.getMsg());
        // 用户名正确, 密码错误
        AjaxResult result2
            = userService.checkLogin("十尾巴", "4nv9vn");
        Assert.assertEquals(0, result2.getStatus());
        Assert.assertEquals("密码错误", result2.getMsg());
        // 用户名正确, 密码正确
        AjaxResult result3
            = userService.checkLogin("十尾巴", "123456");
        Assert.assertEquals(1, result3.getStatus());
        Assert.assertEquals("登录成功", result3.getMsg());
    }
}
