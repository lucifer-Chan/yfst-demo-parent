package com.yfst.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Description : TODO
 * @author: Lucifer.Chan
 * @date: 2025/8/13 11:23
 */
@Configuration
@EnableScheduling
@MapperScan(basePackages = "com.yfst.demo.domain.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class AppConfig {

}
