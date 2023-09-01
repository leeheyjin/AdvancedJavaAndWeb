package kr.or.ddit.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {
    private final JavaMailSender mailSender;

    @GetMapping("/sendMail")
    public String getSendMail() {
        return "sendMail";
    }

    @PostMapping("/sendMail")
    public String postSendMail(@RequestParam Map<String, String> map) throws MessagingException {
        log.info("MAP: " + map);
        String subject = map.get("subject");
        String text = map.get("text");
        String to = map.get("to");
        String from = map.get("from");

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
        messageHelper.setSubject(subject);
        messageHelper.setText(text);
        messageHelper.setTo(to);
        messageHelper.setFrom(from);

        mailSender.send(message);
        log.info("메일 전송 완료");
        return "redirect:/mail/sendMail";
     }
}
