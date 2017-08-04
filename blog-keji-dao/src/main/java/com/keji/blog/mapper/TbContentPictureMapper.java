package com.keji.blog.mapper;

import com.keji.blog.pojo.TbContentPicture;
import com.keji.blog.pojo.TbContentPictureExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentPictureMapper {
    int countByExample(TbContentPictureExample example);

    int deleteByExample(TbContentPictureExample example);

    int deleteByPrimaryKey(Long pictureId);

    int insert(TbContentPicture record);

    int insertSelective(TbContentPicture record);

    List<TbContentPicture> selectByExample(TbContentPictureExample example);

    TbContentPicture selectByPrimaryKey(Long pictureId);

    int updateByExampleSelective(@Param("record") TbContentPicture record, @Param("example") TbContentPictureExample example);

    int updateByExample(@Param("record") TbContentPicture record, @Param("example") TbContentPictureExample example);

    int updateByPrimaryKeySelective(TbContentPicture record);

    int updateByPrimaryKey(TbContentPicture record);
}