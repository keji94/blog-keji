package com.keji.blog.pojo;

import java.util.Date;

public class TbContentPicture {
    private Long pictureId;

    private String pictureName;

    private String pictureSource;

    private Integer pictureStatus;

    private Integer pictureSortOrder;

    private Date pictureCreated;

    private Date pictureUpdated;

    private Long articleId;

    public Long getPictureId() {
        return pictureId;
    }

    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName == null ? null : pictureName.trim();
    }

    public String getPictureSource() {
        return pictureSource;
    }

    public void setPictureSource(String pictureSource) {
        this.pictureSource = pictureSource == null ? null : pictureSource.trim();
    }

    public Integer getPictureStatus() {
        return pictureStatus;
    }

    public void setPictureStatus(Integer pictureStatus) {
        this.pictureStatus = pictureStatus;
    }

    public Integer getPictureSortOrder() {
        return pictureSortOrder;
    }

    public void setPictureSortOrder(Integer pictureSortOrder) {
        this.pictureSortOrder = pictureSortOrder;
    }

    public Date getPictureCreated() {
        return pictureCreated;
    }

    public void setPictureCreated(Date pictureCreated) {
        this.pictureCreated = pictureCreated;
    }

    public Date getPictureUpdated() {
        return pictureUpdated;
    }

    public void setPictureUpdated(Date pictureUpdated) {
        this.pictureUpdated = pictureUpdated;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
}