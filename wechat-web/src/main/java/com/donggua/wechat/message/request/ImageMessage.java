package com.donggua.wechat.message.request;

/**
 * 图片消息
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-05-14 下午 04:01
 */
public class ImageMessage extends BaseMessage {

    // 图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
