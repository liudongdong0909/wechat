package com.donggua.wechat.controller;

import com.donggua.wechat.common.util.HttpClientUtil;
import com.donggua.wechat.service.base.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取用户信息
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-04-27 下午 06:44
 */
@Controller
@RequestMapping("user")
public class UserInfoController {

    @Autowired
    private PropertiesService propertiesService;

    @RequestMapping("login")
    public void getSnsApiBase(HttpServletResponse response) throws IOException {

        String callbackUrl = propertiesService.AUTH_SUCCESS_CALL_BACK_URL;
        Map<String, String> params = new HashMap<>();
        params.put("appid", propertiesService.APP_ID);
        params.put("redirect_uri", URLEncoder.encode(callbackUrl));
        params.put("response_type", "code");
        params.put("scope", "snsapi_userinfo");
        params.put("state", "STATE#wechat_redirect");

        String url = propertiesService.GET_AUTH_CODE_URL
                + "?appid=" + propertiesService.APP_ID
                + "&redirect_uri=" + URLEncoder.encode(callbackUrl)
                + "&response_type=code"
                + "&scope=snsapi_userinfo"
                + "&state=STATE#wechat_redirect";

        response.sendRedirect(url);

    }

    @RequestMapping("userInfo")
    @ResponseBody
    public String getSnsApiUserInfo(@RequestParam(value = "access_token", required = true)String accessToken,
                                    @RequestParam(value = "openid", required = true)String openid){

        // access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
        String userInfoUrl = propertiesService.GET_AUTH_USER_INFO_URL;
        Map<String, String> params = new HashMap<>();
        params.put("access_token", accessToken);
        params.put("openid", openid);
        params.put("lang", "zh_CN");

        String userInfo = HttpClientUtil.doGet(userInfoUrl, params);

        return userInfo;
    }

    @RequestMapping("validate")
    @ResponseBody
    public String validateAccessToken(@RequestParam(value = "access_token", required = true)String accessToken,
                                      @RequestParam(value = "openid", required = true)String openid){

        String validateAccessTokenUrl = propertiesService.VALIDATE_ACCESS_TOKEN_URL;
        Map<String, String> params  = new HashMap<>();
        params.put("access_token", accessToken);
        params.put("openid", openid);

        String validateInfo = HttpClientUtil.doGet(validateAccessTokenUrl, params);
        return validateInfo;
    }

}
