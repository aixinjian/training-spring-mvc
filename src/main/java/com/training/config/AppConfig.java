package com.training.config;

import com.training.commodity.service.impl.CommodityServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.training.*")
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public CommodityServiceImpl commodityService(){
        CommodityServiceImpl commodityService = new CommodityServiceImpl();
        return commodityService;
    }
}
