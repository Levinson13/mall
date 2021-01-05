package com.cn.mall.pojo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Category implements Serializable {

    private Integer id;

    private Integer parentId;

    private String name;

    private Integer status;

    private Integer sortOrder;

    private Date createTime;

    private Date updateTime;

}
