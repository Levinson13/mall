package com.cn.mall.dao;

import com.cn.mall.pojo.Category;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

//@Mapper
public interface CategoryMapper {

    @Select("select * from mall_category where id = #{id}")
    Category findById(@RequestParam("id") Integer id);

    Category queryById(Integer id);
}
