package org.webim.util;


/**
 * @ClassName AjaxResult
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author John
 * @Date 2016-3-12 下午8:54:51
 * @version 1.0.0
 */
public class AjaxResult {
    /**
     * @Field status : 状态
     */
    private int status;
    /**
     * @Field msg : 消息
     */
    private String msg;
    /**
     * @Field data : 数据
     */
    private Object data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
