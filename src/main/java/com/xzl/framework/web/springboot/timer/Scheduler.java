package com.xzl.framework.web.springboot.timer;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Xuezl on 2018/1/25.
 */
@Component
public class Scheduler {

    private Logger logger = Logger.getLogger(Scheduler.class);

    @Scheduled(cron="0 0/1 * * * ?")
    public void statusCheck() {
        logger.info("定时任务启动:"+new Date());
        //todo something
    }

}
