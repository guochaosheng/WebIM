package org.webim.util;

import java.util.UUID;


/**
 * @ClassName UUIDUtil
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-13 下午3:31:44
 * @version 1.0.0
 */
public class UUIDUtil {

    /**
     * @Description 获取一个uuid
     * @return uuid序列码
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    
    public static void main(String[] args) {
        String uuid = UUIDUtil.getUUID();
        System.out.println(uuid);
    }
}
