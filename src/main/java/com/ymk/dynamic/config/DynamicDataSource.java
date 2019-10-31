package com.ymk.dynamic.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ymk.dynamic.entity.DataBaseEntity;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * mkyoung
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private Map<Object, Object> dataSourcesMap;

    public boolean containsKey(String key){
        return dataSourcesMap.containsKey(key);
    }

    public void createNewDataBase(DataBaseEntity dataBaseEntity) {
        logger.info("重新加载dataBase:{}", dataBaseEntity.toString());
        HikariDataSource newDataBase = DataSourceBuilder.create()
                .url(dataBaseEntity.getUrl())
                .password(dataBaseEntity.getPassword())
                .driverClassName(dataBaseEntity.getDriver())
                .username(dataBaseEntity.getUsername())
                .type(HikariDataSource.class)
                .build();

        dataSourcesMap.put(dataBaseEntity.getId(),newDataBase);
        setTargetDataSources(dataSourcesMap);
        super.afterPropertiesSet();
    }

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);
        dataSourcesMap = targetDataSources;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String type = DataBaseHolder.getDateSourceType();
        if(this.containsKey(type)){
            logger.info("使用数据源"+type);
        }else{
            logger.info("数据源:{}不存在，使用主数据源"+type);
        }
        return type;
    }

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
    }
}
