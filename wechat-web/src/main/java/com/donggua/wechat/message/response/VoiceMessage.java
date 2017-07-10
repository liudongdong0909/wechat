package com.donggua.wechat.message.response;

/**
 * 语音消息
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-05-14 下午 04:58
 */
public class VoiceMessage extends BaseMessage{

    private Voice Voice;

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }
}
