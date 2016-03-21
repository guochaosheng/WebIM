package org.webim.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.webim.dao.GroupDao;
import org.webim.entity.Message;
import org.webim.entity.User;
import org.webim.util.AjaxResult;
import org.webim.util.MessageManager;
import org.webim.util.UUIDUtil;

/**
 * @ClassName MessageController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-14 下午3:48:48
 * @version 1.0.0
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    @Resource
    private GroupDao groupDao;

    /**
     * @Description 用户发送给好友的消息
     * @param message
     * @return 消息发送状态
     */
    @RequestMapping("/sendMessage")
    @ResponseBody
    public AjaxResult sendMessage(@RequestBody Message message) {
        AjaxResult result = new AjaxResult();
        try {
            if (message.getDataType() == 0) {
                String toUserId = message.getToUserId();
                BlockingQueue<Message> userMessageQueue = MessageManager.getUserMessageQueue(toUserId);
                if (userMessageQueue == null) {
                    //TODO 此处为模拟，如果用户队列不存在表明用户未登录(未发出接收消息请求)，直接存入数据库，不占用内存
                    userMessageQueue = MessageManager.addUserMessageQueue(toUserId);
                }
                if (userMessageQueue != null && userMessageQueue.offer(message)){
                    result.setStatus(1);
                    result.setMsg("消息发送成功");
                    return result;
                }
            } else {
                List<User> users = groupDao.queryUsersByGroupId(message.getToUserId());
                int count = 0;
                if (users != null) {
                    for (User user:users) {//将消息分发送给发送者以外的群成员
                        String toUserId = user.getId();
                        if (toUserId.equals(message.getFromUserId())) {
                            continue;
                        }
                        BlockingQueue<Message> userMessageQueue = MessageManager.getUserMessageQueue(toUserId);
                        if (userMessageQueue == null) {
                            userMessageQueue = MessageManager.addUserMessageQueue(toUserId);
                        }
                        if (userMessageQueue != null && userMessageQueue.offer(message)){
                            count++;
                        }
                    }
                    result.setStatus(1);
                    result.setMsg("消息成功已发送给" + count + "个群成员");
                    return result;
                }
            }
            result.setStatus(0);
            result.setMsg("消息发送失败，请重新发送");
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(0);
            result.setMsg("消息发送失败，请重新发送");
        }
        return result;
    }

    /**
     * @Description 获取好友发送用户的消息内容
     * @return 消息内容
     */
    @RequestMapping("/receiveMessage")
    @ResponseBody
    public AjaxResult receiveMessage(String userId) {
        AjaxResult result = new AjaxResult();
        try{
            String mark = UUIDUtil.getUUID();
            MessageManager.updateMark(userId, mark);
            BlockingQueue<Message> userMessageQueue = MessageManager.getUserMessageQueue(userId);
            if (userMessageQueue == null) {
                userMessageQueue = MessageManager.addUserMessageQueue(userId);
            }
            Message message = userMessageQueue.poll(60, TimeUnit.SECONDS);          
            if (mark != MessageManager.getMark(userId) && message != null) {//当用户请求线程的标记发生变化时，表明发出开启了新的请求线程，需要把当前请求线程的操作倒回
                userMessageQueue.offer(message);
                result.setStatus(-2);
                result.setMsg("无法获取消息");
                return result;
            }
            //TODO 线程至此假定消息已经返给用户，不再对其后代码线程问题或者网络不稳定等因素进行处理，待後續改進
            if (message != null) {
                List<Message> messageList = new ArrayList<Message>();
                messageList.add(message);
                for (int i=0; i<20; i++) {//单次接收的消息上限20条
                    message = userMessageQueue.poll();
                    if (message != null) {
                        messageList.add(message);
                    } else {
                        break;
                    }
                }
                result.setStatus(1);
                result.setMsg("接收消息成功");
                result.setData(messageList);
                return result;
            }
            result.setStatus(2);
            result.setMsg("无等待消息");
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(0);
            result.setMsg("消息更新失败");
        }
        return result;
    }
}
