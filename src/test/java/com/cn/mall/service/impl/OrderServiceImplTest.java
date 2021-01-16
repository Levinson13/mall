package com.cn.mall.service.impl;

import com.cn.mall.MallApplicationTests;
import com.cn.mall.enums.ResponseEnum;
import com.cn.mall.service.IOrderService;
import com.cn.mall.vo.OrderVo;
import com.cn.mall.vo.ResponseVo;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class OrderServiceImplTest extends MallApplicationTests {

    @Autowired
    private IOrderService orderService;

    private Integer uid = 1;

    private Integer shippingId = 6;

    private Gson gson = new Gson();
    @Test
    public void create() {
        ResponseVo<OrderVo> responseVo = orderService.create(uid, shippingId);
        log.info("result = {}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }
}
