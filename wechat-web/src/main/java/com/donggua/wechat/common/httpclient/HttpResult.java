package com.donggua.wechat.common.httpclient;

/**
 * HttpClient请求结果封装
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-04 上午 03:22
 */
public class HttpResult {

    private Integer code;

    private String body;

    public HttpResult() {
    }

    public HttpResult(Integer code, String body) {
        this.code = code;
        this.body = body;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
