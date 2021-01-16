package com.cn.mall.service;

import com.cn.mall.vo.OrderVo;
import com.cn.mall.vo.ResponseVo;

public interface IOrderService {

    ResponseVo<OrderVo> create(Integer uid,Integer shippingId);

}
