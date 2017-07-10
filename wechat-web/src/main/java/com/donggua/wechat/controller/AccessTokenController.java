package com.donggua.wechat.controller;

import com.donggua.wechat.common.util.HttpClientUtil;
import com.donggua.wechat.service.base.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取access_token的Controller
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-04-01 下午 11:51
 */
@RestController
public class AccessTokenController {

    @Autowired
    private PropertiesService propertiesService;

    /*  参数 	     是否必须 	说明
     *  grant_type	    是	    获取access_token填写client_credential
     *  appid	        是	    第三方用户唯一凭证
     *  secret	        是	    第三方用户唯一凭证密钥，即appsecret
     *
     *  access_token是公众号的全局唯一接口调用凭据，公众号调用各接口时都需使用access_token。
     *  开发者需要进行妥善保存。access_token的存储至少要保留512个字符空间。
     *  access_token的有效期目前为2个小时，需定时刷新，重复获取将导致上次获取的access_token失效。
     */
    //private String getAccessTokenURL= "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    /**
     * 获取access_token
     * 成功之后返回数据 {"access_token":"ACCESS_TOKEN","expires_in":7200}
     * 请求失败返回数据 {"errcode":40013,"errmsg":"invalid appid"}
     */
    @RequestMapping(value = "queryAccessToken", method =  RequestMethod.GET)
    public String getAccessToken(){
        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "client_credential");
        params.put("appid", propertiesService.APP_ID);
        params.put("secret", propertiesService.APP_SECRET);

        String tokenInfo = HttpClientUtil.doGet(propertiesService.GET_ACCESS_TOKEN_BASE_URL, params);
        return tokenInfo;
    }

    /**
     * 获取微信服务器IP地址
     *
     * 错误时返回信息: {"errcode":40013,"errmsg":"invalid appid"}
     */
    @RequestMapping(value = "queryWechatServerIP", method = RequestMethod.GET)
    public String queryWechatServerIP(@RequestParam(value = "accessToken", required = true) String accessToken){
        // https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN
        String getWechatServerIPURL = "https://api.weixin.qq.com/cgi-bin/getcallbackip";
        Map<String, String> params = new HashMap<>();
        params.put("access_token", accessToken);
        String wechatServerIP = HttpClientUtil.doGet(getWechatServerIPURL, params);
        return wechatServerIP;
    }

}
