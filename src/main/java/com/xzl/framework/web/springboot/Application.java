package com.xzl.framework.web.springboot;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by xuezl on 2018/1/25.
 */
@EnableScheduling
@SpringBootApplication
@EnableSwagger2
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
