package com.yfst.demo.service;

import com.yfst.base.framework.util.trace.TraceNode;
import com.yfst.demo.domain.entity.CompanyEmployee;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Description : TODO
 * @author: Lucifer.Chan
 * @date: 2025/8/13 12:17
 */
@Service
public class DemoService {

    //8、2 日志管理-流程日志
    @TraceNode("获取用户的手机号码")
    public String phone(CompanyEmployee employee) {
        return Optional.ofNullable(employee)
                .map(CompanyEmployee::getEmployeePhone)
                .orElse("110");
    }
}
