package com.donggua.wechat.message.response;

/**
 * 图片消息
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-05-14 下午 04:53
 */
public class ImageMessage extends BaseMessage{

    private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }
}
