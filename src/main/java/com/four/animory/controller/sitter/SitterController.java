package com.four.animory.controller.sitter;

import com.four.animory.dto.sitter.SitterBoardDTO;
import com.four.animory.service.sitter.SitterService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/sitter")
public class SitterController {
  @Autowired
  private SitterService sitterService;

  @GetMapping("/list")
  public void list() {
  }

  @GetMapping("/register")
  public void registerGet() {
  }

  @PostMapping("/register")
  public String registerPost(SitterBoardDTO sitterBoardDTO) {
    sitterService.registerSitterBoard(sitterBoardDTO);
    return "redirect:/sitter/list";
  }
}
