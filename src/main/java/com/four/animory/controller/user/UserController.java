package com.four.animory.controller.user;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/member")
public class UserController {
    @GetMapping("/login")
    public void loginGet(){
    }

    @GetMapping("/join")
    public void joinGet(){
    }
    @PostMapping("/joinRegister")
    public String joinPost(){
        return "redirect:/member/login";
    }
}
