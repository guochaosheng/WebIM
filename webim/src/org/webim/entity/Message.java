package org.webim.entity;

import java.sql.Timestamp;

/**
 * @ClassName Message
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-14 下午2:40:52
 * @version 1.0.0
 */
public class Message {
    /**
     * @Field fromUserId : 发送方
     */
    private String fromUserId;
    /**
     * @Field toUserId : 接收方
     */
    private String toUserId;
    /**
     * @Field message : 消息内容体
     */
    private String content;
    /**
     * @Field date : 发送消息的时间
     */
    private Timestamp date;
    /**
     * @Field dataType : 消息的类型
     */
    private int dataType;

    public String getFromUserId() {
        return fromUserId;
    }
    
    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }
    
    public String getToUserId() {
        return toUserId;
    }
    
    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }
    
    public String getContent() {
        return content;
    }

    
    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDate() {
        return date;
    }
    
    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getDataType() {
        return dataType;
    }
    
    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        result = prime * result + dataType;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((fromUserId == null) ? 0 : fromUserId.hashCode());
        result = prime * result + ((toUserId == null) ? 0 : toUserId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Message other = (Message) obj;
        if (content == null) {
            if (other.content != null)
                return false;
        } else if (!content.equals(other.content))
            return false;
        if (dataType != other.dataType)
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (fromUserId == null) {
            if (other.fromUserId != null)
                return false;
        } else if (!fromUserId.equals(other.fromUserId))
            return false;
        if (toUserId == null) {
            if (other.toUserId != null)
                return false;
        } else if (!toUserId.equals(other.toUserId))
            return false;
        return true;
    }
}
