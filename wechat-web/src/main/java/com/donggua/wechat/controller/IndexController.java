package com.donggua.wechat.controller;

import com.donggua.wechat.dispatcher.EventDispatcher;
import com.donggua.wechat.dispatcher.MsgDispatcher;
import com.donggua.wechat.common.util.CheckUtil;
import com.donggua.wechat.common.util.MessageUtil;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 微信验证controller
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-04-01 下午 05:28
 */
@Controller
public class IndexController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "test/test", method = RequestMethod.GET)
    @ResponseBody
    public String index(@RequestParam String signature, @RequestParam String timestamp,
                        @RequestParam String nonce, @RequestParam String echostr) {

        try {
            if (CheckUtil.checkSignature(signature, timestamp, nonce)){
                System.out.println(echostr);
                return echostr;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "test/test", method = RequestMethod.POST)
    public void message(HttpServletRequest request, HttpServletResponse response){
        try {
            String responseXML = null;

            Map<String, String> requestMessage = MessageUtil.parseXml(request);

            String msgType = requestMessage.get("MsgType");

            if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgType)){
                responseXML = EventDispatcher.processEvent(requestMessage);//进入事件处理
                LOGGER.info("事件处理响应消息XML内容：responseXML= {}", responseXML);

            }else {
                responseXML = MsgDispatcher.processMessage(requestMessage); //进入消息处理
                LOGGER.info("消息响应消息XML内容：responseXML= {}", responseXML);
            }

            IOUtils.write(responseXML, response.getOutputStream(), "UTF-8");

        }catch (Exception e){
            LOGGER.error("接受消息处理异常：", e);
        }
    }
}
