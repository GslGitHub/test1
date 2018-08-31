package com.ssmm.model;

public class ymxCommodity {
    private  String id;
    private  String commodityName;
    private  String commoditySku;
    private  double commodityWeight;
    private  double height;
    private  double length;
    private  double width;
    private  double  profits;

    public double getProfits() {
        return profits;
    }

    public void setProfits(double profits) {
        this.profits = profits;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommoditySku() {
        return commoditySku;
    }

    public void setCommoditySku(String commoditySku) {
        this.commoditySku = commoditySku;
    }

    public double getCommodityWeight() {
        return commodityWeight;
    }

    public void setCommodityWeight(double commodityWeight) {
        this.commodityWeight = commodityWeight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
