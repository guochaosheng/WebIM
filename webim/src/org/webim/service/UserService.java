package org.webim.service;

import org.webim.util.AjaxResult;

/**
 * @ClassName UserService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-12 下午8:57:33
 * @version 1.0.0
 */
public interface UserService {

    /**
     * @Description 通过用户ID查找分组成员列表
     * @param userId
     * @return
     */
    AjaxResult findFrineds(String userId);

    /**
     * @Description 验证登录
     * @return 验证结果
     */
    AjaxResult checkLogin(String username, String password);
}
