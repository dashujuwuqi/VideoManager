package com.zhiyou.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CourseExample implements Serializable{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCourseTitleIsNull() {
            addCriterion("course_title is null");
            return (Criteria) this;
        }

        public Criteria andCourseTitleIsNotNull() {
            addCriterion("course_title is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTitleEqualTo(String value) {
            addCriterion("course_title =", value, "courseTitle");
            return (Criteria) this;
        }

        public Criteria andCourseTitleNotEqualTo(String value) {
            addCriterion("course_title <>", value, "courseTitle");
            return (Criteria) this;
        }

        public Criteria andCourseTitleGreaterThan(String value) {
            addCriterion("course_title >", value, "courseTitle");
            return (Criteria) this;
        }

        public Criteria andCourseTitleGreaterThanOrEqualTo(String value) {
            addCriterion("course_title >=", value, "courseTitle");
            return (Criteria) this;
        }

        public Criteria andCourseTitleLessThan(String value) {
            addCriterion("course_title <", value, "courseTitle");
            return (Criteria) this;
        }

        public Criteria andCourseTitleLessThanOrEqualTo(String value) {
            addCriterion("course_title <=", value, "courseTitle");
            return (Criteria) this;
        }

        public Criteria andCourseTitleLike(String value) {
            addCriterion("course_title like", value, "courseTitle");
            return (Criteria) this;
        }

        public Criteria andCourseTitleNotLike(String value) {
            addCriterion("course_title not like", value, "courseTitle");
            return (Criteria) this;
        }

        public Criteria andCourseTitleIn(List<String> values) {
            addCriterion("course_title in", values, "courseTitle");
            return (Criteria) this;
        }

        public Criteria andCourseTitleNotIn(List<String> values) {
            addCriterion("course_title not in", values, "courseTitle");
            return (Criteria) this;
        }

        public Criteria andCourseTitleBetween(String value1, String value2) {
            addCriterion("course_title between", value1, value2, "courseTitle");
            return (Criteria) this;
        }

        public Criteria andCourseTitleNotBetween(String value1, String value2) {
            addCriterion("course_title not between", value1, value2, "courseTitle");
            return (Criteria) this;
        }

        public Criteria andCourseDescIsNull() {
            addCriterion("course_desc is null");
            return (Criteria) this;
        }

        public Criteria andCourseDescIsNotNull() {
            addCriterion("course_desc is not null");
            return (Criteria) this;
        }

        public Criteria andCourseDescEqualTo(String value) {
            addCriterion("course_desc =", value, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescNotEqualTo(String value) {
            addCriterion("course_desc <>", value, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescGreaterThan(String value) {
            addCriterion("course_desc >", value, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescGreaterThanOrEqualTo(String value) {
            addCriterion("course_desc >=", value, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescLessThan(String value) {
            addCriterion("course_desc <", value, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescLessThanOrEqualTo(String value) {
            addCriterion("course_desc <=", value, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescLike(String value) {
            addCriterion("course_desc like", value, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescNotLike(String value) {
            addCriterion("course_desc not like", value, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescIn(List<String> values) {
            addCriterion("course_desc in", values, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescNotIn(List<String> values) {
            addCriterion("course_desc not in", values, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescBetween(String value1, String value2) {
            addCriterion("course_desc between", value1, value2, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescNotBetween(String value1, String value2) {
            addCriterion("course_desc not between", value1, value2, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNull() {
            addCriterion("subject_id is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNotNull() {
            addCriterion("subject_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdEqualTo(Integer value) {
            addCriterion("subject_id =", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotEqualTo(Integer value) {
            addCriterion("subject_id <>", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThan(Integer value) {
            addCriterion("subject_id >", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("subject_id >=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThan(Integer value) {
            addCriterion("subject_id <", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("subject_id <=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIn(List<Integer> values) {
            addCriterion("subject_id in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotIn(List<Integer> values) {
            addCriterion("subject_id not in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdBetween(Integer value1, Integer value2) {
            addCriterion("subject_id between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("subject_id not between", value1, value2, "subjectId");
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