package com.donggua.wechat.service.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 获取配置文件属性值得service
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-04-02 上午 12:00
 */
@Service
public class PropertiesService {

    /** app_id */
    @Value("${APP_ID}")
    public String APP_ID;

    /** appSecret */
    @Value("${APP_SECRET}")
    public String APP_SECRET;

    @Value("${ENCODING_AES_KEY}")
    public String ENCODING_AES_KEY;

    /** 根据app_id 和 appsecret 获取 access_token 的基础URL */
    @Value("${GET_ACCESS_TOKEN_BASE_URL}")
    public String GET_ACCESS_TOKEN_BASE_URL;

    @Value("${GET_AUTH_CODE_URL}")
    public String GET_AUTH_CODE_URL;

    @Value("${AUTH_SUCCESS_CALL_BACK_URL}")
    public String AUTH_SUCCESS_CALL_BACK_URL;

    @Value("${GET_AUTH_ACCESS_TOKEN_BY_CODE}")
    public String GET_AUTH_ACCESS_TOKEN_BY_CODE;

    @Value("${GET_AUTH_USER_INFO_URL}")
    public String GET_AUTH_USER_INFO_URL;

    @Value("${VALIDATE_ACCESS_TOKEN_URL}")
    public String VALIDATE_ACCESS_TOKEN_URL;

}
