package com.four.animory.controller.sitter;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/sitter")
public class SitterController {

    @GetMapping("/list")
    public void list(){
    }
}
