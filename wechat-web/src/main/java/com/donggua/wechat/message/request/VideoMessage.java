package com.donggua.wechat.message.request;

/**
 * 视频/小视频消息
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-05-14 下午 04:18
 */
public class VideoMessage extends BaseMessage {

    private String MediaId; // 视频消息媒体 id，可以调用多媒体文件下载接口拉取数据

    private String ThumbMediaId; // 视频消息缩略图的媒体 id，可以调用多媒体文件下载接口拉取数据

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
