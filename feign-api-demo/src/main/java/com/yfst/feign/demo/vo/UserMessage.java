package com.yfst.feign.demo.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserMessage {

    /**
     * 发送者
     */
    private String from;

    /**
     * 接受者
     */
    private String to;

    /**
     * 消息内容
     */
    private String content;
}
