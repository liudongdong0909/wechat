package com.donggua.wechat.dispatcher;

import com.donggua.wechat.common.util.MessageUtil;
import com.donggua.wechat.message.response.Article;
import com.donggua.wechat.message.response.NewsMessage;
import com.donggua.wechat.message.response.TextMessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 消息业务处理分发器
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-05-14 下午 04:21
 */
public class MsgDispatcher {

    public static String processMessage(Map<String, String> map) {
        String openid = map.get("FromUserName"); // 用户openid
        String mpid = map.get("ToUserName"); // 公众号原始id

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息
            System.out.println("==============这是文本消息！");

            // 普通文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(openid);
            textMessage.setFromUserName(mpid);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

            if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)){
                textMessage.setContent("你好！这是大冬瓜的个人账号！");
                return  MessageUtil.textMessageToXml(textMessage);
            }

        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // 图片消息
            System.out.println("==============这是图片消息！");

            NewsMessage newsMessage  = new NewsMessage();
            newsMessage.setToUserName(openid);
            newsMessage.setFromUserName(mpid);
            newsMessage.setCreateTime(new Date().getTime());
            newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);

            if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)){
                System.out.println("==============这是图片消息！");
                Article article=new Article();
                article.setDescription("这是图文消息 1"); //图文消息的描述
                article.setPicUrl("http://i.imgur.com/EJZyCqy.png"); //图文消息图片地址
                article.setTitle("图文消息 1");  //图文消息标题
                article.setUrl("http://blog.csdn.net/liudongdong0909/article/details/62226036");  //图文 url 链接
                List<Article> list=new ArrayList<Article>();
                list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里 list 中加入多个 Article 即可！
                newsMessage.setArticleCount(list.size());
                newsMessage.setArticles(list);
                return MessageUtil.newsMessageToXml(newsMessage);
            }

        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) { // 链接消息
            System.out.println("==============这是链接消息！");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) { // 位置消息
            System.out.println("==============这是位置消息！");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) { // 视频消息
            System.out.println("==============这是视频消息！");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) { // 语音消息
            System.out.println("==============这是语音消息！");
        }

        return null;
    }
}
