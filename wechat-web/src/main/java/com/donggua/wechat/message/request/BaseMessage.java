package com.donggua.wechat.message.request;

/**
 * 微信请求消息体-基本消息类
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-05-14 下午 04:00
 */
public class BaseMessage {

    // 开发者微信号
    private String ToUserName;

    // 发送方帐号（一个 OpenID）
    private String FromUserName;

    // 消息创建时间 （整型）
    private long CreateTime;

    // 消息类型（text/image/location/link/video/shortvideo）
    private String MsgType;

    // 消息 id，64 位整型
    private long MsgId;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }
}
