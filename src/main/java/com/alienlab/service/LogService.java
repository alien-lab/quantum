package com.alienlab.service;

import com.alienlab.Repository.MenuLogRespository;
import com.alienlab.Repository.MsgRespository;
import com.alienlab.Repository.UserRepository;
import com.alienlab.entity.WxMenuEventLog;
import com.alienlab.entity.WxUser;
import com.alienlab.entity.WxUserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 橘 on 2016/12/26.
 */
@Component
public class LogService {
    @Autowired
    MsgRespository msgRespository;
    @Autowired
    MenuLogRespository menuLogRespository;
    @Autowired
    UserRepository userRepository;
    public WxUserMessage logMsg(WxUserMessage msg){
        WxUserMessage m=msgRespository.save(msg);
        return m;
    }

    public WxMenuEventLog logMenu(WxMenuEventLog menu){
        WxMenuEventLog m=menuLogRespository.save(menu);
        return m;
    }

    public WxUser logUser(WxUser user){
        WxUser u=userRepository.save(user);
        return u;
    }
}
