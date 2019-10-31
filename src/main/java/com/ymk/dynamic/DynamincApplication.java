package com.ymk.dynamic;

import com.ymk.dynamic.config.DynamicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * mkyoung
 **/
@SpringBootApplication
public class DynamincApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamincApplication.class,args);
    }

    @Primary
    @Bean("defaultDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        // 配置数据源（注意，我使用的是 HikariCP 连接池），以上注解是指定数据源，否则会有冲突
        return DataSourceBuilder.create().build();
    }

//    @Bean("database2")
//    public DataSource database2() {
//        // 配置数据源（注意，我使用的是 HikariCP 连接池），以上注解是指定数据源，否则会有冲突
//        return DataSourceBuilder.create()
//                .url("jdbc:mysql://127.0.0.1:3306/dynamic2?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT")
//                .password("1234")
//                .driverClassName("com.mysql.cj.jdbc.Driver")
//                .username("root")
//                .type(HikariDataSource.class)
//                .build();
//    }


    @Bean(name = "dynamicDataSource")
    public DynamicDataSource routingDataSource(@Qualifier("defaultDataSource") DataSource defaultDataSource) {
        DynamicDataSource proxy = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("defaultDataSource", defaultDataSource);

        proxy.setDefaultTargetDataSource(defaultDataSource);
        proxy.setTargetDataSources(targetDataSources);
        return proxy;
    }

}
