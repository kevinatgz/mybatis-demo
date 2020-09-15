package com.kevin.mybatisdemo.configure;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Data
@Getter
public class EmptyObject implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String msg;
}
