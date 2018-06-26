package com.springboot.controller;

import com.springboot.Util.RedisUtils;
import com.springboot.entity.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/look")
public class LookWorldController {

    @Autowired
    private GirlProperties girlProperties;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtils redisUtils;

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

    @RequestMapping("/redisset")
    public void redisSet(Map<String, Object> model){
        boolean b = redisUtils.set("jey", "sfs");
        redisUtils.hmSet("hash","name","test");
        System.out.println(b);

    }
    @RequestMapping("/redisget")
    public void redistGet(Map<String, Object> model){
        Object jey = redisUtils.get("jey");
        Object hmGet = redisUtils.hmGet("hash", "name");
        System.out.println(jey);
        System.out.println(hmGet);
    }

    @RequestMapping("/websocket")
    public ModelAndView websocket(Map<String, Object> model){
        ModelAndView mv = new ModelAndView("websocket");
        return mv;
    }

}
