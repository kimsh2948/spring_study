package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @GetMapping("/members/login")
    public String createForm() { return "login/loginForm"; }

    @PostMapping("/members/login")
    public String login(LoginForm form){
        Member member = new Member();
        member.setName(form.getUserName());
        member.setPassword(form.getUserPassword());

        if(loginService.login(member)){
            return "redirect:/";
        }

        return "login/loginForm";
    }
}
