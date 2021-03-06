package com.example.demo.controller;

import com.example.demo.service.SUserService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by 74788 on 2017/7/6.
 */
@Controller
public class HelloController {

    @Resource
    private SUserService sUserService;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String toAdmin(){
        return "helloAdmin";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/")
    public String root() {
        return "index";
    }

    @RequestMapping("/403")
    public String error(){
        return "403";
    }
}
