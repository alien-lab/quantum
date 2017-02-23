package com.alienlab.controller;

import com.alienlab.entity.WxUser;
import com.alienlab.entity.WxUserMessage;
import com.alienlab.entity.dto.MsgDto;
import com.alienlab.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * Created by 橘 on 2016/12/30.
 */
@RestController
public class MsgController {
    @Autowired
    MessageService messageService;
    @RequestMapping(value="/msg/latest",method= RequestMethod.GET)
    public Page<WxUserMessage> getMsgAll(){
        return messageService.getAllLatestMessage(1,2);
    }
}
