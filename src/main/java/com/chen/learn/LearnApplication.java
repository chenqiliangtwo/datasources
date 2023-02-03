package com.chen.learn;

import com.chen.learn.config.MybatisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.引入mybatis方案（本项目使用方案1）
 *   方案1：springboot自动装配类MybatisAutoConfiguration 自动装配 MapperScannerConfigurer,限制条件（在mapper接口注解@mapper）
 *   @see org.mybatis.spring.mapper.MapperScannerConfigurer
 *   @see org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration
 *
 *   方案2：启动类加注解 @MapperScan("com.chen.learn.dao")
 *
 *   方案3：配置文件注入bean MapperScannerConfigurer
 *
 *   以上三种都需要配置datasource数据源
 *
 * 2.多数据源设置
 *   问题1：数据源配置@bean时，容器中注入的bean名称问题
 *   @see MybatisConfig
 *
 *   问题2：如果使用@MapperScan 在多数据源时需要指定包名
 *
 *
 */

@SpringBootApplication
public class LearnApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearnApplication.class, args);
    }

}
