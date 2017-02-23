package com.alienlab.Repository;

import com.alienlab.controller.Wechat;
import com.alienlab.entity.WxUser;
import com.alienlab.entity.WxUserMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by 橘 on 2016/12/26.
 */
public interface MsgRespository extends JpaRepository<WxUserMessage,Long> {
    Page<WxUserMessage> findMessageByOpenid(String openid,Pageable pg);

    @Query(
            value = "SELECT a.* FROM wx_user_message a,(SELECT openid,MAX(messagetime) msgtime FROM wx_user_message GROUP BY openid) b WHERE a.`Openid`=b.openid AND a.`Messagetime`=b.msgtime limit ?#{#pageable.offset-1},?#{#pageable.pageSize}",
            countQuery = "SELECT count(1) FROM wx_user_message a,(SELECT openid,MAX(messagetime) msgtime FROM wx_user_message GROUP BY openid) b WHERE a.`Openid`=b.openid AND a.`Messagetime`=b.msgtime", nativeQuery = true)
    Page<WxUserMessage> findMsgsInNativeQueryWithPagination(Pageable pageable);
}
