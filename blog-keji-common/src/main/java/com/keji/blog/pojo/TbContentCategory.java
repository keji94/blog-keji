package com.keji.blog.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class TbContentCategory {
    private Long id;

    private Long parentId;

    private String name;

    private Integer status;

    private Integer sortOrder;

    private Boolean isParent;

    private Date created;

    private Date updated;

    private String category_url;

}