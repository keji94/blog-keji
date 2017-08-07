package com.keji.blog.mapper;

import com.keji.blog.pojo.BlogCategory;
import com.keji.blog.pojo.BlogCategoryExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogCategoryMapper {
    int countByExample(BlogCategoryExample example);

    int deleteByExample(BlogCategoryExample example);

    int deleteByPrimaryKey(Long categoryId);

    int insert(BlogCategory record);

    int insertSelective(BlogCategory record);

    List<BlogCategory> selectByExample(BlogCategoryExample example);

    BlogCategory selectByPrimaryKey(Long categoryId);

    int updateByExampleSelective(@Param("record") BlogCategory record, @Param("example") BlogCategoryExample example);

    int updateByExample(@Param("record") BlogCategory record, @Param("example") BlogCategoryExample example);

    int updateByPrimaryKeySelective(BlogCategory record);

    int updateByPrimaryKey(BlogCategory record);
}