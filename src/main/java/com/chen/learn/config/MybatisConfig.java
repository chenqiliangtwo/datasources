package com.chen.learn.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.chen.learn.datasource.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;

/**
 * TODO 类描述
 *
 * @version 1.0
 * @auth chenqiliang
 * @date 2023-02-02 22:07
 */
@Configuration
public class MybatisConfig {

    /**
     * 未设置 @Bean name属性时，注入spring容器中的key为方法名 getDataSourceOne
     * 作用位置：注入多数据源使用@Autowired自动注入时会要求@Qualifier指定你需要注入的实例
     * @see DynamicDataSource
     * @return
     */
    @Bean(name = "dataSourceOne")
    @ConfigurationProperties(prefix = "spring.datasource.druid.datasource1")
    public DataSource getDataSourceOne(){
        /**
         * 使用此方法自动生成druidDatasource时需要配置文件与类DruidDataSourceWrapper的注解前缀一致
         * @see com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceWrapper
         */
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "dataSourceTwo")
    @ConfigurationProperties(prefix = "spring.datasource.druid.datasource2")
    public DataSource getDataSourceTwo(){
        /**
         * 使用此方法自动生成druidDatasource时需要配置文件与类DruidDataSourceWrapper的注解前缀一致
         * @see com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceWrapper
         */
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * @see org.mybatis.spring.mapper.MapperScannerConfigurer
     * 自动装配类中自动注入了sqlsessionfactory到spring容器中，只需要提供datasource即可
     */
//    @Bean
//    public SqlSessionFactory getSqlSessionFactory(ApplicationContext context, DynamicDataSource dataSource) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        sqlSessionFactoryBean.setMapperLocations(context.getResources("classpath:mappers/**/*.xml"));
//        return sqlSessionFactoryBean.getObject();
//    }
}
