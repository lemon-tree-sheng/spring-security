package com.sheng.security.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * Created by shengxingyue on 2017/10/20.
 */
@RestController
@RequestMapping("/order")
public class AsyncController {

    Logger log = LoggerFactory.getLogger(AsyncController.class);

    @GetMapping("/1")//同步处理
    public String syncOrder() throws InterruptedException {
        log.info("主线程开始");
        Thread.sleep(1000);
        log.info("主线程返回");
        return "success";
    }

    /**
     *tomcat 能接收的 http 请求是有限的，如果大量请求都比较耗时，那么 tomcat 的吞吐量会相对低
     *将耗时的业务逻辑单开线程来处理，并由其进行返回，释放 tomcat 线程，增加吞吐量
     */
    @GetMapping("/2")//异步处理
    public Callable<String> asyncOrder() {
        log.info("主线程开始");

        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("副线程开始");
                Thread.sleep(1000);
                log.info("副线程返回");
                return "success";
            }
        };

        log.info("主线程返回");
        return result;
    }
}
