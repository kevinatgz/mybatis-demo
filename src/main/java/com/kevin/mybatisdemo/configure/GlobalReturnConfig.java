package com.kevin.mybatisdemo.configure;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 全局返回值统一封装
 */
//@EnableWebMvc
//@Configuration
public class GlobalReturnConfig {
//
//    @RestControllerAdvice
//    @Slf4j
//    static class ResultResponseAdvice implements ResponseBodyAdvice<Object> {
//        @Override
//        public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
//            return true;
//        }
//
////        @SneakyThrows
//        @Override
//        public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType,
//                                      Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
////            if (body instanceof String) {
////                ObjectMapper om = new ObjectMapper();
////                return om.writeValueAsString(Result.success(body));
////            }
//            if (body instanceof Result) {
//                return body;
//            }
//            return Result.success(body);
////            return new Result(body);
//        }
//    }
}