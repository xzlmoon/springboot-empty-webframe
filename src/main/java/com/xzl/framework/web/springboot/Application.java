package com.xzl.framework.web.springboot;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;

/**
 * Created by xuezl on 2018/1/25.
 */
public class Application {

    private static Logger logger = Logger.getLogger(Application.class);

    /**
     * Start
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("-----------------------AdApplication start----------------------->");
    }
}
