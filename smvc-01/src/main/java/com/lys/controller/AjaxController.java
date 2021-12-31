package com.lys.controller;

import com.alibaba.fastjson.JSON;
import com.lys.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
    @RequestMapping("/toResiter")
    public String forward() {
        return "file/register";
    }

    @RequestMapping("checkName")
    @ResponseBody  //把方法的返回值添加到响应体中
    public String checkName(String name) {
        if ("admin".equals(name)) {
            return "ng";
        } else {
            return "ok";
        }
    }

    @RequestMapping("Test")
    @ResponseBody
    public String test(){
        User user = new User();
        user.setName("liming");
        user.setPassword("root");
        return JSON.toJSONString(user);
    }
    @RequestMapping("user")
    @ResponseBody
    public User test1(){
        User user = new User();
        user.setName("liming");
        user.setPassword("root");
        return user;
    }

}
