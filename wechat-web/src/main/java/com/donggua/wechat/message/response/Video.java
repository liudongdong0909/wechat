package com.donggua.wechat.message.response;

/**
 * 视频消息体
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-05-14 下午 04:56
 */
public class Video {

    private String MediaId;

    private String Title;

    private String Description;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
