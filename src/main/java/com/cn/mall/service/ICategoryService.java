package com.cn.mall.service;

import com.cn.mall.vo.CategoryVo;
import com.cn.mall.vo.ResponseVo;

import java.util.List;

public interface ICategoryService {

    ResponseVo<List<CategoryVo>> selectAll();

}
