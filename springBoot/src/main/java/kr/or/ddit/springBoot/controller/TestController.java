package kr.or.ddit.springBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hyundai")
public class TestController {
    @GetMapping("/merong")
    public String getHyundai() {
        return "hyundai";
    }

}
