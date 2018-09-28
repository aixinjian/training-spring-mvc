package com.training.aop;


import com.training.commodity.service.impl.CommodityServiceImpl;
import com.training.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        CommodityServiceImpl commodityService = ac.getBean(CommodityServiceImpl.class);
        commodityService.query();
    }
}
