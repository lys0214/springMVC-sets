package com.lys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping("/d1")
    public String demoString(){
        return "/WEB-INF/jsp/demo.jsp";
    }
}
