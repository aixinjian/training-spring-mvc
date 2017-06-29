package com.flower.commodity.service;

import com.flower.commodity.dao.CommodityMapper;
import com.flower.commodity.pojo.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/6/22.
 */
@Service
public class CommodityServiceImpl implements CommodityService{

    @Autowired
    private CommodityMapper commodityMapper;

    public List<Commodity> getCommodityList(Map<String, Object> map) {
        List<Commodity> list = this.commodityMapper.getCommodityList(map);
        return  list;
    }
}
