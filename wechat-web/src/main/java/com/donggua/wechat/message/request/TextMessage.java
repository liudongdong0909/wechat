package com.donggua.wechat.message.request;

/**
 * 文本消息
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-05-14 下午 04:03
 */
public class TextMessage extends BaseMessage {

    // 消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
