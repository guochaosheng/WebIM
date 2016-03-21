package org.webim.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webim.dao.GroupDao;
import org.webim.dao.UserGroupSetDao;
import org.webim.entity.Group;
import org.webim.entity.GroupSet;
import org.webim.entity.User;
import org.webim.util.AjaxResult;

/**
 * @ClassName GroupServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-17 下午12:18:21
 * @version 1.0.0
 */
@Service
public class GroupServiceImpl implements GroupService{
    @Resource
    private UserGroupSetDao userGroupSetDao;
    @Resource
    private GroupDao groupDao;

    /* (非 Javadoc)
     * Description:
     * @see org.webim.service.GroupService#findGroups(java.lang.String)
     */
    @Transactional(readOnly=true)
    @Override
    public AjaxResult findGroups(String userId) {
        AjaxResult result = new AjaxResult();
        List<GroupSet> userGroupSet = userGroupSetDao.queryUserGroupSet(userId);
        for (GroupSet groupSet:userGroupSet) {
            List<Group> groups = groupDao.queryGroupsForSet(userId, groupSet.getId());
            groupSet.setNums(groups.size());
            groupSet.setItem(groups);
        }
        result.setMsg("加载群组列表成功");
        result.setStatus(1);
        result.setData(userGroupSet);
        return result;
    }

    /* (非 Javadoc)
     * Description:
     * @see org.webim.service.GroupService#findGroupUsers(java.lang.String)
     */
    @Transactional(readOnly=true)
    @Override
    public AjaxResult findGroupUsers(String groupId) {
        AjaxResult result = new AjaxResult();
        List<User> users = groupDao.queryUsersByGroupId(groupId);
        result.setStatus(1);
        result.setMsg("加载群成员成功");
        result.setData(users);
        return result;
    }
}
