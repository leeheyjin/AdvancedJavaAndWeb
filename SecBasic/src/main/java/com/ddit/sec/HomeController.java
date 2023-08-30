package com.ddit.sec;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        log.info("Welcome home! The client locale is {}.", locale);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String angel = bCryptPasswordEncoder.encode("angel");
        String angma = bCryptPasswordEncoder.encode("angma");
        log.debug("ANGEL: " + angel);
        log.debug("ANGMA: " + angma);

        log.debug("isSame: " + bCryptPasswordEncoder.matches("angel", angel));
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "home";
    }

}
