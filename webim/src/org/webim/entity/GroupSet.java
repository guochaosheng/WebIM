package org.webim.entity;

import java.util.List;

/**
 * @ClassName UserGroup
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-16 下午9:40:34
 * @version 1.0.0
 */
public class GroupSet {
    /**
     * @Field name : 用户分组群的名称
     */
    private String name;
    /**
     * @Field nums : 用户分组群中人员的数量
     */
    private Integer nums;
    /**
     * @Field id : 用户分组群中的ID
     */
    private String id;
    /**
     * @Field item : 分组群集合列表
     */
    private List<Group> item;
    
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

    public List<Group> getItem() {
        return item;
    }

    public void setItem(List<Group> item) {
        this.item = item;
    } 
}
