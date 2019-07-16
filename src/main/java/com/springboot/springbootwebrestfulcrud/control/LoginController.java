package com.springboot.springbootwebrestfulcrud.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,String> map,
                        HttpSession session){
        if("ljl".equals(username)&&"123".equals(password)){
            //登录成功后防止重复提交，重定向到登录成功页面
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        map.put("msg","用户名或密码错误");
        return "index";
    }
}
