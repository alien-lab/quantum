package com.alienlab.Repository;

import com.alienlab.entity.WxUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 橘 on 2016/12/27.
 */
public interface UserRepository extends JpaRepository<WxUser,Long> {
    public WxUser findUserByOpenid(String openid);
    public List<WxUser> findUserByIsadmin(String isadmin);
}
