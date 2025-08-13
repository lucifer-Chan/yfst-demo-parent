package com.yfst.demo.domain.mapper;

import com.yfst.demo.domain.entity.CompanyEmployee;
import com.yfst.demo.domain.example.CompanyEmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyEmployeeMapper {
    long countByExample(CompanyEmployeeExample example);

    int deleteByPrimaryKey(Long employeeId);

    int insert(CompanyEmployee record);

    int insertSelective(CompanyEmployee record);

    List<CompanyEmployee> selectByExample(CompanyEmployeeExample example);

    CompanyEmployee selectByPrimaryKey(Long employeeId);

    int updateByExampleSelective(@Param("record") CompanyEmployee record, @Param("example") CompanyEmployeeExample example);

    int updateByExample(@Param("record") CompanyEmployee record, @Param("example") CompanyEmployeeExample example);

    int updateByPrimaryKeySelective(CompanyEmployee record);

    int updateByPrimaryKey(CompanyEmployee record);
}
