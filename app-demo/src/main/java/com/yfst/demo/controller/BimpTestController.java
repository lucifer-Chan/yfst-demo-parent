package com.yfst.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.yfst.base.framework.advice.AbsoluteReturn;
import com.yfst.feign.bimp.api.SysRoleApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description : TODO
 * @author: Lucifer.Chan
 * @date: 2025/8/17 13:06
 */
@AbsoluteReturn
@RestController
@RequestMapping("bimp")
public class BimpTestController {

    @Autowired
    private SysRoleApi sysRoleApi;

    /**
     * 测试内部RPC调用BIMP的功能
     * @param param
     * @return
     */
    @PostMapping("role")
    public JSONObject role(@RequestBody JSONObject param){
        String result = sysRoleApi.query(param);
        return JSONObject.parseObject(result);
    }
}
