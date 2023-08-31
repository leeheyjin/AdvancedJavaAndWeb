package com.ddit.sec.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class LoginController {
    @GetMapping("/angel/mLogin")
    public String myLogin() {
        return "myLogin";
    }

    @GetMapping("/mlogin")
    public String mLogin() {
        return "mlogin";

    }

    @GetMapping("/angma/yourLogin")
    public String youLogin() {
        return "ylogin";

    }

}
