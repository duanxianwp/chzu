package cn.edu.chzu.collegetalent.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CtAnswerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CtAnswerExample() {
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

        public Criteria andAnswerIdIsNull() {
            addCriterion("answer_id is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIsNotNull() {
            addCriterion("answer_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdEqualTo(Integer value) {
            addCriterion("answer_id =", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotEqualTo(Integer value) {
            addCriterion("answer_id <>", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThan(Integer value) {
            addCriterion("answer_id >", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("answer_id >=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThan(Integer value) {
            addCriterion("answer_id <", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThanOrEqualTo(Integer value) {
            addCriterion("answer_id <=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIn(List<Integer> values) {
            addCriterion("answer_id in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotIn(List<Integer> values) {
            addCriterion("answer_id not in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdBetween(Integer value1, Integer value2) {
            addCriterion("answer_id between", value1, value2, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("answer_id not between", value1, value2, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeIsNull() {
            addCriterion("answer_type is null");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeIsNotNull() {
            addCriterion("answer_type is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeEqualTo(String value) {
            addCriterion("answer_type =", value, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeNotEqualTo(String value) {
            addCriterion("answer_type <>", value, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeGreaterThan(String value) {
            addCriterion("answer_type >", value, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("answer_type >=", value, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeLessThan(String value) {
            addCriterion("answer_type <", value, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeLessThanOrEqualTo(String value) {
            addCriterion("answer_type <=", value, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeLike(String value) {
            addCriterion("answer_type like", value, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeNotLike(String value) {
            addCriterion("answer_type not like", value, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeIn(List<String> values) {
            addCriterion("answer_type in", values, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeNotIn(List<String> values) {
            addCriterion("answer_type not in", values, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeBetween(String value1, String value2) {
            addCriterion("answer_type between", value1, value2, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerTypeNotBetween(String value1, String value2) {
            addCriterion("answer_type not between", value1, value2, "answerType");
            return (Criteria) this;
        }

        public Criteria andAnswerNameIsNull() {
            addCriterion("answer_name is null");
            return (Criteria) this;
        }

        public Criteria andAnswerNameIsNotNull() {
            addCriterion("answer_name is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerNameEqualTo(String value) {
            addCriterion("answer_name =", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameNotEqualTo(String value) {
            addCriterion("answer_name <>", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameGreaterThan(String value) {
            addCriterion("answer_name >", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameGreaterThanOrEqualTo(String value) {
            addCriterion("answer_name >=", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameLessThan(String value) {
            addCriterion("answer_name <", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameLessThanOrEqualTo(String value) {
            addCriterion("answer_name <=", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameLike(String value) {
            addCriterion("answer_name like", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameNotLike(String value) {
            addCriterion("answer_name not like", value, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameIn(List<String> values) {
            addCriterion("answer_name in", values, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameNotIn(List<String> values) {
            addCriterion("answer_name not in", values, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameBetween(String value1, String value2) {
            addCriterion("answer_name between", value1, value2, "answerName");
            return (Criteria) this;
        }

        public Criteria andAnswerNameNotBetween(String value1, String value2) {
            addCriterion("answer_name not between", value1, value2, "answerName");
            return (Criteria) this;
        }

        public Criteria andQnIdIsNull() {
            addCriterion("qn_id is null");
            return (Criteria) this;
        }

        public Criteria andQnIdIsNotNull() {
            addCriterion("qn_id is not null");
            return (Criteria) this;
        }

        public Criteria andQnIdEqualTo(Integer value) {
            addCriterion("qn_id =", value, "qnId");
            return (Criteria) this;
        }

        public Criteria andQnIdNotEqualTo(Integer value) {
            addCriterion("qn_id <>", value, "qnId");
            return (Criteria) this;
        }

        public Criteria andQnIdGreaterThan(Integer value) {
            addCriterion("qn_id >", value, "qnId");
            return (Criteria) this;
        }

        public Criteria andQnIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("qn_id >=", value, "qnId");
            return (Criteria) this;
        }

        public Criteria andQnIdLessThan(Integer value) {
            addCriterion("qn_id <", value, "qnId");
            return (Criteria) this;
        }

        public Criteria andQnIdLessThanOrEqualTo(Integer value) {
            addCriterion("qn_id <=", value, "qnId");
            return (Criteria) this;
        }

        public Criteria andQnIdIn(List<Integer> values) {
            addCriterion("qn_id in", values, "qnId");
            return (Criteria) this;
        }

        public Criteria andQnIdNotIn(List<Integer> values) {
            addCriterion("qn_id not in", values, "qnId");
            return (Criteria) this;
        }

        public Criteria andQnIdBetween(Integer value1, Integer value2) {
            addCriterion("qn_id between", value1, value2, "qnId");
            return (Criteria) this;
        }

        public Criteria andQnIdNotBetween(Integer value1, Integer value2) {
            addCriterion("qn_id not between", value1, value2, "qnId");
            return (Criteria) this;
        }

        public Criteria andSubjectNumIsNull() {
            addCriterion("subject_num is null");
            return (Criteria) this;
        }

        public Criteria andSubjectNumIsNotNull() {
            addCriterion("subject_num is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectNumEqualTo(Integer value) {
            addCriterion("subject_num =", value, "subjectNum");
            return (Criteria) this;
        }

        public Criteria andSubjectNumNotEqualTo(Integer value) {
            addCriterion("subject_num <>", value, "subjectNum");
            return (Criteria) this;
        }

        public Criteria andSubjectNumGreaterThan(Integer value) {
            addCriterion("subject_num >", value, "subjectNum");
            return (Criteria) this;
        }

        public Criteria andSubjectNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("subject_num >=", value, "subjectNum");
            return (Criteria) this;
        }

        public Criteria andSubjectNumLessThan(Integer value) {
            addCriterion("subject_num <", value, "subjectNum");
            return (Criteria) this;
        }

        public Criteria andSubjectNumLessThanOrEqualTo(Integer value) {
            addCriterion("subject_num <=", value, "subjectNum");
            return (Criteria) this;
        }

        public Criteria andSubjectNumIn(List<Integer> values) {
            addCriterion("subject_num in", values, "subjectNum");
            return (Criteria) this;
        }

        public Criteria andSubjectNumNotIn(List<Integer> values) {
            addCriterion("subject_num not in", values, "subjectNum");
            return (Criteria) this;
        }

        public Criteria andSubjectNumBetween(Integer value1, Integer value2) {
            addCriterion("subject_num between", value1, value2, "subjectNum");
            return (Criteria) this;
        }

        public Criteria andSubjectNumNotBetween(Integer value1, Integer value2) {
            addCriterion("subject_num not between", value1, value2, "subjectNum");
            return (Criteria) this;
        }

        public Criteria andSubjectContentIsNull() {
            addCriterion("subject_content is null");
            return (Criteria) this;
        }

        public Criteria andSubjectContentIsNotNull() {
            addCriterion("subject_content is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectContentEqualTo(String value) {
            addCriterion("subject_content =", value, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentNotEqualTo(String value) {
            addCriterion("subject_content <>", value, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentGreaterThan(String value) {
            addCriterion("subject_content >", value, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentGreaterThanOrEqualTo(String value) {
            addCriterion("subject_content >=", value, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentLessThan(String value) {
            addCriterion("subject_content <", value, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentLessThanOrEqualTo(String value) {
            addCriterion("subject_content <=", value, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentLike(String value) {
            addCriterion("subject_content like", value, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentNotLike(String value) {
            addCriterion("subject_content not like", value, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentIn(List<String> values) {
            addCriterion("subject_content in", values, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentNotIn(List<String> values) {
            addCriterion("subject_content not in", values, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentBetween(String value1, String value2) {
            addCriterion("subject_content between", value1, value2, "subjectContent");
            return (Criteria) this;
        }

        public Criteria andSubjectContentNotBetween(String value1, String value2) {
            addCriterion("subject_content not between", value1, value2, "subjectContent");
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

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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