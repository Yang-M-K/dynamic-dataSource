package com.ymk.dynamic.config;

import com.ymk.dynamic.entity.DataBaseEntity;
import com.ymk.dynamic.repository.DataBaseRepository;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j2;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * mkyoung
 **/
@Log4j2
public class DataBaseHolder {

    private static final ThreadLocal<String> holder = new ThreadLocal<>();

    public static void setDateSourceType(String type){
        holder.set(type);
    }

    public static String getDateSourceType(){
        return holder.get();
    }

    public static void clearDataSource() {
        holder.remove();
        log.info("已切换到主数据源");
    }

}
