package com.training.commodity.controller;


import com.training.commodity.service.CommodityService;
import com.training.commodity.service.impl.CommodityServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class BeanController implements Controller  {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("this is a request");
        return null;
    }


    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mvc.xml");
        CommodityService commodityService = ac.getBean(CommodityServiceImpl.class);
        commodityService.getCommodityList(new HashMap<>());
    }

}
