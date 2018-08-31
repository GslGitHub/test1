package com.ssmm.model;

public class ymxCommodityBatch {
    private  String id;
    private  String commodityId;
    private  double batchPrice;
    private  Integer num;
    private  double yunfei;
    private  double sumPrice;
    private  double sumYunfei;

    public double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public double getSumYunfei() {
        return sumYunfei;
    }

    public void setSumYunfei(double sumYunfei) {
        this.sumYunfei = sumYunfei;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public double getBatchPrice() {
        return batchPrice;
    }

    public void setBatchPrice(double batchPrice) {
        this.batchPrice = batchPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public double getYunfei() {
        return yunfei;
    }

    public void setYunfei(double yunfei) {
        this.yunfei = yunfei;
    }
}
