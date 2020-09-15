package com.kevin.mybatisdemo.configure;
//https://blog.csdn.net/qq_37170583/article/details/107470337 SpringBoot 使用 beforeBodyWrite 实现统一的接口返回类型

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class WebAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        ////            if (body instanceof String) {
////                ObjectMapper om = new ObjectMapper();
////                return om.writeValueAsString(Result.success(body));
////            }
        if (body instanceof Result) {
            return body;
        }
        if (body instanceof List) {
            return Result.successList(new EmptyObject(),body);
        }

        return Result.success(body);
    }
}