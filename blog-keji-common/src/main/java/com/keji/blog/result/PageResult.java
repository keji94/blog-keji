package com.keji.blog.result;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wb-ny291824 on 2017/8/4.
 */
@Data
public class PageResult implements Serializable{
    protected Long total;
    protected List<?> rows;

    public  PageResult(){

    }
    public PageResult(Long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    //设置分页信息
    public  void setPageInfo(long total,List<?> rows) {
        this.setTotal(total);
        this.setRows(rows);
    }
}
