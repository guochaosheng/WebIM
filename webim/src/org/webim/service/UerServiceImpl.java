package org.webim.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webim.dao.UserDao;
import org.webim.dao.UserFriendSetDao;
import org.webim.entity.FriendSet;
import org.webim.entity.User;
import org.webim.util.AjaxResult;
import org.webim.util.LoginManager;
import org.webim.util.Md5Util;

/**
 * @ClassName UerServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-12 下午9:00:25
 * @version 1.0.0
 */
@Service
public class UerServiceImpl implements UserService{
    @Resource
    private UserFriendSetDao userFriendSetDao;
    @Resource
    private UserDao userDao;
    
    /* (非 Javadoc)
     * Description:
     * @see org.webim.service.UserService#loadFrineds()
     */
    @Transactional(readOnly=true)
    @Override
    public AjaxResult findFrineds(String userId) {
        AjaxResult result = new AjaxResult();
        List<FriendSet> userFriendSets
            = userFriendSetDao.queryUserFriendSet(userId);
        for (FriendSet friendSet:userFriendSets) {
            List<User> friendSetUser
                = userDao.queryFriendsForSet(userId, friendSet.getId());
            friendSet.setItem(friendSetUser);
            friendSet.setNums(friendSetUser.size());
        }
        result.setStatus(1);
        result.setMsg("加载分组好友成功");
        result.setData(userFriendSets);
        return result;
    }

    @Transactional(readOnly=true)
    @Override
    public AjaxResult checkLogin(String username, String password) {
        AjaxResult result = new AjaxResult();
        User user = userDao.queryUserByName(username);
        if (user == null) {
            result.setStatus(-1);
            result.setMsg("账号错误");
            return result;
        }
        if (!user.getUserPassword().equals(Md5Util.md5(password))) {
            result.setStatus(0);
            result.setMsg("密码错误");
            return result;
        }
        result.setData(user);
        result.setStatus(1);
        result.setMsg("登录成功");
        return result;
    }
}
