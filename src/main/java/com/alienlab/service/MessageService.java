package com.alienlab.service;

import com.alienlab.Repository.MsgRespository;
import com.alienlab.entity.WxUserMessage;
import com.alienlab.entity.dto.MsgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * Created by 橘 on 2016/12/30.
 */
@Component
public class MessageService {
    @Autowired
    MsgRespository msgRespository;
    @PersistenceUnit
    private EntityManagerFactory emf;
    public Page<WxUserMessage> getAllLatestMessage(int index,int length){
//        int start=(index-1)*length+1;
//        EntityManager em = emf.createEntityManager();
//        Page<MsgDto> msglist = (Page<MsgDto>)em.createNativeQuery(
//                "SELECT a.* FROM wx_user_message a,\n" +
//                        " (SELECT openid,MAX(messagetime) msgtime FROM wx_user_message GROUP BY openid) b\n" +
//                        " WHERE a.`Openid`=b.openid AND a.`Messagetime`=b.msgtime limit "+start+","+length ,
//                WxUserMessage.class)
//                .getResultList();
//        return msglist;
        return msgRespository.findMsgsInNativeQueryWithPagination(new PageRequest(1,2));
    }
}
