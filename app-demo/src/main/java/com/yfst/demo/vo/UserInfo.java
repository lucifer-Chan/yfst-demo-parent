package com.yfst.demo.vo;


import lombok.Getter;
import lombok.Setter;

/**
 * @Description : TODO
 * @author: Lucifer.Chan
 * @date: 2025/8/15 16:14
 */
@Getter @Setter
public class UserInfo {

    private Long userId;

    private String userName;

    private int age;

    public UserInfo() {}

    public UserInfo(Long userId, String userName, int age) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
    }
}
