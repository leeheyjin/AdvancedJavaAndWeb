package kr.or.ddit.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hyundai")
public class TestController {
    @GetMapping("/merong")
    public String getHyundai(Model model) {
        List<String> myList = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            myList.add("너무\uD83C\uDF1E더운데\uD83E\uDD75\uD83D\uDCA6에어컨을\uD83C\uDF2C\uFE0F끄다니요\uD83D\uDD95힝\uD83D\uDE1E입니다‼\uFE0F 너무\uD83C\uDF1E더운데\uD83E\uDD75\uD83D\uDCA6에어컨을\uD83C\uDF2C\uFE0F끄다니요\uD83D\uDD95힝\uD83D\uDE1E입니다‼\uFE0F 너무\uD83C\uDF1E더운데\uD83E\uDD75\uD83D\uDCA6에어컨을\uD83C\uDF2C\uFE0F끄다니요\uD83D\uDD95힝\uD83D\uDE1E입니다‼\uFE0F 너무\uD83C\uDF1E더운데\uD83E\uDD75\uD83D\uDCA6에어컨을\uD83C\uDF2C\uFE0F끄다니요\uD83D\uDD95힝\uD83D\uDE1E입니다‼\uFE0F");
        }
        model.addAttribute("myList", myList);
        return "hyundai";
    }

    @GetMapping("/commute")
    public String getCommute() {
        return "commute";
    }

}
