package com.stosik.electric.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class LoginController
{
    @GetMapping("/")
    public String home()
    {
        return "redirect:/index";
    }
    
    @GetMapping("/index")
    public String index()
    {
        return "login/index";
    }
}
