package com.flower.commodity.dao;

import com.flower.commodity.pojo.Commodity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 商品mapper
 * Created by lenovo on 2017/6/22.
 */
@Repository
public interface CommodityMapper {

    /**
     * 获取商品列表
     * @return
     */
    List<Commodity> getCommodityList(@Param("params") Map<String,Object> params);

}
