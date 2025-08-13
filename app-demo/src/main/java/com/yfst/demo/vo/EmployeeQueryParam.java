package com.yfst.demo.vo;

import com.yfst.base.framework.util.query.OrderBy;
import com.yfst.base.framework.util.query.ParameterItem;
import com.yfst.base.framework.util.query.mybatis.MBQueryParameterBuilder;
import lombok.Getter;
import lombok.Setter;

import static com.yfst.base.framework.util.query.OrderBy.METHOD.desc;
import static com.yfst.base.framework.util.query.ParameterItem.COMPARE.equal;
import static com.yfst.base.framework.util.query.ParameterItem.COMPARE.like;

/**
 * @Description : 查询参数
 * @author: Lucifer.Chan
 * @date: 2025/8/13 11:17
 * @see com.yfst.demo.domain.entity.CompanyEmployee
 */
@OrderBy(fieldName = "employeeId", method = desc)
@Getter @Setter
public class EmployeeQueryParam extends MBQueryParameterBuilder {

    /**
     * 企业id
     *
     * mappingTo 为实体类里的具体属性名
     *
     */
    @ParameterItem(mappingTo = "companyId", compare = equal)
    private Long companyId;

    /**
     * 姓名
     */
    @ParameterItem(mappingTo = "employeeName", compare = like)
    private String name;

    /**
     * 电话
     */
    @ParameterItem(mappingTo = "employeePhone", compare = like)
    private String phone;

    /**
     * 状态:1-正常,2-离职
     */
    @ParameterItem(mappingTo = "employeeStatus", compare = equal)
    private Integer status;


}
