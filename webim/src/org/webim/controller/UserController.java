package org.webim.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.webim.entity.User;
import org.webim.service.GroupService;
import org.webim.service.UserService;
import org.webim.util.AjaxResult;
import org.webim.util.LoginManager;
import org.webim.util.UUIDUtil;

import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * @ClassName UserController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-12 下午8:54:03
 * @version 1.0.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private GroupService groupService;

    /**
     * @Description 加载分组成员列表
     * @param userId
     * @return
     */
    @RequestMapping("/loadFriends")
    @ResponseBody
    public AjaxResult loadFriends(String userId) {
        AjaxResult result = userService.findFrineds(userId);
        return result;
    }

    /**
     * @Description 加载用户群组列表
     * @param userId
     * @return
     */
    @RequestMapping("/loadGroups")
    @ResponseBody
    public AjaxResult loadGroups(String userId) {
        AjaxResult result = groupService.findGroups(userId);
        return result;
    }

    /**
     * @Description 加载群中的用户
     * @param groupId
     * @return
     */
    @RequestMapping("/loadUsers")
    @ResponseBody
    public AjaxResult loadUsersForGroup(String groupId) {
        AjaxResult result = groupService.findGroupUsers(groupId);
        return result;
    }
    
    /**
     * @Description 登录验证
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public AjaxResult login(
            HttpServletRequest request,
            HttpServletResponse response) {
        AjaxResult result = null;
        try {
            String auth = request.getHeader("Authorization");
            if (auth != null) {
                String[] encodeIdentity = auth.split(" ");
                String decodeIdentity
                = new String(Base64.decode(encodeIdentity[1].getBytes("UTF-8")));
                String[] userInfo = decodeIdentity.split(":");
                if (userInfo.length == 2) {
                    String username = userInfo[0];
                    String password = userInfo[1];
                    result = userService.checkLogin(username, password);
                    String token = UUIDUtil.getUUID();
                    // 将用户令牌保存到Session
                    request.getSession().setAttribute("userToken", token);
                    User user = (User) result.getData();
                    LoginManager.createMark(user.getId(), token);
                    // 设置返回客户端的header的token
                    response.setHeader("Authorization", "Token " + token);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult();
            result.setStatus(-2);
            result.setMsg("用户登录失败");
        }
        return result;
    }
}
