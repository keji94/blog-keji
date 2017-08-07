package com.keji.blog.mapper;

import com.keji.blog.pojo.BlogHits;
import com.keji.blog.pojo.BlogHitsExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogHitsMapper {
    int countByExample(BlogHitsExample example);

    int deleteByExample(BlogHitsExample example);

    int deleteByPrimaryKey(Long hitsId);

    int insert(BlogHits record);

    int insertSelective(BlogHits record);

    List<BlogHits> selectByExample(BlogHitsExample example);

    BlogHits selectByPrimaryKey(Long hitsId);

    int updateByExampleSelective(@Param("record") BlogHits record, @Param("example") BlogHitsExample example);

    int updateByExample(@Param("record") BlogHits record, @Param("example") BlogHitsExample example);

    int updateByPrimaryKeySelective(BlogHits record);

    int updateByPrimaryKey(BlogHits record);
}