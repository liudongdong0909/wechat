package com.donggua.wechat.message.response;

/**
 * 文本消息消息体
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-05-14 下午 04:46
 */
public class TextMessage extends BaseMessage {

    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
