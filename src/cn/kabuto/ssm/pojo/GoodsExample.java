package cn.kabuto.ssm.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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

        public Criteria andGidIsNull() {
            addCriterion("gid is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gid is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(Integer value) {
            addCriterion("gid =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(Integer value) {
            addCriterion("gid <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(Integer value) {
            addCriterion("gid >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gid >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(Integer value) {
            addCriterion("gid <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(Integer value) {
            addCriterion("gid <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<Integer> values) {
            addCriterion("gid in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<Integer> values) {
            addCriterion("gid not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(Integer value1, Integer value2) {
            addCriterion("gid between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(Integer value1, Integer value2) {
            addCriterion("gid not between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGnameIsNull() {
            addCriterion("gname is null");
            return (Criteria) this;
        }

        public Criteria andGnameIsNotNull() {
            addCriterion("gname is not null");
            return (Criteria) this;
        }

        public Criteria andGnameEqualTo(String value) {
            addCriterion("gname =", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotEqualTo(String value) {
            addCriterion("gname <>", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThan(String value) {
            addCriterion("gname >", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThanOrEqualTo(String value) {
            addCriterion("gname >=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThan(String value) {
            addCriterion("gname <", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThanOrEqualTo(String value) {
            addCriterion("gname <=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLike(String value) {
            addCriterion("gname like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotLike(String value) {
            addCriterion("gname not like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameIn(List<String> values) {
            addCriterion("gname in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotIn(List<String> values) {
            addCriterion("gname not in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameBetween(String value1, String value2) {
            addCriterion("gname between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotBetween(String value1, String value2) {
            addCriterion("gname not between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andNewpriceIsNull() {
            addCriterion("newprice is null");
            return (Criteria) this;
        }

        public Criteria andNewpriceIsNotNull() {
            addCriterion("newprice is not null");
            return (Criteria) this;
        }

        public Criteria andNewpriceEqualTo(BigDecimal value) {
            addCriterion("newprice =", value, "newprice");
            return (Criteria) this;
        }

        public Criteria andNewpriceNotEqualTo(BigDecimal value) {
            addCriterion("newprice <>", value, "newprice");
            return (Criteria) this;
        }

        public Criteria andNewpriceGreaterThan(BigDecimal value) {
            addCriterion("newprice >", value, "newprice");
            return (Criteria) this;
        }

        public Criteria andNewpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("newprice >=", value, "newprice");
            return (Criteria) this;
        }

        public Criteria andNewpriceLessThan(BigDecimal value) {
            addCriterion("newprice <", value, "newprice");
            return (Criteria) this;
        }

        public Criteria andNewpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("newprice <=", value, "newprice");
            return (Criteria) this;
        }

        public Criteria andNewpriceIn(List<BigDecimal> values) {
            addCriterion("newprice in", values, "newprice");
            return (Criteria) this;
        }

        public Criteria andNewpriceNotIn(List<BigDecimal> values) {
            addCriterion("newprice not in", values, "newprice");
            return (Criteria) this;
        }

        public Criteria andNewpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("newprice between", value1, value2, "newprice");
            return (Criteria) this;
        }

        public Criteria andNewpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("newprice not between", value1, value2, "newprice");
            return (Criteria) this;
        }

        public Criteria andOldpriceIsNull() {
            addCriterion("oldprice is null");
            return (Criteria) this;
        }

        public Criteria andOldpriceIsNotNull() {
            addCriterion("oldprice is not null");
            return (Criteria) this;
        }

        public Criteria andOldpriceEqualTo(BigDecimal value) {
            addCriterion("oldprice =", value, "oldprice");
            return (Criteria) this;
        }

        public Criteria andOldpriceNotEqualTo(BigDecimal value) {
            addCriterion("oldprice <>", value, "oldprice");
            return (Criteria) this;
        }

        public Criteria andOldpriceGreaterThan(BigDecimal value) {
            addCriterion("oldprice >", value, "oldprice");
            return (Criteria) this;
        }

        public Criteria andOldpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("oldprice >=", value, "oldprice");
            return (Criteria) this;
        }

        public Criteria andOldpriceLessThan(BigDecimal value) {
            addCriterion("oldprice <", value, "oldprice");
            return (Criteria) this;
        }

        public Criteria andOldpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("oldprice <=", value, "oldprice");
            return (Criteria) this;
        }

        public Criteria andOldpriceIn(List<BigDecimal> values) {
            addCriterion("oldprice in", values, "oldprice");
            return (Criteria) this;
        }

        public Criteria andOldpriceNotIn(List<BigDecimal> values) {
            addCriterion("oldprice not in", values, "oldprice");
            return (Criteria) this;
        }

        public Criteria andOldpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oldprice between", value1, value2, "oldprice");
            return (Criteria) this;
        }

        public Criteria andOldpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oldprice not between", value1, value2, "oldprice");
            return (Criteria) this;
        }

        public Criteria andGdescriptionIsNull() {
            addCriterion("gdescription is null");
            return (Criteria) this;
        }

        public Criteria andGdescriptionIsNotNull() {
            addCriterion("gdescription is not null");
            return (Criteria) this;
        }

        public Criteria andGdescriptionEqualTo(String value) {
            addCriterion("gdescription =", value, "gdescription");
            return (Criteria) this;
        }

        public Criteria andGdescriptionNotEqualTo(String value) {
            addCriterion("gdescription <>", value, "gdescription");
            return (Criteria) this;
        }

        public Criteria andGdescriptionGreaterThan(String value) {
            addCriterion("gdescription >", value, "gdescription");
            return (Criteria) this;
        }

        public Criteria andGdescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("gdescription >=", value, "gdescription");
            return (Criteria) this;
        }

        public Criteria andGdescriptionLessThan(String value) {
            addCriterion("gdescription <", value, "gdescription");
            return (Criteria) this;
        }

        public Criteria andGdescriptionLessThanOrEqualTo(String value) {
            addCriterion("gdescription <=", value, "gdescription");
            return (Criteria) this;
        }

        public Criteria andGdescriptionLike(String value) {
            addCriterion("gdescription like", value, "gdescription");
            return (Criteria) this;
        }

        public Criteria andGdescriptionNotLike(String value) {
            addCriterion("gdescription not like", value, "gdescription");
            return (Criteria) this;
        }

        public Criteria andGdescriptionIn(List<String> values) {
            addCriterion("gdescription in", values, "gdescription");
            return (Criteria) this;
        }

        public Criteria andGdescriptionNotIn(List<String> values) {
            addCriterion("gdescription not in", values, "gdescription");
            return (Criteria) this;
        }

        public Criteria andGdescriptionBetween(String value1, String value2) {
            addCriterion("gdescription between", value1, value2, "gdescription");
            return (Criteria) this;
        }

        public Criteria andGdescriptionNotBetween(String value1, String value2) {
            addCriterion("gdescription not between", value1, value2, "gdescription");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andFlashtimeIsNull() {
            addCriterion("flashtime is null");
            return (Criteria) this;
        }

        public Criteria andFlashtimeIsNotNull() {
            addCriterion("flashtime is not null");
            return (Criteria) this;
        }

        public Criteria andFlashtimeEqualTo(Date value) {
            addCriterion("flashtime =", value, "flashtime");
            return (Criteria) this;
        }

        public Criteria andFlashtimeNotEqualTo(Date value) {
            addCriterion("flashtime <>", value, "flashtime");
            return (Criteria) this;
        }

        public Criteria andFlashtimeGreaterThan(Date value) {
            addCriterion("flashtime >", value, "flashtime");
            return (Criteria) this;
        }

        public Criteria andFlashtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("flashtime >=", value, "flashtime");
            return (Criteria) this;
        }

        public Criteria andFlashtimeLessThan(Date value) {
            addCriterion("flashtime <", value, "flashtime");
            return (Criteria) this;
        }

        public Criteria andFlashtimeLessThanOrEqualTo(Date value) {
            addCriterion("flashtime <=", value, "flashtime");
            return (Criteria) this;
        }

        public Criteria andFlashtimeIn(List<Date> values) {
            addCriterion("flashtime in", values, "flashtime");
            return (Criteria) this;
        }

        public Criteria andFlashtimeNotIn(List<Date> values) {
            addCriterion("flashtime not in", values, "flashtime");
            return (Criteria) this;
        }

        public Criteria andFlashtimeBetween(Date value1, Date value2) {
            addCriterion("flashtime between", value1, value2, "flashtime");
            return (Criteria) this;
        }

        public Criteria andFlashtimeNotBetween(Date value1, Date value2) {
            addCriterion("flashtime not between", value1, value2, "flashtime");
            return (Criteria) this;
        }

        public Criteria andSalestateIsNull() {
            addCriterion("salestate is null");
            return (Criteria) this;
        }

        public Criteria andSalestateIsNotNull() {
            addCriterion("salestate is not null");
            return (Criteria) this;
        }

        public Criteria andSalestateEqualTo(Byte value) {
            addCriterion("salestate =", value, "salestate");
            return (Criteria) this;
        }

        public Criteria andSalestateNotEqualTo(Byte value) {
            addCriterion("salestate <>", value, "salestate");
            return (Criteria) this;
        }

        public Criteria andSalestateGreaterThan(Byte value) {
            addCriterion("salestate >", value, "salestate");
            return (Criteria) this;
        }

        public Criteria andSalestateGreaterThanOrEqualTo(Byte value) {
            addCriterion("salestate >=", value, "salestate");
            return (Criteria) this;
        }

        public Criteria andSalestateLessThan(Byte value) {
            addCriterion("salestate <", value, "salestate");
            return (Criteria) this;
        }

        public Criteria andSalestateLessThanOrEqualTo(Byte value) {
            addCriterion("salestate <=", value, "salestate");
            return (Criteria) this;
        }

        public Criteria andSalestateIn(List<Byte> values) {
            addCriterion("salestate in", values, "salestate");
            return (Criteria) this;
        }

        public Criteria andSalestateNotIn(List<Byte> values) {
            addCriterion("salestate not in", values, "salestate");
            return (Criteria) this;
        }

        public Criteria andSalestateBetween(Byte value1, Byte value2) {
            addCriterion("salestate between", value1, value2, "salestate");
            return (Criteria) this;
        }

        public Criteria andSalestateNotBetween(Byte value1, Byte value2) {
            addCriterion("salestate not between", value1, value2, "salestate");
            return (Criteria) this;
        }

        public Criteria andBuytimeIsNull() {
            addCriterion("buytime is null");
            return (Criteria) this;
        }

        public Criteria andBuytimeIsNotNull() {
            addCriterion("buytime is not null");
            return (Criteria) this;
        }

        public Criteria andBuytimeEqualTo(Date value) {
            addCriterion("buytime =", value, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeNotEqualTo(Date value) {
            addCriterion("buytime <>", value, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeGreaterThan(Date value) {
            addCriterion("buytime >", value, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("buytime >=", value, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeLessThan(Date value) {
            addCriterion("buytime <", value, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeLessThanOrEqualTo(Date value) {
            addCriterion("buytime <=", value, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeIn(List<Date> values) {
            addCriterion("buytime in", values, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeNotIn(List<Date> values) {
            addCriterion("buytime not in", values, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeBetween(Date value1, Date value2) {
            addCriterion("buytime between", value1, value2, "buytime");
            return (Criteria) this;
        }

        public Criteria andBuytimeNotBetween(Date value1, Date value2) {
            addCriterion("buytime not between", value1, value2, "buytime");
            return (Criteria) this;
        }

        public Criteria andUploadstateIsNull() {
            addCriterion("uploadstate is null");
            return (Criteria) this;
        }

        public Criteria andUploadstateIsNotNull() {
            addCriterion("uploadstate is not null");
            return (Criteria) this;
        }

        public Criteria andUploadstateEqualTo(Byte value) {
            addCriterion("uploadstate =", value, "uploadstate");
            return (Criteria) this;
        }

        public Criteria andUploadstateNotEqualTo(Byte value) {
            addCriterion("uploadstate <>", value, "uploadstate");
            return (Criteria) this;
        }

        public Criteria andUploadstateGreaterThan(Byte value) {
            addCriterion("uploadstate >", value, "uploadstate");
            return (Criteria) this;
        }

        public Criteria andUploadstateGreaterThanOrEqualTo(Byte value) {
            addCriterion("uploadstate >=", value, "uploadstate");
            return (Criteria) this;
        }

        public Criteria andUploadstateLessThan(Byte value) {
            addCriterion("uploadstate <", value, "uploadstate");
            return (Criteria) this;
        }

        public Criteria andUploadstateLessThanOrEqualTo(Byte value) {
            addCriterion("uploadstate <=", value, "uploadstate");
            return (Criteria) this;
        }

        public Criteria andUploadstateIn(List<Byte> values) {
            addCriterion("uploadstate in", values, "uploadstate");
            return (Criteria) this;
        }

        public Criteria andUploadstateNotIn(List<Byte> values) {
            addCriterion("uploadstate not in", values, "uploadstate");
            return (Criteria) this;
        }

        public Criteria andUploadstateBetween(Byte value1, Byte value2) {
            addCriterion("uploadstate between", value1, value2, "uploadstate");
            return (Criteria) this;
        }

        public Criteria andUploadstateNotBetween(Byte value1, Byte value2) {
            addCriterion("uploadstate not between", value1, value2, "uploadstate");
            return (Criteria) this;
        }

        public Criteria andGconditionIsNull() {
            addCriterion("gcondition is null");
            return (Criteria) this;
        }

        public Criteria andGconditionIsNotNull() {
            addCriterion("gcondition is not null");
            return (Criteria) this;
        }

        public Criteria andGconditionEqualTo(String value) {
            addCriterion("gcondition =", value, "gcondition");
            return (Criteria) this;
        }

        public Criteria andGconditionNotEqualTo(String value) {
            addCriterion("gcondition <>", value, "gcondition");
            return (Criteria) this;
        }

        public Criteria andGconditionGreaterThan(String value) {
            addCriterion("gcondition >", value, "gcondition");
            return (Criteria) this;
        }

        public Criteria andGconditionGreaterThanOrEqualTo(String value) {
            addCriterion("gcondition >=", value, "gcondition");
            return (Criteria) this;
        }

        public Criteria andGconditionLessThan(String value) {
            addCriterion("gcondition <", value, "gcondition");
            return (Criteria) this;
        }

        public Criteria andGconditionLessThanOrEqualTo(String value) {
            addCriterion("gcondition <=", value, "gcondition");
            return (Criteria) this;
        }

        public Criteria andGconditionLike(String value) {
            addCriterion("gcondition like", value, "gcondition");
            return (Criteria) this;
        }

        public Criteria andGconditionNotLike(String value) {
            addCriterion("gcondition not like", value, "gcondition");
            return (Criteria) this;
        }

        public Criteria andGconditionIn(List<String> values) {
            addCriterion("gcondition in", values, "gcondition");
            return (Criteria) this;
        }

        public Criteria andGconditionNotIn(List<String> values) {
            addCriterion("gcondition not in", values, "gcondition");
            return (Criteria) this;
        }

        public Criteria andGconditionBetween(String value1, String value2) {
            addCriterion("gcondition between", value1, value2, "gcondition");
            return (Criteria) this;
        }

        public Criteria andGconditionNotBetween(String value1, String value2) {
            addCriterion("gcondition not between", value1, value2, "gcondition");
            return (Criteria) this;
        }

        public Criteria andSalereasonIsNull() {
            addCriterion("salereason is null");
            return (Criteria) this;
        }

        public Criteria andSalereasonIsNotNull() {
            addCriterion("salereason is not null");
            return (Criteria) this;
        }

        public Criteria andSalereasonEqualTo(String value) {
            addCriterion("salereason =", value, "salereason");
            return (Criteria) this;
        }

        public Criteria andSalereasonNotEqualTo(String value) {
            addCriterion("salereason <>", value, "salereason");
            return (Criteria) this;
        }

        public Criteria andSalereasonGreaterThan(String value) {
            addCriterion("salereason >", value, "salereason");
            return (Criteria) this;
        }

        public Criteria andSalereasonGreaterThanOrEqualTo(String value) {
            addCriterion("salereason >=", value, "salereason");
            return (Criteria) this;
        }

        public Criteria andSalereasonLessThan(String value) {
            addCriterion("salereason <", value, "salereason");
            return (Criteria) this;
        }

        public Criteria andSalereasonLessThanOrEqualTo(String value) {
            addCriterion("salereason <=", value, "salereason");
            return (Criteria) this;
        }

        public Criteria andSalereasonLike(String value) {
            addCriterion("salereason like", value, "salereason");
            return (Criteria) this;
        }

        public Criteria andSalereasonNotLike(String value) {
            addCriterion("salereason not like", value, "salereason");
            return (Criteria) this;
        }

        public Criteria andSalereasonIn(List<String> values) {
            addCriterion("salereason in", values, "salereason");
            return (Criteria) this;
        }

        public Criteria andSalereasonNotIn(List<String> values) {
            addCriterion("salereason not in", values, "salereason");
            return (Criteria) this;
        }

        public Criteria andSalereasonBetween(String value1, String value2) {
            addCriterion("salereason between", value1, value2, "salereason");
            return (Criteria) this;
        }

        public Criteria andSalereasonNotBetween(String value1, String value2) {
            addCriterion("salereason not between", value1, value2, "salereason");
            return (Criteria) this;
        }

        public Criteria andBuywayIsNull() {
            addCriterion("buyway is null");
            return (Criteria) this;
        }

        public Criteria andBuywayIsNotNull() {
            addCriterion("buyway is not null");
            return (Criteria) this;
        }

        public Criteria andBuywayEqualTo(String value) {
            addCriterion("buyway =", value, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayNotEqualTo(String value) {
            addCriterion("buyway <>", value, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayGreaterThan(String value) {
            addCriterion("buyway >", value, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayGreaterThanOrEqualTo(String value) {
            addCriterion("buyway >=", value, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayLessThan(String value) {
            addCriterion("buyway <", value, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayLessThanOrEqualTo(String value) {
            addCriterion("buyway <=", value, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayLike(String value) {
            addCriterion("buyway like", value, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayNotLike(String value) {
            addCriterion("buyway not like", value, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayIn(List<String> values) {
            addCriterion("buyway in", values, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayNotIn(List<String> values) {
            addCriterion("buyway not in", values, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayBetween(String value1, String value2) {
            addCriterion("buyway between", value1, value2, "buyway");
            return (Criteria) this;
        }

        public Criteria andBuywayNotBetween(String value1, String value2) {
            addCriterion("buyway not between", value1, value2, "buyway");
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