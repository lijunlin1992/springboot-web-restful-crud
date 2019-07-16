package com.springboot.springbootwebrestfulcrud.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class Hello {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello ";
    }

    @RequestMapping("/success")
    public String success(HashMap<String, Object> map){
        map.put("name","lijunlin");
        return "success";
    }
}
