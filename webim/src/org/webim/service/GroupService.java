package org.webim.service;

import org.webim.util.AjaxResult;

/**
 * @ClassName GroupService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-17 下午12:28:11
 * @version 1.0.0
 */
public interface GroupService {

    /**
     * @Description 通过用户ID查找用户群组列表
     * @param userId
     * @return
     */
    AjaxResult findGroups(String userId);
    
    /**
     * @Description 通过群ID号查找群中拥有的用户
     * @param groupId
     * @return
     */
    AjaxResult findGroupUsers(String groupId);
}
