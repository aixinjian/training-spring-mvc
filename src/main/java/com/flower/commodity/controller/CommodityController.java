package com.flower.commodity.controller;

import com.flower.commodity.pojo.Commodity;
import com.flower.commodity.service.CommodityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品controller
 * Created by lenovo on 2017/6/21.
 */
@Controller
@RestController
@RequestMapping("/commodity")
public class CommodityController {

    Logger log = Logger.getLogger(CommodityController.class);

    @Autowired
    private CommodityService commodityService;
    /**
     * 获取商品列表
     * @return
     */
    @RequestMapping("/getCommodityList")
    public String getCommodityList(){
        log.info("*****查询商品列表******start******");

        Map<String,Object> map = new HashMap<>();
        List<Commodity> commodityList = commodityService.getCommodityList(map);
        return commodityList.toString();
    }

}
