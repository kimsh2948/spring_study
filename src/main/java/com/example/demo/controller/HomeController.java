package com.example.demo.controller;

import com.example.demo.config.auth.LoginUser;
import com.example.demo.config.auth.SessionUser;
import com.example.demo.domain.Member;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class HomeController {

    //private final UserService userService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        //model.addAttribute("user", userService.findAll());

        if(user != null){
            model.addAttribute("user", user.getName());
            return "googleLoginHomeIndex";
        }

        return "homeIndex";
    }

    @GetMapping("/home")
    public String home(@SessionAttribute(name = SessionConstants.LOGIN_MEMBER, required = false) Member loginMember,
                       Model model) {
        if (loginMember == null) {
            return "homeIndex";
        }

        model.addAttribute("member", loginMember);

        return "loginHomeIndex";
    }
}
