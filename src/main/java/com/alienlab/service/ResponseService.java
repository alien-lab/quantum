package com.alienlab.service;

import com.alibaba.fastjson.JSONObject;
import com.alienlab.Repository.UserRepository;
import com.alienlab.entity.WxMenuEventLog;
import com.alienlab.entity.WxUser;
import com.alienlab.entity.WxUserMessage;
import com.alienlab.wechat.bean.MessageResponse;
import com.alienlab.wechat.bean.TextMessageResponse;
import com.alienlab.wechat.util.MessageProcessor;
import com.alienlab.wechat.util.WechatUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;


/**
 * Created by 橘 on 2016/12/23.
 */
@Service
public class ResponseService {
    @Autowired
    MessageProcessor messageProcessor;
    @Autowired
    LogService logService;
    @Autowired
    WechatUtil wechatUtil;

    @Autowired
    UserRepository userRepository;

    @Value("${wechat.response.defaultText}")
    private String defaultText;
    @Value("${wechat.response.subscribe}")
    private String subscribe;
    @Value("${wechat.response.building}")
    private String commingSoon;

    @Value("${wechat.log.textmsg}")
    private boolean logmsg;
    @Value("${wechat.log.menulog}")
    private boolean logmenu;
    @Value("${wechat.log.qrscan}")
    private boolean logqrscan;

    private static List<WxUser> admins=null;
    private void getAdmins(){
        if(admins==null){
            admins=userRepository.findUserByIsadmin("1");
        }
    }

    public MessageResponse doResponse(String msg){
        getAdmins();
        JSONObject json_msg=messageProcessor.xml2JSON(msg);
        WxUserMessage wx_msg=new WxUserMessage();

        wx_msg.setMessagetime(json_msg.getString("CreateTime"));
        wx_msg.setOpenid(json_msg.getString("FromUserName"));
        wx_msg.setMessagetype(json_msg.getString("MsgType"));
        switch (wx_msg.getMessagetype()){
            case "text":{
                wx_msg.setMessagecontent(json_msg.getString("Content"));
                if(logmsg){
                    logService.logMsg(wx_msg);
                }
                //获取发消息的人
                WxUser textUser = userRepository.findUserByOpenid(wx_msg.getOpenid());
                if(textUser!=null){
                    //判断发消息的人是否是管理员
                    if(textUser.getIsadmin().equals("0")){//不是管理员就通知管理员
                        String admintext = "\ue142【留言通知】：\n" + wx_msg.getMessagecontent() + "\n" + "——by:<a href=\"www.bigercat.com/quantum/msg/"+textUser.getOpenid()+"\">" + textUser.getNickname()+"</a>";
                        for(WxUser admin:admins){//发消息给每个管理员
                            wechatUtil.sendTextMsg(admin.getOpenid(), admintext);
                        }
                    }
                }

                return messageProcessor.getTextMsg(json_msg.getString("ToUserName"),wx_msg.getOpenid(),defaultText);
            }
            case "image":{
                break;
            }
            case "voice":{
                break;
            }
            case "video":{
                break;
            }
            case "shortvideo":{
                break;
            }
            case "location":{
                break;
            }
            case "link":{
                break;
            }
            case "event":{
                String event=json_msg.getString("Event");
                switch (event){
                    case "subscribe":{ //用户关注
                        String openid=wx_msg.getOpenid();
                        WxUser wx_user=userRepository.findUserByOpenid(openid);
                        if(wx_user!=null){//如果用户存在
                            wx_user.setUserStatus("1");
                        }else{//如果用户不存在
                            JSONObject user=wechatUtil.getUserInfo(openid);
                            wx_user=new WxUser();
                            wx_user.setOpenid(openid);
                            wx_user.setCity(user.getString("city"));
                            wx_user.setCountry(user.getString("country"));
                            wx_user.setHeaderimg(user.getString("headimgurl"));
                            wx_user.setNickname(user.getString("nickname"));
                            wx_user.setProvince(user.getString("province"));
                            wx_user.setSex(user.getString("sex"));
                            wx_user.setUnionid(user.containsKey("unionid")?user.getString("unionid"):"");
                            wx_user.setUserStatus(user.getString("subscribe"));
                            wx_user.setUserTime(user.getTimestamp("subscribe_time"));
                        }
                        wx_user=logService.logUser(wx_user);
                        return messageProcessor.getTextMsg(json_msg.getString("ToUserName"),wx_msg.getOpenid(),subscribe);
                    }
                    case "unsubscribe":{ //用户取消关注
                        String openid=wx_msg.getOpenid();
                        WxUser user=userRepository.findUserByOpenid(openid);
                        if(user!=null){
                            user.setUserStatus("0");
                            userRepository.save(user);
                        }
                        break;
                    }
                    case "CLICK":{//菜单被点击事件
                        String menukey=json_msg.getString("EventKey");
                        WxMenuEventLog m_event=new WxMenuEventLog();
                        m_event.setOpenid(wx_msg.getOpenid());
                        m_event.setEventtype("CLICK");
                        m_event.setEventtime(String.valueOf(new Date().getTime()));
                        m_event.setMenukey(menukey);
                        if(logmenu) {
                            logService.logMenu(m_event);//写日志到数据库
                        }
                        return messageProcessor.getTextMsg(json_msg.getString("ToUserName"),wx_msg.getOpenid(),commingSoon);
                    }
                    case "SCAN":{ //用户扫描二维码
                        break;
                    }
                    case "LOCATION":{ //用户提交位置
                        break;
                    }
                }
                break;
            }
        }

        return null;

    }
}
