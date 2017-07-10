package com.donggua.wechat.message.request;

/**
 * 语音消息
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-05-14 下午 04:19
 */
public class VoiceMessage extends BaseMessage {

    // 媒体 ID
    private String MediaId;

    // 语音格式
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
