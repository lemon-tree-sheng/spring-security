package com.sheng.security.web.async;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by shengxingyue on 2017/10/20.
 */
@Component
public class MockQueueListener implements ApplicationListener<ContextRefreshedEvent>{

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // 启动 spring 容器过程中，这个监听器会启动，里面的无限循环会阻塞 spring 容器的启动，故单开一个线程
        new Thread(() -> {
            while (true) {
                String orderNo = mockQueue.getCompleteOrder();
                if (StringUtils.isNotBlank(orderNo)) {
                    logger.info("订单处理完成：orderNo{}", orderNo);
                    deferredResultHolder.getMap().get(orderNo).setResult("place order success");
                    mockQueue.setCompleteOrder(null);
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
