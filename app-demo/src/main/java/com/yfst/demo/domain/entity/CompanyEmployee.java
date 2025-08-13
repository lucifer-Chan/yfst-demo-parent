package com.yfst.demo.domain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * 员工
 * demo_company_employee(`employee_id`)
 * 
 * @author Mybatis Generator
 * @create 2025-08-13 11:13:49
 */
@Getter @Setter
public class CompanyEmployee implements Serializable {
    /**
     * 主键-员工id
     * `employee_id` BIGINT(19) not null auto_increment
     */
    private Long employeeId;

    /**
     * 企业id
     * `company_id` BIGINT(19) not null
     */
    private Long companyId;

    /**
     * 姓名
     * `employee_name` VARCHAR(20) not null
     */
    private String employeeName;

    /**
     * 电话
     * `employee_phone` VARCHAR(20) not null
     */
    private String employeePhone;

    /**
     * 状态:1-正常,2-离职
     * `employee_status` INTEGER(10) not null
     */
    private Integer employeeStatus;

    /**
     * 累计充值金额（单位：元）
     * `total_recharge_amount` DOUBLE(10) not null
     */
    private Double totalRechargeAmount;

    /**
     * 累计赠送金额（单位：元）
     * `total_give_amount` DOUBLE(10) not null
     */
    private Double totalGiveAmount;

    /**
     * 创建时间
     * `create_time` TIMESTAMP(19)
     */
    private Date createTime;

    /**
     * 创建人id
     * `create_user_id` BIGINT(19)
     */
    private Long createUserId;

    /**
     * 最后更新时间
     * `update_time` TIMESTAMP(19)
     */
    private Date updateTime;

    /**
     * 最后更新人
     * `update_user_id` BIGINT(19)
     */
    private Long updateUserId;

    /**
     * 删除时间
     * `delete_time` TIMESTAMP(19)
     */
    private Date deleteTime;

    /**
     * 删除人
     * `delete_user_id` BIGINT(19)
     */
    private Long deleteUserId;

    private static final long serialVersionUID = 1L;
}