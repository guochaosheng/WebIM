package org.webim.util;

import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import org.webim.entity.Message;

/**
 * @ClassName Manager
 * @Description 用户消息的管理器
 * @author John
 * @Date 2016-3-14 下午2:49:25
 * @version 1.0.0
 */
public class MessageManager {

    /**
     * @Field messageMap : 存储用户ID和消息队列
     */
    private static Map<String, BlockingQueue<Message>> messageMap = new ConcurrentHashMap<String, BlockingQueue<Message>>();
    /**
     * @Field markMap : 存储用户ID和每个请求接收消息线程的UUID标识
     */
    public static Map<String, String> markMap = new ConcurrentHashMap<String, String>();

    /**
     * @Description 获取用户消息队列
     * @param userId
     * @return
     */
    public static BlockingQueue<Message> getUserMessageQueue(String userId) {
        return messageMap.get(userId);
    }

    /**
     * @Description 添加一个用户消息队列,多线程同步
     * @param userId
     */
    public static synchronized BlockingDeque<Message> addUserMessageQueue(String userId) {
        LinkedBlockingDeque<Message> queue = new LinkedBlockingDeque<Message>();
        messageMap.put(userId, queue);
        return queue;
    }

    /**
     * @Description 删除一个用户消息队列
     * @param userId
     */
    public static void removeUserMessageQueue(String userId) {
        messageMap.remove(userId);
    }

    /**
     * @Description 更新用户的请求线程的标识
     * @param userId
     * @param mark
     */
    public static void updateMark(String userId, String mark) {
        markMap.put(userId, mark);
    }

    /**
     * @Description 获取用户当前的请求线程的标识
     * @param userId 
     * @return
     */
    public static String getMark(String userId) {
        return markMap.get(userId);
    }
}
