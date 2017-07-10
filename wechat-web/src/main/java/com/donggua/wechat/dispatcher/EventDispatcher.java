package com.donggua.wechat.dispatcher;

import com.alibaba.fastjson.JSONObject;
import com.donggua.wechat.common.util.HttpClientUtil;
import com.donggua.wechat.common.util.MessageUtil;
import com.donggua.wechat.message.response.Article;
import com.donggua.wechat.message.response.NewsMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 事件消息业务分发器
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-05-14 下午 04:23
 */
public class EventDispatcher {

    public static final Logger LOGGER = LoggerFactory.getLogger(EventDispatcher.class);

    public static String processEvent(Map<String, String> map) {
        String openid = map.get("FromUserName"); // 用户openid
        String mpid = map.get("ToUserName"); // 公众号原始id

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) { //关注事件
            System.out.println("==============这是关注事件！");
            NewsMessage newsMessage = new NewsMessage();
            newsMessage.setToUserName(openid);
            newsMessage.setFromUserName(mpid);
            newsMessage.setCreateTime(new Date().getTime());
            newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);

            LOGGER.info("openid = {}", openid);

            try {
                // 获取accessToken
                Map<String, String> params = new HashMap<>();
                params.put("grant_type", "client_credential");
                params.put("appid", "wxef0cf647e215aba1");
                params.put("secret", "00bcbaf27dee97347c30914c23f5966c");
                String tokenInfo = HttpClientUtil.doGet("https://api.weixin.qq.com/cgi-bin/token", params);

                LOGGER.info("token 信息：tokenInfo= {}", tokenInfo);

                String accessToken = (String) JSONObject.parseObject(tokenInfo).get("access_token");
                params.clear();
                params.put("access_token", accessToken);
                params.put("openid", openid);
                params.put("lang", "zh_CN");

               // String userInfo = HttpClientUtil.doGet("https://api.weixin.qq.com/sns/userinfo", params);
                String userInfo = HttpClientUtil.doGet("https://api.weixin.qq.com/cgi-bin/user/info", params);

                LOGGER.info("用户信息：userInfo= {}", userInfo);

                Article article = new Article();
                article.setDescription("欢迎来到大冬瓜的个人博客：成长之路！"); //图文消息的描述
                article.setPicUrl((String) JSONObject.parseObject(userInfo).get("headimgurl")); //图文消息图片地址
                article.setTitle("尊敬的：" + JSONObject.parseObject(userInfo).get("nickname") + ",你好！");  //图文消息标题
                article.setUrl("http://blog.csdn.net/liudongdong0909");  //图文 url 链接
                List<Article> list = new ArrayList<Article>();
                list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里 list 中加入多个 Article 即可！
                newsMessage.setArticleCount(list.size());
                newsMessage.setArticles(list);

                return MessageUtil.newsMessageToXml(newsMessage);
            } catch (Exception e) {
                LOGGER.error("关注公众号返回图文消息失败:", e);
            }


        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) { //取消关注事件
            System.out.println("==============这是取消关注事件！");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SCAN)) { //扫描二维码事件
            System.out.println("==============这是扫描二维码事件！");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_LOCATION)) { //位置上报事件
            System.out.println("==============这是位置上报事件！");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_CLICK)) { //自定义菜单点击事件
            System.out.println("==============这是自定义菜单点击事件！");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_VIEW)) { //自定义菜单 View 事件
            System.out.println("==============这是自定义菜单 View 事件！");
        }

        return null;
    }
}
