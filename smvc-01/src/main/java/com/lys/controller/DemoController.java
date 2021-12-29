package com.lys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping("/d1")
    public String demoString(){
        return "demo";
    }
    @RequestMapping("/user")
    public String user(Model model) {
        model.addAttribute("name", "liming");
        return "user/showUser";
    }

}
