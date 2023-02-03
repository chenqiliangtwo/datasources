package com.chen.learn.datasource;

import com.chen.learn.DataSourceTagEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 类的注释
 *
 * @author chenqiliang
 * @version 1.0
 * 2023/02/03  10:51
 */
@Component
@Primary
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Autowired
    @Qualifier(value = "dataSourceOne")
    private DataSource dataSourceOne;

    @Autowired
    @Qualifier(value = "dataSourceTwo")
    private DataSource dataSourceTwo;

    public static ThreadLocal<DataSourceTagEnum> threadLocal = new ThreadLocal<DataSourceTagEnum>();

    @Override
    protected Object determineCurrentLookupKey() {
        return threadLocal.get().getKey();
    }

    @Override
    public void afterPropertiesSet() {
        //添加所有数据源
        Map<Object,Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceTagEnum.DATA_SOURCE_ONE.getKey(),dataSourceOne);
        targetDataSources.put(DataSourceTagEnum.DATA_SOURCE_tWO.getKey(),dataSourceTwo);
        super.setTargetDataSources(targetDataSources);
        //设置默认数据源
        super.setDefaultTargetDataSource(dataSourceOne);
        //执行父类方法
        super.afterPropertiesSet();
    }
}
