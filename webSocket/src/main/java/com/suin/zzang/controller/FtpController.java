package com.suin.zzang.controller;

import com.suin.zzang.utils.FtpUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/ftp")
@RequiredArgsConstructor
public class FtpController {
    private final FtpUtils ftpUtils;

    @GetMapping("/main")
    public String main() {
        return "ftpmain";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String uploadTest(MultipartFile file) throws IOException {
        ftpUtils.upload(file);
        return "OK";
    }

    @GetMapping("/download/{originFileName}")
    public void download(@PathVariable String originFileName, HttpServletResponse resp) throws IOException {
        ftpUtils.download(originFileName, resp);
    }
}
