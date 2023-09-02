package com.suin.zzang.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.SocketException;
import java.net.URLEncoder;

@Slf4j
@Component
@PropertySource("classpath:config/props/ftpConfiguration.properties")
public class FtpUtils {
    @Value("${myFtp.server}")
    private String server;
    @Value("${myFtp.port}")
    private int port;
    @Value("${myFtp.username}")
    private String username;
    @Value("${myFtp.password}")
    private String password;
    private FTPClient ftp;

    public void open() throws SocketException, IOException {
        log.debug("server:" + server);
        log.debug("port:" + port);
        log.debug("username:" + username);
        log.debug("password:" + password);

        ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));

        ftp.connect(server, port);
        int reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            log.error("FTPClient:: server connection failed.");
        }

        ftp.setSoTimeout(1000);
        ftp.login(username, password);
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
    }

    public void close() throws IOException {
        ftp.logout();
        ftp.disconnect();
    }

    public void upload(MultipartFile file) throws IOException {
        open();
        InputStream inputStream = null;
        inputStream = file.getInputStream();
        // put
        ftp.storeFile(file.getOriginalFilename(), inputStream);
        inputStream.close();
        close();
    }

    public void download(String originFileName, HttpServletResponse resp) throws IOException {

        String fileName = URLEncoder.encode(originFileName, "UTF-8");

        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");


        open();
        OutputStream outputStream = new BufferedOutputStream(resp.getOutputStream());
        InputStream inputStream = null;
        // get
        inputStream = ftp.retrieveFileStream("/" + originFileName);

        byte[] bytesArray = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(bytesArray)) != -1) {
            outputStream.write(bytesArray, 0, bytesRead);
        }

        boolean success = ftp.completePendingCommand();
        log.debug("check: " + success);
        outputStream.close();
        inputStream.close();
        close();
    }
}
