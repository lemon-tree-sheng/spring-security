package com.sheng.security.web.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * Created by shengxingyue on 2017/10/20.
 */
@RestController
@RequestMapping("/order")
public class AsyncController {

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

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
     *将耗时的业务逻辑单开线程（spring异步线程池）来处理，并由其进行返回，释放 tomcat 线程，增加吞吐量
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

    /**
     * deferredResult 使用场景更为灵活，接收请求，处理请求，获取请求结果可以完全解耦
     * @return
     * @throws Exception
     */
    @GetMapping("/3")// 使用 deferredResult
    public DeferredResult<String> deferredResult() throws Exception {
        log.info("主线程开始");

        String orderNo = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNo);

        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNo, result);

        log.info("主线程返回");

        return result;
    }
}
