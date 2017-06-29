package com.flower.commodity.service;

import com.flower.commodity.pojo.Commodity;

import java.util.List;
import java.util.Map;

/**
 * 商品接口service
 * Created by lenovo on 2017/6/22.
 */
public interface CommodityService {
    /**
     * 获取商品列表接口
     * @param map
     * @return
     */
    List<Commodity> getCommodityList(Map<String,Object> map);

}
