package com.training.commodity.dao;

import com.training.commodity.entity.Commodity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 商品mapper
 */
@Repository
public interface CommodityMapper {

    /**
     * 获取商品列表
     * @return
     */
    List<Commodity> getCommodityList(@Param("params") Map<String,Object> params);

}
