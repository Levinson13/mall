package com.cn.mall.service;

import com.cn.mall.vo.OrderVo;
import com.cn.mall.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

public interface IOrderService {

    ResponseVo<OrderVo> create(Integer uid,Integer shippingId);

    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);

    ResponseVo<OrderVo> detail(Integer uid, Long orderNo);

    ResponseVo cancel(Integer uid, Long orderNo);

}
