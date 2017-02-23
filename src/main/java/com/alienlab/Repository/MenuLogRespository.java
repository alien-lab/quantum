package com.alienlab.Repository;

import com.alienlab.entity.WxMenuEventLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 橘 on 2016/12/27.
 */
public interface MenuLogRespository extends JpaRepository<WxMenuEventLog,Long> {

}
