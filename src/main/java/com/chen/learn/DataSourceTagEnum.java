package com.chen.learn;

/**
 * 类的注释
 *
 * @author chenqiliang
 * @version 1.0
 * 2023/02/03  11:09
 */
public enum DataSourceTagEnum {

    DATA_SOURCE_ONE("ONE"),
    DATA_SOURCE_tWO("tWO");

    DataSourceTagEnum(String key) {
        this.key = key;
    }

    private final String key;

    public String getKey() {
        return key;
    }
}
