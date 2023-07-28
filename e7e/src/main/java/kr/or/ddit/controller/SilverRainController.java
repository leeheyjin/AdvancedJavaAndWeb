package kr.or.ddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/silver")
public class SilverRainController {

    @GetMapping("/rain")
    @ResponseBody
    public String getRain() {
        return "SilverRain";
    }
}