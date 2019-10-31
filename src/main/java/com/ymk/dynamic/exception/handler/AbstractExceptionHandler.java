package com.ymk.dynamic.exception.handler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

abstract class AbstractExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    protected void error(Throwable e, String message, HttpServletRequest request) {
        logger.error( message,e);
    }

}
