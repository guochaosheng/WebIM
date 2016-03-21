package org.webim.entity;

import java.util.List;

/**
 * @ClassName Friend
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-12 下午9:07:07
 * @version 1.0.0
 */
public class FriendSet {
    /**
     * @Field name : 分组的名称
     */
    private String name;
    /**
     * @Field nums : 分组包含的好友数量
     */
    private Integer nums;
    /**
     * @Field id : 分组的唯一性ID标识
     */
    private String id;
    /**
     * @Field item : 分组的好友集
     */
    private List<User> item;

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getNums() {
        return nums;
    }
    
    public void setNums(Integer nums) {
        this.nums = nums;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public List<User> getItem() {
        return item;
    }  
    
    public void setItem(List<User> item) {
        this.item = item;
    }
}
