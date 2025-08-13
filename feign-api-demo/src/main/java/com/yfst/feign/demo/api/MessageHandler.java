package com.yfst.feign.demo.api;

import com.yfst.base.framework.auth.ApiAuth;
import com.yfst.base.framework.pojo.ResponseResult;
import com.yfst.feign.demo.vo.UserMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.yfst.base.framework.auth.PermitModel.PERMIT_LOGIN;

@RequestMapping("message")
@FeignClient(value = "${com.yfst.feign.gateway-name:app-base-gateway}", contextId = "MessageHandler", url = "${com.yfst.feign.gateway.uri}")
public interface MessageHandler {
    /**
     * 发送消息
     * @param userMessage
     */
    @PostMapping("sent")
    @ApiAuth(name = "发送消息", description = "测试发送消息,Feign接口", model = PERMIT_LOGIN)
    ResponseResult<String> sent(@RequestBody UserMessage userMessage);
}
