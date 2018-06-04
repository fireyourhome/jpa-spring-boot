package com.springboot.controller;

import com.springboot.entity.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.util.Date;
import java.util.Map;

@RestController
public class LookWorldController {

    @Autowired
    private GirlProperties girlProperties;
    //访问/hello或者/hi任何一个地址，都会返回一样的结果
    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
    public String say(){
        return "hi you!!!";
    }
    @GetMapping(value = "/getGirl")
    @ResponseBody
    public String getGirl(){
        return  girlProperties.getName()+"  "+girlProperties.getAge()+"     ....    "+girlProperties.getContent();
    }
   /* @RequestMapping("/helloto")
    public String helloto(Model m){
        m.addAttribute("now",DateFormat.getDateTimeInstance().format(new Date()));
        return "hello";
    }*/
    @RequestMapping("/test")
    public ModelAndView helloto(Map<String, Object> model){
        model.put("now", DateFormat.getDateTimeInstance().format(new Date()));
        ModelAndView mv = new ModelAndView("hello");
        return mv;
    }
}
