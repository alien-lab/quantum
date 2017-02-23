package com.alienlab.wechat.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alienlab.wechat.bean.AccessToken;
import com.alienlab.wechat.bean.JSApiTicket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Map;

/**
 * Created by 橘 on 2016/12/26.
 */
@Component
public class WechatUtil {
    private static final Logger logger = LoggerFactory.getLogger("WechatUtil");
    // 获取access_token的接口地址（GET） 限200（次/天）
    public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    //JSAPI请求URL
    public final static String jsapi_ticket_url="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

    public final static String menu_url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    public final static String user_info="https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    public final static String cus_msg="https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";

    @Autowired
    SignUtil sign;
    @Value("${wechat.appid}")
    private String wxappid;
    @Value("${wechat.secret}")
    private String wxappsecret;
    public Map<String, String> getJsapiSignature(String url){
        logger.info("获得微信js-SDK加密signature:"+url);
        JSApiTicket jt=getJSApiTicket(wxappid,wxappsecret);
        if(jt==null){
            return null;
        }
        String jsapi_ticket=jt.getTicket();
        logger.info("获得jsapi_ticket："+jsapi_ticket);
        Map map=sign.sign(jsapi_ticket, url);
        map.put("appid", wxappid);
        return map;
    }

    private static JSApiTicket jsticket=null;
    public static JSApiTicket getJSApiTicket(String appid,String secret){
        logger.info("获取微信jsticket");
        if(jsticket== null){
            logger.info("系统中jsticket不存在！");
            jsticket=getJsApiTicket(appid,secret);
        }else{
            Calendar c=Calendar.getInstance();
            long now=c.getTimeInMillis();
            if(now-jsticket.getTicketTime()>=7000*1000){
                logger.info("系统中jsticket已超时！gettoken时间："+jsticket.getTicketTime()+",当前时间:"+now);
                jsticket=getJsApiTicket(appid,secret);
            }else{
                logger.info("系统中jsticket未过期可使用");
            }
        }
        return jsticket;
    }

    private static JSApiTicket getJsApiTicket(String appid,String secret){
        logger.info("微信服务号获取新JSApiTicket");
        HttpsInvoker invoker=new HttpsInvoker();
        JSApiTicket jt=null;
        AccessToken at=getAccessToken(appid,secret);
        if(at==null){
            return jt;
        }
        String requestUrl = jsapi_ticket_url.replace("ACCESS_TOKEN", at.getToken());
        JSONObject jsonObject = HttpsInvoker.httpRequest(requestUrl, "GET", null);
        // 如果请求成功
        if (null != jsonObject) {
            try {
                jt = new JSApiTicket();
                jt.setErrcode(jsonObject.getString("errcode"));
                jt.setErrmsg(jsonObject.getString("errmsg"));
                jt.setExpires_in(jsonObject.getString("expires_in"));
                jt.setTicket(jsonObject.getString("ticket"));
                Calendar c=Calendar.getInstance();
                jt.setTicketTime(c.getTimeInMillis());
            } catch (JSONException e) {
                jt = null;
                // 获取token失败
                logger.error("获取JSApiTicket失败 errcode:"+jsonObject.getString("errcode")+"errmsg:"+jsonObject.getString("errmsg"));
            }
        }
        return jt;
    }

    private static AccessToken accessToken = null;
    public static AccessToken getAccessToken(String appid, String appsecret) {
        logger.info("获取微信AccessToken");
        WechatUtil wu=new WechatUtil();
        if(accessToken== null){
            logger.info("系统中token不存在！");
            accessToken=wu.getToken(appid,appsecret);
        }else{
            Calendar c=Calendar.getInstance();
            long now=c.getTimeInMillis();
            if(now-accessToken.getTokenTime()>=7000*1000){
                logger.info("系统中token已超时！gettoken时间："+accessToken.getTokenTime()+",当前时间:"+now);
                accessToken=wu.getToken(appid,appsecret);
            }else{
                logger.info("系统中token未过期可使用");
            }
        }
        return accessToken;
    }

    public AccessToken getToken(String appid,String appsecret){
        logger.info("微信服务号获取新token");
        AccessToken at=null;
        String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
        HttpsInvoker invoker=new HttpsInvoker();
        JSONObject jsonObject = HttpsInvoker.httpRequest(requestUrl, "GET", null);
        // 如果请求成功
        if (null != jsonObject) {
            try {
                at = new AccessToken();
                at.setToken(jsonObject.getString("access_token"));
                at.setExpiresIn(jsonObject.getIntValue("expires_in"));
                Calendar c=Calendar.getInstance();
                at.setTokenTime(c.getTimeInMillis());
            } catch (JSONException e) {
                at = null;
                // 获取token失败
                logger.error("获取token失败 errcode:"+jsonObject.getString("errcode")+"errmsg:"+jsonObject.getString("errmsg"));
            }
        }
        return at;
    }

