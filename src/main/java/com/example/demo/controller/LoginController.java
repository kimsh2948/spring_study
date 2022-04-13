package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public String login(@ModelAttribute LoginForm form, HttpServletRequest request){
        Member member = new Member();
        member.setName(form.getUserName());
        member.setPassword(form.getUserPassword());

        Member loginMember = loginService.login(member);

        if(loginMember==null){
            return "login/loginForm";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConstants.LOGIN_MEMBER, loginMember);

        return "redirect:/";
    }

    @GetMapping("/members/logout")
    public String logout(HttpServletRequest request){

        HttpSession session = request.getSession(false);
        if (session != null){
            session.invalidate();
        }

        return "redirect:/";
    }
}
