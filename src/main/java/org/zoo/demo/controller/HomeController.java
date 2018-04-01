package org.zoo.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.zoo.demo.entity.City;
import org.zoo.demo.service.CityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/3/24.
 */
@Controller
@RequestMapping("/home")
public class HomeController{

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private CityService cityService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    //返回jsp视图展示
    @RequestMapping(value = "/getCity",method = RequestMethod.GET)
    public ModelAndView getUsers1(@RequestParam Integer cityId) {
        ModelAndView modelAndView = new ModelAndView();
        //调用service方法得到用户列表
        City cities = cityService.getCity(cityId);
        //将得到的用户列表内容添加到ModelAndView中
        modelAndView.addObject("cities",cities);
        //设置响应的jsp视图
        modelAndView.setViewName("getCities");
        logger.info("===============================成功查询城市列表！");
        return modelAndView;
    }
    //返回json格式数据，形式1
    @RequestMapping(value = "/getCityJson",method = RequestMethod.GET)
    @ResponseBody
    public City getUsers2(@RequestParam Integer cityId, HttpServletRequest request, HttpServletResponse response) {
        //调用service方法得到用户列表
        City cities = cityService.getCity(cityId);
        logger.info("===============================成功查询城市列表！");
        return cities;
    }

}
