package com.yfst.demo.service;


import com.yfst.base.framework.util.mq.support.MqReceive;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @Description : mq消费
 * @author: Lucifer.Chan
 * @date: 2025/8/15 16:14
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "DEMO_TOPIC", consumerGroup = "Test")
public class MqListener implements RocketMQListener<MessageExt> {

    /**
     * 8、13 消费端onMessage方法加@MqReceive
     * @param messageExt
     */
    @MqReceive
    @Override
    public void onMessage(MessageExt messageExt) {

        String json = new String(messageExt.getBody());

        log.info("收到消息:{}", json);


    }
}
