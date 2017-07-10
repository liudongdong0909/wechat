package com.donggua.wechat.message.response;

/**
 * 视频消息
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-05-14 下午 04:57
 */
public class VideoMessage extends BaseMessage{

    private Video Video;

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }
}
