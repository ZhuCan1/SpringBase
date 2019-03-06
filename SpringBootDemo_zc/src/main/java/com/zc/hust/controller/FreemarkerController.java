package com.zc.hust.controller;

import com.zc.hust.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("ftl")
public class FreemarkerController {

    @Autowired
    private Resource resource;

    @RequestMapping("/hello")
    @ResponseBody
    public Object hello(){
        return "/hello springboot";
    }


    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("resource", resource);
        return "freemarker/index";
    }

    @RequestMapping("center")
    public String center() {
        return "freemarker/center/center";
    }

}