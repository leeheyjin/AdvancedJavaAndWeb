package com.ddit.sec.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/angel")
public class SecController {
    @GetMapping("/ham")
    public String ham(Authentication auth) {
        log.debug("AUTH: " + auth);
        log.debug("AUTH: " + ((User) auth.getPrincipal()).getUsername());
        log.debug("AUTH: " + ((User) auth.getPrincipal()).getPassword());
        log.debug("AUTH: " + auth.getAuthorities());

        SecurityContext securityContext = SecurityContextHolder.getContext();
        log.debug("CHECK: " + securityContext);
        return "ham";
    }

    @GetMapping("/cat")
    public String cat() {
        return "cat";
    }

    @PostMapping("/seoju")
    @ResponseBody
    public String seoju(@RequestBody String mName) {
        return mName;
    }
}
