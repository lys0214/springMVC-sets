package com.lys.controller;

import com.lys.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {
    /**
     * 测试
     * @return
     */
    @RequestMapping("/d1")
    public String demoString(){
        return "demo";
    }

    /**
     * 显示用户信息
     * @param model
     * @return
     */
    @RequestMapping("/user")
    public String user(Model model) {
        model.addAttribute("user", new User("lys","root"));
        return "user/showUser";
    }

    @RequestMapping("/insertUser")
    public String insert(User user){
        System.out.println(user);
        return "";
    }

    @RequestMapping("/toInsert")
    public String toInsert(){
        return "user/insertUser";
    }



}
