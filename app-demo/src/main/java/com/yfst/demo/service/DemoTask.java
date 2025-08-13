package com.yfst.demo.service;

import cn.hutool.core.date.DateUtil;
import com.yfst.base.framework.util.lock.DistributedLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description : 分布式锁(需要有redis环境)
 * @author: Lucifer.Chan
 * @date: 2025/8/13 12:01
 */
@Component
@Slf4j
public class DemoTask {

    //8、4 分布式锁
    @Scheduled(cron = "*/3 * * * * *")
    @DistributedLock(key = "DEMO_TEST_LOCK_KEY", seconds = 10L)
    public void doSomething(){
        log.info("现在时刻:{}", DateUtil.now());
    }
}
