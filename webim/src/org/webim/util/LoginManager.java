/******************************************************************
 *    Package:     org.webim.util
 *
 *    Filename:    LoginManager.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    Company:     TODO(公司名称)
 *
 *    @author:     John
 *
 *    @version:    1.0.0
 *
 *    Create at:   2016-3-20 下午11:24:40
 *
 *    Revision:
 *
 *    2016-3-20 下午11:24:40
 *        - first revision
 *
 *****************************************************************/
package org.webim.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName LoginManager
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-20 下午11:24:40
 * @version 1.0.0
 */
public class LoginManager {
    private static Map<String, String> userMap = new ConcurrentHashMap<String, String>();
    
    public static void createMark(String userId, String uuid) {
        userMap.put(userId, uuid);
    }
    
    public static String getMark(String userId) {
        return userMap.get(userId);
    }
}
