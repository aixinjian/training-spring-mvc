package com.training.commodity.service.impl;

import com.training.commodity.entity.Commodity;
import com.training.commodity.service.CommodityService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CommodityServiceImpl implements CommodityService {

    @Override
    public List<Commodity> getCommodityList(Map<String, Object> map) {
        System.out.println("buzhidaoshenmegui");
        return null;
    }

    public void query(){
        System.out.println("11111111");
    }
}
