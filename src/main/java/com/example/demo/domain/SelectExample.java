package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class SelectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SelectExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andSelectAIsNull() {
            addCriterion("select_a is null");
            return (Criteria) this;
        }

        public Criteria andSelectAIsNotNull() {
            addCriterion("select_a is not null");
            return (Criteria) this;
        }

        public Criteria andSelectAEqualTo(String value) {
            addCriterion("select_a =", value, "selectA");
            return (Criteria) this;
        }

        public Criteria andSelectANotEqualTo(String value) {
            addCriterion("select_a <>", value, "selectA");
            return (Criteria) this;
        }

        public Criteria andSelectAGreaterThan(String value) {
            addCriterion("select_a >", value, "selectA");
            return (Criteria) this;
        }

        public Criteria andSelectAGreaterThanOrEqualTo(String value) {
            addCriterion("select_a >=", value, "selectA");
            return (Criteria) this;
        }

        public Criteria andSelectALessThan(String value) {
            addCriterion("select_a <", value, "selectA");
            return (Criteria) this;
        }

        public Criteria andSelectALessThanOrEqualTo(String value) {
            addCriterion("select_a <=", value, "selectA");
            return (Criteria) this;
        }

        public Criteria andSelectALike(String value) {
            addCriterion("select_a like", value, "selectA");
            return (Criteria) this;
        }

        public Criteria andSelectANotLike(String value) {
            addCriterion("select_a not like", value, "selectA");
            return (Criteria) this;
        }

        public Criteria andSelectAIn(List<String> values) {
            addCriterion("select_a in", values, "selectA");
            return (Criteria) this;
        }

        public Criteria andSelectANotIn(List<String> values) {
            addCriterion("select_a not in", values, "selectA");
            return (Criteria) this;
        }

        public Criteria andSelectABetween(String value1, String value2) {
            addCriterion("select_a between", value1, value2, "selectA");
            return (Criteria) this;
        }

        public Criteria andSelectANotBetween(String value1, String value2) {
            addCriterion("select_a not between", value1, value2, "selectA");
            return (Criteria) this;
        }

        public Criteria andSelectBIsNull() {
            addCriterion("select_b is null");
            return (Criteria) this;
        }

        public Criteria andSelectBIsNotNull() {
            addCriterion("select_b is not null");
            return (Criteria) this;
        }

        public Criteria andSelectBEqualTo(String value) {
            addCriterion("select_b =", value, "selectB");
            return (Criteria) this;
        }

        public Criteria andSelectBNotEqualTo(String value) {
            addCriterion("select_b <>", value, "selectB");
            return (Criteria) this;
        }

        public Criteria andSelectBGreaterThan(String value) {
            addCriterion("select_b >", value, "selectB");
            return (Criteria) this;
        }

        public Criteria andSelectBGreaterThanOrEqualTo(String value) {
            addCriterion("select_b >=", value, "selectB");
            return (Criteria) this;
        }

        public Criteria andSelectBLessThan(String value) {
            addCriterion("select_b <", value, "selectB");
            return (Criteria) this;
        }

        public Criteria andSelectBLessThanOrEqualTo(String value) {
            addCriterion("select_b <=", value, "selectB");
            return (Criteria) this;
        }

        public Criteria andSelectBLike(String value) {
            addCriterion("select_b like", value, "selectB");
            return (Criteria) this;
        }

        public Criteria andSelectBNotLike(String value) {
            addCriterion("select_b not like", value, "selectB");
            return (Criteria) this;
        }

        public Criteria andSelectBIn(List<String> values) {
            addCriterion("select_b in", values, "selectB");
            return (Criteria) this;
        }

        public Criteria andSelectBNotIn(List<String> values) {
            addCriterion("select_b not in", values, "selectB");
            return (Criteria) this;
        }

        public Criteria andSelectBBetween(String value1, String value2) {
            addCriterion("select_b between", value1, value2, "selectB");
            return (Criteria) this;
        }

        public Criteria andSelectBNotBetween(String value1, String value2) {
            addCriterion("select_b not between", value1, value2, "selectB");
            return (Criteria) this;
        }

        public Criteria andSelectCIsNull() {
            addCriterion("select_c is null");
            return (Criteria) this;
        }

        public Criteria andSelectCIsNotNull() {
            addCriterion("select_c is not null");
            return (Criteria) this;
        }

        public Criteria andSelectCEqualTo(String value) {
            addCriterion("select_c =", value, "selectC");
            return (Criteria) this;
        }

        public Criteria andSelectCNotEqualTo(String value) {
            addCriterion("select_c <>", value, "selectC");
            return (Criteria) this;
        }

        public Criteria andSelectCGreaterThan(String value) {
            addCriterion("select_c >", value, "selectC");
            return (Criteria) this;
        }

        public Criteria andSelectCGreaterThanOrEqualTo(String value) {
            addCriterion("select_c >=", value, "selectC");
            return (Criteria) this;
        }

        public Criteria andSelectCLessThan(String value) {
            addCriterion("select_c <", value, "selectC");
            return (Criteria) this;
        }

        public Criteria andSelectCLessThanOrEqualTo(String value) {
            addCriterion("select_c <=", value, "selectC");
            return (Criteria) this;
        }

        public Criteria andSelectCLike(String value) {
            addCriterion("select_c like", value, "selectC");
            return (Criteria) this;
        }

        public Criteria andSelectCNotLike(String value) {
            addCriterion("select_c not like", value, "selectC");
            return (Criteria) this;
        }

        public Criteria andSelectCIn(List<String> values) {
            addCriterion("select_c in", values, "selectC");
            return (Criteria) this;
        }

        public Criteria andSelectCNotIn(List<String> values) {
            addCriterion("select_c not in", values, "selectC");
            return (Criteria) this;
        }

        public Criteria andSelectCBetween(String value1, String value2) {
            addCriterion("select_c between", value1, value2, "selectC");
            return (Criteria) this;
        }

        public Criteria andSelectCNotBetween(String value1, String value2) {
            addCriterion("select_c not between", value1, value2, "selectC");
            return (Criteria) this;
        }

        public Criteria andSelectDIsNull() {
            addCriterion("select_d is null");
            return (Criteria) this;
        }

        public Criteria andSelectDIsNotNull() {
            addCriterion("select_d is not null");
            return (Criteria) this;
        }

        public Criteria andSelectDEqualTo(String value) {
            addCriterion("select_d =", value, "selectD");
            return (Criteria) this;
        }

        public Criteria andSelectDNotEqualTo(String value) {
            addCriterion("select_d <>", value, "selectD");
            return (Criteria) this;
        }

        public Criteria andSelectDGreaterThan(String value) {
            addCriterion("select_d >", value, "selectD");
            return (Criteria) this;
        }

        public Criteria andSelectDGreaterThanOrEqualTo(String value) {
            addCriterion("select_d >=", value, "selectD");
            return (Criteria) this;
        }

        public Criteria andSelectDLessThan(String value) {
            addCriterion("select_d <", value, "selectD");
            return (Criteria) this;
        }

        public Criteria andSelectDLessThanOrEqualTo(String value) {
            addCriterion("select_d <=", value, "selectD");
            return (Criteria) this;
        }

        public Criteria andSelectDLike(String value) {
            addCriterion("select_d like", value, "selectD");
            return (Criteria) this;
        }

        public Criteria andSelectDNotLike(String value) {
            addCriterion("select_d not like", value, "selectD");
            return (Criteria) this;
        }

        public Criteria andSelectDIn(List<String> values) {
            addCriterion("select_d in", values, "selectD");
            return (Criteria) this;
        }

        public Criteria andSelectDNotIn(List<String> values) {
            addCriterion("select_d not in", values, "selectD");
            return (Criteria) this;
        }

        public Criteria andSelectDBetween(String value1, String value2) {
            addCriterion("select_d between", value1, value2, "selectD");
            return (Criteria) this;
        }

        public Criteria andSelectDNotBetween(String value1, String value2) {
            addCriterion("select_d not between", value1, value2, "selectD");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
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