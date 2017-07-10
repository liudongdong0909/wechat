package com.donggua.wechat.controller;

import com.alibaba.fastjson.JSONObject;
import com.donggua.wechat.common.util.HttpClientUtil;
import com.donggua.wechat.service.base.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 回调
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-04-28 上午 12:08
 */
@Controller
@RequestMapping("auth")
public class CallBackController {

    @Autowired
    private PropertiesService propertiesService;

    @RequestMapping("success")
    @ResponseBody
    public String callback(HttpServletRequest request){
        String url = propertiesService.GET_AUTH_ACCESS_TOKEN_BY_CODE;

        // appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code

        Map<String, String> params = new HashMap<>();
        params.put("appid", propertiesService.APP_ID);
        params.put("secret", propertiesService.APP_SECRET);
        params.put("code", request.getParameter("code"));
        params.put("grant_type", "authorization_code");


        String tokenInfo = HttpClientUtil.doGet(url, params);

        String accessToken = (String) JSONObject.parseObject(tokenInfo).get("access_token");
        String openId = (String) JSONObject.parseObject(tokenInfo).get("openid");

        String userInfoUrl = propertiesService.GET_AUTH_USER_INFO_URL;
        params.clear();
        params.put("access_token", accessToken);
        params.put("openid", openId);
        params.put("lang", "zh_CN");

        String userInfo = HttpClientUtil.doGet(userInfoUrl, params);
        System.out.println(tokenInfo);
        System.out.println(userInfo);

        return tokenInfo;
    }
}