    public JSONObject getMenu(){
        JSONObject menu=new JSONObject();
        JSONArray buttons=new JSONArray();//定义一个按钮组
        //第一组按钮
        JSONObject button1=new JSONObject();
        button1.put("name","蟲洞");//第一个一级菜单
        JSONArray btn1_sub=new JSONArray();//第一个一级菜单的子菜单
        JSONObject btn1_sub_btn1=new JSONObject();
        btn1_sub_btn1.put("type","click");
        btn1_sub_btn1.put("name","濕媒體");
        btn1_sub_btn1.put("key","btn11");
        btn1_sub.add(btn1_sub_btn1);
        JSONObject btn1_sub_btn2=new JSONObject();
        btn1_sub_btn2.put("type","click");
        btn1_sub_btn2.put("name","賽博知覺");
        btn1_sub_btn2.put("key","btn12");
        btn1_sub.add(btn1_sub_btn2);
        JSONObject btn1_sub_btn3=new JSONObject();
        btn1_sub_btn3.put("type","click");
        btn1_sub_btn3.put("name","後現代商業");
        btn1_sub_btn3.put("key","btn13");
        btn1_sub.add(btn1_sub_btn3);
        button1.put("sub_button",btn1_sub);
        buttons.add(button1);

        //第二组按钮
        JSONObject button2=new JSONObject();
        button2.put("name","量子直覺");//第一个一级菜单
        JSONArray btn2_sub=new JSONArray();//第一个一级菜单的子菜单
        JSONObject btn2_sub_btn1=new JSONObject();
        btn2_sub_btn1.put("type","click");
        btn2_sub_btn1.put("name","我們是誰");
        btn2_sub_btn1.put("key","btn21");
        btn2_sub.add(btn2_sub_btn1);
        JSONObject btn2_sub_btn2=new JSONObject();
        btn2_sub_btn2.put("type","view");
        btn2_sub_btn2.put("name","直覺實驗室");
        btn2_sub_btn2.put("url","http://www.bigercat.com/quantum/h5_1/h5_auto.html");
        btn2_sub.add(btn2_sub_btn2);
        JSONObject btn2_sub_btn3=new JSONObject();
        btn2_sub_btn3.put("type","click");
        btn2_sub_btn3.put("name","量子留聲機");
        btn2_sub_btn3.put("key","btn23");
        btn2_sub.add(btn2_sub_btn3);
        button2.put("sub_button",btn2_sub);
        buttons.add(button2);

        //第三组按钮
        JSONObject button3=new JSONObject();
        button3.put("name","MIX迷思");//第一个一级菜单
        JSONArray btn3_sub=new JSONArray();//第一个一级菜单的子菜单
        JSONObject btn3_sub_btn1=new JSONObject();
        btn3_sub_btn1.put("type","click");
        btn3_sub_btn1.put("name","一看");
        btn3_sub_btn1.put("key","btn31");
        btn3_sub.add(btn3_sub_btn1);
        JSONObject btn3_sub_btn2=new JSONObject();
        btn3_sub_btn2.put("type","click");
        btn3_sub_btn2.put("name","一試");
        btn3_sub_btn2.put("key","btn32");
        btn3_sub.add(btn3_sub_btn2);
        JSONObject btn3_sub_btn3=new JSONObject();
        btn3_sub_btn3.put("type","click");
        btn3_sub_btn3.put("name","一問");
        btn3_sub_btn3.put("key","btn33");
        btn3_sub.add(btn3_sub_btn3);
        button3.put("sub_button",btn3_sub);
        buttons.add(button3);

        menu.put("button",buttons);
        return menu;
    }

    public boolean createMenu(){
        JSONObject menu=getMenu();//获得菜单
        AccessToken at=getAccessToken("wxb85df50f1f75e679","c0e8667b1b3265d53d5708b0cdbab42b");
        String token=at.getToken();
        String url=menu_url.replaceAll("ACCESS_TOKEN",token);
        JSONObject jsonObject = HttpsInvoker.httpRequest(url, "POST", menu.toJSONString());
        logger.debug("menu create:"+jsonObject.toJSONString());
        if (null != jsonObject) {
            if (0 != jsonObject.getIntValue("errcode")) {
                int result = jsonObject.getIntValue("errcode");
                logger.error("创建菜单失败 errcode:"+jsonObject.getIntValue("errcode")+",errmsg:"+jsonObject.getString("errmsg"));
            }else{
                logger.debug("菜单创建成功！");
            }
        }
        return true;
    }

    public JSONObject getUserInfo(String openid){
        AccessToken at=getAccessToken(wxappid,wxappsecret);
        String url=user_info.replaceAll("ACCESS_TOKEN",at.getToken()).replaceAll("OPENID",openid);
        JSONObject jsonObject = HttpsInvoker.httpRequest(url, "GET", null);
        if (null != jsonObject) {
            if (0 != jsonObject.getIntValue("errcode")) {
                int result = jsonObject.getIntValue("errcode");
                logger.error("获取用户信息失败 errcode:"+jsonObject.getIntValue("errcode")+",errmsg:"+jsonObject.getString("errmsg"));
            }else{
                logger.debug("获取用户信息成功："+jsonObject.toJSONString());
            }
        }
        return jsonObject;
    }

    public JSONObject sendTextMsg(String openid,String text){
        AccessToken at=getAccessToken(wxappid,wxappsecret);
        //AccessToken at=getAccessToken("wxb85df50f1f75e679","c0e8667b1b3265d53d5708b0cdbab42b");
        String url=cus_msg.replaceAll("ACCESS_TOKEN",at.getToken());
        JSONObject msg=new JSONObject();
        msg.put("touser",openid);
        msg.put("msgtype","text");
        JSONObject content=new JSONObject();
        content.put("content",text);
        msg.put("text",content);
        JSONObject jsonObject = HttpsInvoker.httpRequest(url, "POST", msg.toJSONString());
        if (null != jsonObject) {
            if (0 != jsonObject.getIntValue("errcode")) {
                int result = jsonObject.getIntValue("errcode");
                logger.error("发送用户信息失败 errcode:"+jsonObject.getIntValue("errcode")+",errmsg:"+jsonObject.getString("errmsg"));
            }else{
                logger.debug("发送用户信息成功："+jsonObject.toJSONString());
            }
        }
        return jsonObject;
    }

    public static void main(String [] args){
        WechatUtil w=new WechatUtil();
        //w.sendTextMsg("orgvcwL4KDSstHgVeLOII8BRWgRw","你是小鱼头吗？");
        w.createMenu();
    }
}
