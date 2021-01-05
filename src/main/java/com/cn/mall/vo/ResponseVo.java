package com.cn.mall.vo;

import com.cn.mall.enums.ResponseEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseVo<T> {

    private Integer status;

    private String msg;

    private T data;

    public ResponseVo(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public static <T> ResponseVo<T> success(String msg) {
        return new ResponseVo<T>(ResponseEnum.SUCCESS.getCode(), msg);
    }

    public static <T> ResponseVo<T> success() {
        return new ResponseVo<T>(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getDesc());
    }

    public static <T> ResponseVo<T> error(ResponseEnum responseEnum) {
        return new ResponseVo<T>(responseEnum.getCode(), responseEnum.getDesc());
    }
}
