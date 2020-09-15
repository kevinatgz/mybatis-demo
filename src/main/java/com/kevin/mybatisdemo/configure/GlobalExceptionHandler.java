package com.kevin.mybatisdemo.configure;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 全局异常处理
     */
    @ExceptionHandler
    public Result handleException(HttpServletRequest request, HttpServletResponse response, final Exception e) {
        LOG.error(e.getMessage(), e);
        if (e instanceof AlertException) {//可以在前端Alert的异常
            if (((AlertException) e).getRetCode() != null) {//预定义异常
                return new Result(((AlertException) e).getRetCode());
            } else {
                return new Result(1, e.getMessage() != null ? e.getMessage() : "");
            }
        } else {//其它异常
            if (true) {//如果是正式环境，统一提示
                return Result.failed("RetCode.ERROR");
//                return new Result("RetCode.ERROR");
            } else {//测试环境，alert异常信息
                return new Result(1, StringUtils.isNotBlank(e.getMessage()) ? e.getMessage() : e.toString());
            }
        }
    }

}
