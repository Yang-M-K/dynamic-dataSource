package com.ymk.dynamic;

import com.ymk.dynamic.config.DataBaseHolder;
import com.ymk.dynamic.config.DynamicDataSource;
import com.ymk.dynamic.entity.DataBaseEntity;
import com.ymk.dynamic.exception.ServiceException;
import com.ymk.dynamic.repository.DataBaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * mkyoung
 **/
@Slf4j
@Aspect
@Component
public class aspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DynamicDataSource dynamicDataSource;

    @Autowired
    private DataBaseRepository dataBaseRepository;

    @Pointcut("execution(* com.ymk.dynamic.controller.*.*(..))")
    private void around() {}

    @Around("around()")
    public Object before(ProceedingJoinPoint point) throws Throwable {
        logger.info("拦截请求");
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String type = ServletRequestUtils.getRequiredStringParameter(request, "type");
        if(!dynamicDataSource.containsKey(type)){
            DataBaseHolder.clearDataSource();
            DataBaseEntity dataBaseEntity = dataBaseRepository.findById(type).orElseThrow(() -> new ServiceException("数据库类型不存在!"));
            dynamicDataSource.createNewDataBase(dataBaseEntity);
        }
        DataBaseHolder.setDateSourceType(type);
       return point.proceed();
    }
}
