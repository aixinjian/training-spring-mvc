package com.flower.commodity.pojo;

import java.io.Serializable;

/**
 * 商品实体类
 * Created by lenovo on 2017/6/22.
 */
public class Commodity implements Serializable{

    private long skuId;//商品id

    private String skuTitle;//商品名称

    public long getSkuId() {
        return skuId;
    }

    public void setSkuId(long skuId) {
        this.skuId = skuId;
    }

    public String getSkuTitle() {
        return skuTitle;
    }

    public void setSkuTitle(String skuTitle) {
        this.skuTitle = skuTitle;
    }
}
