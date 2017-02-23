package com.alienlab.controller;

import com.alienlab.service.ResponseService;
import com.alienlab.wechat.bean.JSApiTicket;
import com.alienlab.wechat.bean.MessageResponse;
import com.alienlab.wechat.bean.TextMessageResponse;
import com.alienlab.wechat.util.SignUtil;
import com.alienlab.wechat.util.WechatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.plugin2.message.Message;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.Map;

/**
 * Created by 橘 on 2016/12/23.
 */
@RestController
@RequestMapping("/wechat")
public class Wechat {
    private static final Logger logger = LoggerFactory.getLogger("Wechat");

    @Autowired
    SignUtil signUtil;
    @Autowired
    ResponseService responseService;
    @Autowired
    WechatUtil wechatUtil;
    @RequestMapping(value="",method=RequestMethod.GET)
    public String validateRequest(@RequestParam String signature,@RequestParam String timestamp,@RequestParam String nonce,@RequestParam String echostr){
        if (signUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }else{
            return "error";
        }
    }

    @RequestMapping(value="",method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody MessageResponse doMessageResponse(@RequestBody String body){
        logger.debug("get message from wechat:"+body);
        return responseService.doResponse(body);
    }
    @RequestMapping(value="/jsapi",method = RequestMethod.POST)
    public Map<String,String> getJsApiTicket(@RequestParam("url") String url){
        return wechatUtil.getJsapiSignature(url);
    }


}
