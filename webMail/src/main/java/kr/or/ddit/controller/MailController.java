package kr.or.ddit.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {
    private JavaMailSender mailSender;

    @GetMapping("/sendMail")
    public String getSendMail() {
        return "sendMail";
    }

    @PostMapping("/sendMail")
    public String postSendMail(@RequestParam Map<String, String> map) {
        log.info("MAP: " + map);

        String subject = map.get("subject");
        String content = map.get("content");
        String receiver = map.get("receiver");
        String sender = map.get("sender");

        MimeMessage mail = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mail, true, "UTF-8");
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

}
