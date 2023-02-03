package com.chen.learn.aspect;

import com.chen.learn.annotation.DataSourceAnnotation;
import com.chen.learn.datasource.DynamicDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 类的注释
 *
 * @author chenqiliang
 * @version 1.0
 * 2023/02/03  14:09
 */
@Aspect
@Component
public class DataSourceAspect {

    @Before("within(com.chen.learn.service.impl.*) && @annotation(dataSourceAnnotation)")
    public void before(JoinPoint point, DataSourceAnnotation dataSourceAnnotation){
        DynamicDataSource.threadLocal.set(dataSourceAnnotation.value());
    }

}
