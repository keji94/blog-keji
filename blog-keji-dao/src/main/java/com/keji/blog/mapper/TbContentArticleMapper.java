package com.keji.blog.mapper;

import com.keji.blog.pojo.TbContentArticle;
import com.keji.blog.pojo.TbContentArticleExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentArticleMapper {
    int countByExample(TbContentArticleExample example);

    int deleteByExample(TbContentArticleExample example);

    int deleteByPrimaryKey(Long articleId);

    int insert(TbContentArticle record);

    int insertSelective(TbContentArticle record);

    List<TbContentArticle> selectByExampleWithBLOBs(TbContentArticleExample example);

    List<TbContentArticle> selectByExample(TbContentArticleExample example);

    TbContentArticle selectByPrimaryKey(Long articleId);

    int updateByExampleSelective(@Param("record") TbContentArticle record, @Param("example") TbContentArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") TbContentArticle record, @Param("example") TbContentArticleExample example);

    int updateByExample(@Param("record") TbContentArticle record, @Param("example") TbContentArticleExample example);

    int updateByPrimaryKeySelective(TbContentArticle record);

    int updateByPrimaryKeyWithBLOBs(TbContentArticle record);

    int updateByPrimaryKey(TbContentArticle record);
}