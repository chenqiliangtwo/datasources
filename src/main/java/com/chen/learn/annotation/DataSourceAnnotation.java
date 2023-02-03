package com.chen.learn.annotation;

import com.chen.learn.DataSourceTagEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类的注释
 *
 * @author chenqiliang
 * @version 1.0
 * 2023/02/03  14:07
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSourceAnnotation {
    DataSourceTagEnum value();
}
