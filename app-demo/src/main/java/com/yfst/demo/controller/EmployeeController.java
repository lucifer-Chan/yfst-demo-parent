package com.yfst.demo.controller;

import com.yfst.base.framework.auth.ApiAuth;
import com.yfst.base.framework.auth.PermitModel;
import com.yfst.base.framework.context.util.CurrentAuthUserFetcher;
import com.yfst.base.framework.exception.AppException;
import com.yfst.base.framework.pojo.AuthUserInfo;
import com.yfst.base.framework.pojo.user.PcUserbaseInfo;
import com.yfst.base.framework.util.query.mybatis.MBPagedResult;
import com.yfst.demo.domain.entity.CompanyEmployee;
import com.yfst.demo.domain.example.CompanyEmployeeExample;
import com.yfst.demo.domain.mapper.CompanyEmployeeMapper;
import com.yfst.demo.service.DemoService;
import com.yfst.demo.vo.EmployeeQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.yfst.base.framework.context.util.CurrentAuthUserFetcher.fetch;

/**
 * @Description : TODO
 * @author: Lucifer.Chan
 * @date: 2025/8/13 11:14
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private CompanyEmployeeMapper employeeMapper;

    @Autowired
    private DemoService demoService;

    /**
     * 8、1 接口描述@ApiAuth
     * 8、3 分页工具
     * 模糊查询
     * @param param
     *          - pageNum 页码
     *          - pageSize 每页显示数量
     *          - companyId
     *          - name
     *          - phone
     *          - status
     * @return
     */
    @PostMapping("query")
    @ApiAuth(name = "查询企业用户", description = "分页模糊查询,测试用，允许随意访问", model = PermitModel.PERMIT_ALL)
    public MBPagedResult<CompanyEmployee> query(@RequestBody EmployeeQueryParam param) {
        CompanyEmployeeExample example = param.specification(new CompanyEmployeeExample(), true);
        return MBPagedResult.query(employeeMapper, example);
    }

    /**
     * 8、5全局异常处理
     * 抛异常
     * @param param
     * @return
     */
    @PostMapping("error")
    @ApiAuth(name = "测试异常处理", description = "测试用，允许随意访问", model = PermitModel.PERMIT_ALL)
    public List<CompanyEmployee> error(@RequestBody EmployeeQueryParam param){
        throw new AppException("1001", "这是自定义异常信息");
    }

    /**
     * 获取电话号码
     * @param id
     * @return
     */
    @GetMapping("phone")
    @ApiAuth(name = "获取用户的电话号码", description = "测试用")
    public String phone(Long id) {
        return demoService.phone(employeeMapper.selectByPrimaryKey(id));
    }

    @GetMapping("current/userInfo")
    public AuthUserInfo<PcUserbaseInfo> name() {

        AuthUserInfo<PcUserbaseInfo> userInfo = CurrentAuthUserFetcher.fetch();
        return userInfo;
    }
}
