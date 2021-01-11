package com.cn.mall.service;

import com.cn.mall.vo.ProductDetailVo;
import com.cn.mall.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

public interface IProductService {

    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> detail(Integer productId);



}
