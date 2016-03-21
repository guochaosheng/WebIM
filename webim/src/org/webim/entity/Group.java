package org.webim.entity;


/**
* @ClassName Group
* @Description TODO(这里用一句话描述这个类的作用)
* @author John
* @Date 2016-3-16 下午9:42:55
* @version 1.0.0
*/
public class Group {
   /**
    * @Field id : 群ID
    */
   private String id;
   /**
    * @Field name : 群的名称
    */
   private String name;
   /**
    * @Field face : 群的头像
    */
   private String face;
   
   public String getId() {
       return id;
   }
   
   public void setId(String id) {
       this.id = id;
   }
   
   public String getName() {
       return name;
   }
   
   public void setName(String name) {
       this.name = name;
   }
   
   public String getFace() {
       return face;
   }
   
   public void setFace(String face) {
       this.face = face;
   }   
}
