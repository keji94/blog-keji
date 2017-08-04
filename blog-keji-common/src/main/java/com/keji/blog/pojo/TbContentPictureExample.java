package com.keji.blog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbContentPictureExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbContentPictureExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPictureIdIsNull() {
            addCriterion("picture_id is null");
            return (Criteria) this;
        }

        public Criteria andPictureIdIsNotNull() {
            addCriterion("picture_id is not null");
            return (Criteria) this;
        }

        public Criteria andPictureIdEqualTo(Long value) {
            addCriterion("picture_id =", value, "pictureId");
            return (Criteria) this;
        }

        public Criteria andPictureIdNotEqualTo(Long value) {
            addCriterion("picture_id <>", value, "pictureId");
            return (Criteria) this;
        }

        public Criteria andPictureIdGreaterThan(Long value) {
            addCriterion("picture_id >", value, "pictureId");
            return (Criteria) this;
        }

        public Criteria andPictureIdGreaterThanOrEqualTo(Long value) {
            addCriterion("picture_id >=", value, "pictureId");
            return (Criteria) this;
        }

        public Criteria andPictureIdLessThan(Long value) {
            addCriterion("picture_id <", value, "pictureId");
            return (Criteria) this;
        }

        public Criteria andPictureIdLessThanOrEqualTo(Long value) {
            addCriterion("picture_id <=", value, "pictureId");
            return (Criteria) this;
        }

        public Criteria andPictureIdIn(List<Long> values) {
            addCriterion("picture_id in", values, "pictureId");
            return (Criteria) this;
        }

        public Criteria andPictureIdNotIn(List<Long> values) {
            addCriterion("picture_id not in", values, "pictureId");
            return (Criteria) this;
        }

        public Criteria andPictureIdBetween(Long value1, Long value2) {
            addCriterion("picture_id between", value1, value2, "pictureId");
            return (Criteria) this;
        }

        public Criteria andPictureIdNotBetween(Long value1, Long value2) {
            addCriterion("picture_id not between", value1, value2, "pictureId");
            return (Criteria) this;
        }

        public Criteria andPictureNameIsNull() {
            addCriterion("picture_name is null");
            return (Criteria) this;
        }

        public Criteria andPictureNameIsNotNull() {
            addCriterion("picture_name is not null");
            return (Criteria) this;
        }

        public Criteria andPictureNameEqualTo(String value) {
            addCriterion("picture_name =", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameNotEqualTo(String value) {
            addCriterion("picture_name <>", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameGreaterThan(String value) {
            addCriterion("picture_name >", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameGreaterThanOrEqualTo(String value) {
            addCriterion("picture_name >=", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameLessThan(String value) {
            addCriterion("picture_name <", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameLessThanOrEqualTo(String value) {
            addCriterion("picture_name <=", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameLike(String value) {
            addCriterion("picture_name like", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameNotLike(String value) {
            addCriterion("picture_name not like", value, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameIn(List<String> values) {
            addCriterion("picture_name in", values, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameNotIn(List<String> values) {
            addCriterion("picture_name not in", values, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameBetween(String value1, String value2) {
            addCriterion("picture_name between", value1, value2, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureNameNotBetween(String value1, String value2) {
            addCriterion("picture_name not between", value1, value2, "pictureName");
            return (Criteria) this;
        }

        public Criteria andPictureSourceIsNull() {
            addCriterion("picture_source is null");
            return (Criteria) this;
        }

        public Criteria andPictureSourceIsNotNull() {
            addCriterion("picture_source is not null");
            return (Criteria) this;
        }

        public Criteria andPictureSourceEqualTo(String value) {
            addCriterion("picture_source =", value, "pictureSource");
            return (Criteria) this;
        }

        public Criteria andPictureSourceNotEqualTo(String value) {
            addCriterion("picture_source <>", value, "pictureSource");
            return (Criteria) this;
        }

        public Criteria andPictureSourceGreaterThan(String value) {
            addCriterion("picture_source >", value, "pictureSource");
            return (Criteria) this;
        }

        public Criteria andPictureSourceGreaterThanOrEqualTo(String value) {
            addCriterion("picture_source >=", value, "pictureSource");
            return (Criteria) this;
        }

        public Criteria andPictureSourceLessThan(String value) {
            addCriterion("picture_source <", value, "pictureSource");
            return (Criteria) this;
        }

        public Criteria andPictureSourceLessThanOrEqualTo(String value) {
            addCriterion("picture_source <=", value, "pictureSource");
            return (Criteria) this;
        }

        public Criteria andPictureSourceLike(String value) {
            addCriterion("picture_source like", value, "pictureSource");
            return (Criteria) this;
        }

        public Criteria andPictureSourceNotLike(String value) {
            addCriterion("picture_source not like", value, "pictureSource");
            return (Criteria) this;
        }

        public Criteria andPictureSourceIn(List<String> values) {
            addCriterion("picture_source in", values, "pictureSource");
            return (Criteria) this;
        }

        public Criteria andPictureSourceNotIn(List<String> values) {
            addCriterion("picture_source not in", values, "pictureSource");
            return (Criteria) this;
        }

        public Criteria andPictureSourceBetween(String value1, String value2) {
            addCriterion("picture_source between", value1, value2, "pictureSource");
            return (Criteria) this;
        }

        public Criteria andPictureSourceNotBetween(String value1, String value2) {
            addCriterion("picture_source not between", value1, value2, "pictureSource");
            return (Criteria) this;
        }

        public Criteria andPictureStatusIsNull() {
            addCriterion("picture_status is null");
            return (Criteria) this;
        }

        public Criteria andPictureStatusIsNotNull() {
            addCriterion("picture_status is not null");
            return (Criteria) this;
        }

        public Criteria andPictureStatusEqualTo(Integer value) {
            addCriterion("picture_status =", value, "pictureStatus");
            return (Criteria) this;
        }

        public Criteria andPictureStatusNotEqualTo(Integer value) {
            addCriterion("picture_status <>", value, "pictureStatus");
            return (Criteria) this;
        }

        public Criteria andPictureStatusGreaterThan(Integer value) {
            addCriterion("picture_status >", value, "pictureStatus");
            return (Criteria) this;
        }

        public Criteria andPictureStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("picture_status >=", value, "pictureStatus");
            return (Criteria) this;
        }

        public Criteria andPictureStatusLessThan(Integer value) {
            addCriterion("picture_status <", value, "pictureStatus");
            return (Criteria) this;
        }

        public Criteria andPictureStatusLessThanOrEqualTo(Integer value) {
            addCriterion("picture_status <=", value, "pictureStatus");
            return (Criteria) this;
        }

        public Criteria andPictureStatusIn(List<Integer> values) {
            addCriterion("picture_status in", values, "pictureStatus");
            return (Criteria) this;
        }

        public Criteria andPictureStatusNotIn(List<Integer> values) {
            addCriterion("picture_status not in", values, "pictureStatus");
            return (Criteria) this;
        }

        public Criteria andPictureStatusBetween(Integer value1, Integer value2) {
            addCriterion("picture_status between", value1, value2, "pictureStatus");
            return (Criteria) this;
        }

        public Criteria andPictureStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("picture_status not between", value1, value2, "pictureStatus");
            return (Criteria) this;
        }

        public Criteria andPictureSortOrderIsNull() {
            addCriterion("picture_sort_order is null");
            return (Criteria) this;
        }

        public Criteria andPictureSortOrderIsNotNull() {
            addCriterion("picture_sort_order is not null");
            return (Criteria) this;
        }

        public Criteria andPictureSortOrderEqualTo(Integer value) {
            addCriterion("picture_sort_order =", value, "pictureSortOrder");
            return (Criteria) this;
        }

        public Criteria andPictureSortOrderNotEqualTo(Integer value) {
            addCriterion("picture_sort_order <>", value, "pictureSortOrder");
            return (Criteria) this;
        }

        public Criteria andPictureSortOrderGreaterThan(Integer value) {
            addCriterion("picture_sort_order >", value, "pictureSortOrder");
            return (Criteria) this;
        }

        public Criteria andPictureSortOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("picture_sort_order >=", value, "pictureSortOrder");
            return (Criteria) this;
        }

        public Criteria andPictureSortOrderLessThan(Integer value) {
            addCriterion("picture_sort_order <", value, "pictureSortOrder");
            return (Criteria) this;
        }

        public Criteria andPictureSortOrderLessThanOrEqualTo(Integer value) {
            addCriterion("picture_sort_order <=", value, "pictureSortOrder");
            return (Criteria) this;
        }

        public Criteria andPictureSortOrderIn(List<Integer> values) {
            addCriterion("picture_sort_order in", values, "pictureSortOrder");
            return (Criteria) this;
        }

        public Criteria andPictureSortOrderNotIn(List<Integer> values) {
            addCriterion("picture_sort_order not in", values, "pictureSortOrder");
            return (Criteria) this;
        }

        public Criteria andPictureSortOrderBetween(Integer value1, Integer value2) {
            addCriterion("picture_sort_order between", value1, value2, "pictureSortOrder");
            return (Criteria) this;
        }

        public Criteria andPictureSortOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("picture_sort_order not between", value1, value2, "pictureSortOrder");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedIsNull() {
            addCriterion("picture_created is null");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedIsNotNull() {
            addCriterion("picture_created is not null");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedEqualTo(Date value) {
            addCriterion("picture_created =", value, "pictureCreated");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedNotEqualTo(Date value) {
            addCriterion("picture_created <>", value, "pictureCreated");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedGreaterThan(Date value) {
            addCriterion("picture_created >", value, "pictureCreated");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("picture_created >=", value, "pictureCreated");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedLessThan(Date value) {
            addCriterion("picture_created <", value, "pictureCreated");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedLessThanOrEqualTo(Date value) {
            addCriterion("picture_created <=", value, "pictureCreated");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedIn(List<Date> values) {
            addCriterion("picture_created in", values, "pictureCreated");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedNotIn(List<Date> values) {
            addCriterion("picture_created not in", values, "pictureCreated");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedBetween(Date value1, Date value2) {
            addCriterion("picture_created between", value1, value2, "pictureCreated");
            return (Criteria) this;
        }

        public Criteria andPictureCreatedNotBetween(Date value1, Date value2) {
            addCriterion("picture_created not between", value1, value2, "pictureCreated");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedIsNull() {
            addCriterion("picture_updated is null");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedIsNotNull() {
            addCriterion("picture_updated is not null");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedEqualTo(Date value) {
            addCriterion("picture_updated =", value, "pictureUpdated");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedNotEqualTo(Date value) {
            addCriterion("picture_updated <>", value, "pictureUpdated");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedGreaterThan(Date value) {
            addCriterion("picture_updated >", value, "pictureUpdated");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("picture_updated >=", value, "pictureUpdated");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedLessThan(Date value) {
            addCriterion("picture_updated <", value, "pictureUpdated");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("picture_updated <=", value, "pictureUpdated");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedIn(List<Date> values) {
            addCriterion("picture_updated in", values, "pictureUpdated");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedNotIn(List<Date> values) {
            addCriterion("picture_updated not in", values, "pictureUpdated");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedBetween(Date value1, Date value2) {
            addCriterion("picture_updated between", value1, value2, "pictureUpdated");
            return (Criteria) this;
        }

        public Criteria andPictureUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("picture_updated not between", value1, value2, "pictureUpdated");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(Long value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(Long value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(Long value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(Long value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(Long value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<Long> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<Long> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(Long value1, Long value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(Long value1, Long value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}