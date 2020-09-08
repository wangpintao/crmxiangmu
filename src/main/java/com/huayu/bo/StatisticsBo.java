package com.huayu.bo;

public class StatisticsBo {
    //用户名
    private String username;
    //总数
    private Integer count;
    //周商机数
    private Integer com_count;
    //上周商机数
    private Integer com_last_coutn;
    //跟单数
    private Integer doc_count;
    //上周跟单数
    private Integer doc_last_coutn;
    //成交数
    private Integer succ_count;
    //上周成交数
    private Integer succ_last_coutn;
    //合同数
    private Integer con_count;
    //上周合同数
    private Integer con_last_coutn;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCom_count() {
        return com_count;
    }

    public void setCom_count(Integer com_count) {
        this.com_count = com_count;
    }

    public Integer getCom_last_coutn() {
        return com_last_coutn;
    }

    public void setCom_last_coutn(Integer com_last_coutn) {
        this.com_last_coutn = com_last_coutn;
    }

    public Integer getDoc_count() {
        return doc_count;
    }

    public void setDoc_count(Integer doc_count) {
        this.doc_count = doc_count;
    }

    public Integer getDoc_last_coutn() {
        return doc_last_coutn;
    }

    public void setDoc_last_coutn(Integer doc_last_coutn) {
        this.doc_last_coutn = doc_last_coutn;
    }

    public Integer getSucc_count() {
        return succ_count;
    }

    public void setSucc_count(Integer succ_count) {
        this.succ_count = succ_count;
    }

    public Integer getSucc_last_coutn() {
        return succ_last_coutn;
    }

    public void setSucc_last_coutn(Integer succ_last_coutn) {
        this.succ_last_coutn = succ_last_coutn;
    }

    public Integer getCon_count() {
        return con_count;
    }

    public void setCon_count(Integer con_count) {
        this.con_count = con_count;
    }

    public Integer getCon_last_coutn() {
        return con_last_coutn;
    }

    public void setCon_last_coutn(Integer con_last_coutn) {
        this.con_last_coutn = con_last_coutn;
    }

    @Override
    public String toString() {
        return "StatisticsBo{" +
                "username='" + username + '\'' +
                ", count=" + count +
                ", com_count=" + com_count +
                ", com_last_coutn=" + com_last_coutn +
                ", doc_count=" + doc_count +
                ", doc_last_coutn=" + doc_last_coutn +
                ", succ_count=" + succ_count +
                ", succ_last_coutn=" + succ_last_coutn +
                ", con_count=" + con_count +
                ", con_last_coutn=" + con_last_coutn +
                '}';
    }
}
