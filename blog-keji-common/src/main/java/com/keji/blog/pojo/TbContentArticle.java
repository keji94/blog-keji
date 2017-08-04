package com.keji.blog.pojo;

import java.util.Date;

public class TbContentArticle {
    private Long articleId;

    private String articleTitle;

    private Integer articleStatus;

    private Integer articleIsTop;

    private Long articleCategoryId;

    private Date articleCreated;

    private Date articleUpdated;

    private String articleContent;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public Integer getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Integer getArticleIsTop() {
        return articleIsTop;
    }

    public void setArticleIsTop(Integer articleIsTop) {
        this.articleIsTop = articleIsTop;
    }

    public Long getArticleCategoryId() {
        return articleCategoryId;
    }

    public void setArticleCategoryId(Long articleCategoryId) {
        this.articleCategoryId = articleCategoryId;
    }

    public Date getArticleCreated() {
        return articleCreated;
    }

    public void setArticleCreated(Date articleCreated) {
        this.articleCreated = articleCreated;
    }

    public Date getArticleUpdated() {
        return articleUpdated;
    }

    public void setArticleUpdated(Date articleUpdated) {
        this.articleUpdated = articleUpdated;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }
}