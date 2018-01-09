package com.training.commodity.service;

import com.training.commodity.dao.CommodityMapper;
import com.training.commodity.entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class CommodityServiceImpl implements CommodityService{

    @Autowired
    private CommodityMapper commodityMapper;

    public List<Commodity> getCommodityList(Map<String, Object> map) {
        List<Commodity> list = this.commodityMapper.getCommodityList(map);
        return  list;
    }
}
