package com.cn.mall.service.impl;


import com.cn.mall.MallApplicationTests;
import com.cn.mall.dao.ShippingMapper;
import com.cn.mall.enums.ResponseEnum;
import com.cn.mall.form.ShippingForm;
import com.cn.mall.service.IShippingService;
import com.cn.mall.vo.ResponseVo;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Slf4j
public class ShippingServiceImplTest extends MallApplicationTests {

    @Autowired
    private IShippingService shippingService;

    private Integer uid = 1;

    @Test
    public void add() {
        ShippingForm form = new ShippingForm();
        form.setReceiverName("廖师兄");
        form.setReceiverAddress("慕课网");
        form.setReceiverCity("北京");
        form.setReceiverDistrict("北京");
        form.setReceiverMobile("1854564851256");
        form.setReceiverPhone("15015045035");
        form.setReceiverProvince("海淀区");
        form.setReceiverZip("000000");
        ResponseVo<Map<String, Integer>> responseVo = shippingService.add(uid, form);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void delete() {
        Integer shippingId = 7;
        ResponseVo<Map<String, Integer>> responseVo = shippingService.delete(uid, shippingId);
        log.info("result = {}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void update() {
        ShippingForm form = new ShippingForm();
        form.setReceiverName("廖师兄");
        form.setReceiverAddress("慕课网");
        form.setReceiverCity("福建");
        form.setReceiverDistrict("北京");
        form.setReceiverMobile("1854564851256");
        form.setReceiverPhone("15015045035");
        form.setReceiverProvince("海淀区");
        form.setReceiverZip("000000");
        ResponseVo<Map<String, Integer>> responseVo = shippingService.update(uid, 6, form);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void list() {
        ResponseVo<PageInfo> list = shippingService.list(1,1,10);
        log.info("result = {}", list);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),list.getStatus());
    }
}
