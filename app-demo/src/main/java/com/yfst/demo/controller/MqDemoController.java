package com.yfst.demo.controller;


import com.yfst.base.framework.util.mq.RocketMQUtil;
import com.yfst.demo.service.DemoService;
import com.yfst.demo.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Description : 8、13 生产端使用com.yfst.base.framework.util.mq.RocketMQUtil发送消息
 * @author: Lucifer.Chan
 * @date: 2025/8/15 16:19
 */
@RestController
@RequestMapping("mq")
public class MqDemoController {

    @Autowired
    private RocketMQUtil rocketMQUtil;

    /**
     * 发送消息
     * @return
     */
    @GetMapping("send/one")
    public String sendMsg() {
        UserInfo userInfo = new UserInfo(1L, "yfst", 11);
        rocketMQUtil.send("DEMO_TOPIC", userInfo);
        return "success";
    }

    /**
     * 发送列表消息
     * @return
     */
    @GetMapping("send/list")
    public String sendMsg2() {
        List<UserInfo> payload = Arrays.asList(
                new UserInfo(1L, "name1", 11),
                new UserInfo(2L, "name2", 12),
                new UserInfo(3L, "name2", 12)
        );
        rocketMQUtil.send("DEMO_TOPIC", payload);
        return "success";
    }
}

