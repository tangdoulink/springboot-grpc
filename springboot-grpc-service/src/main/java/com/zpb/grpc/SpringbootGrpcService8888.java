package com.zpb.grpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

/**
 * @author       pengbo.zhao
 * @description  主启动类
 * @createDate   2021/12/14 18:19
 * @updateDate   2021/12/14 18:19
 * @version      1.0
 */
@SpringBootApplication
public class SpringbootGrpcService8888 {

    public static void main(String[] args) throws InterruptedException {

        SpringApplication.run(SpringbootGrpcService8888.class,args);

        new CountDownLatch(1).await();
    }

}
