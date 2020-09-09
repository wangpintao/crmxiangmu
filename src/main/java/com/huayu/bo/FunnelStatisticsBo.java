package com.huayu.bo;

public class FunnelStatisticsBo {
    //类型名称
    private String typeName;
    //类型成交数量
    private Integer count;
    //成交总金额
    private Integer sum;


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "FunnelStatisticsBo{" +
                "typeName='" + typeName + '\'' +
                ", count=" + count +
                ", sum=" + sum +
                '}';
    }
}
