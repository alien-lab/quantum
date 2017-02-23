package com.alienlab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by 橘 on 2016/12/28.
 */
@Controller
public class PageController {
    @RequestMapping("demo")
    public String pageDemo(){
        return "/demo/demo";
    }


    @RequestMapping(value="msg/{openid}",method = RequestMethod.GET)
    public String goMessageAll(@PathVariable String openid,Model model,HttpSession session){
        model.addAttribute("openid",openid);
        return "/msgList";
    }
}
