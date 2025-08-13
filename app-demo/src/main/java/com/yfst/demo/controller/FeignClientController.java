package com.yfst.demo.controller;

import com.yfst.base.framework.auth.ApiAuth;
import com.yfst.base.framework.pojo.ResponseResult;
import com.yfst.feign.demo.api.MessageHandler;
import com.yfst.feign.demo.vo.UserMessage;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description : TODO
 * @author: Lucifer.Chan
 * @date: 2025/8/13 12:36
 */
@RestController
@RequestMapping
public class FeignClientController implements MessageHandler {

    /**
     * 测试
     * @param userMessage
     * @return
     */
    @Override
    @ApiAuth(name = "发送消息", description = "测试发送消息,Controller接口")
    public ResponseResult<String> sent(UserMessage userMessage) {
        String from = userMessage.getFrom();
        Assert.isTrue(!"abc".equals(from), "错误的from");
        String data = userMessage.getFrom() + "->" + userMessage.getTo() + ":" + userMessage.getContent();
        return ResponseResult.success(data);
    }
}
