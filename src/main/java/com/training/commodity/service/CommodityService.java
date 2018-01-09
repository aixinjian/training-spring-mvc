package com.training.commodity.service;

import com.training.commodity.entity.Commodity;

import java.util.List;
import java.util.Map;

/**
 * 商品接口service
 */
public interface CommodityService {
    /**
     * 获取商品列表接口
     * @param map
     * @return
     */
    List<Commodity> getCommodityList(Map<String,Object> map);

}
