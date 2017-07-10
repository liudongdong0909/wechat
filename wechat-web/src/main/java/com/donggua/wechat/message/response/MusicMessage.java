package com.donggua.wechat.message.response;

/**
 * 音乐消息
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-05-14 下午 04:56
 */
public class MusicMessage extends BaseMessage {

    // 音乐
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}
