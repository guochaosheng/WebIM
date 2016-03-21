package org.webim.dao.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.webim.dao.UserGroupSetDao;
import org.webim.entity.GroupSet;


/**
 * @ClassName UserGroupSetDaoTest
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-17 上午11:36:51
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml" })
@ActiveProfiles("test")
public class UserGroupSetDaoTest {
    @Resource
    private UserGroupSetDao userGroupSetDao;

    @Test
    public void queryUserGroupSetTest() {
        List<GroupSet> userGroupSet = userGroupSetDao.queryUserGroupSet("31169b16459547bca6cd1c71f02334a7");
        for (GroupSet groupSet:userGroupSet) {
            System.out.println(
                    groupSet.getId()
                  + groupSet.getName()
                  + groupSet.getNums()
                  );
        }
    }
}
