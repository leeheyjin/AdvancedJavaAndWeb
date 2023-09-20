package kr.or.ddit.member.service; // 이건 왜이래 ㅅㅂ

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import kr.or.ddit.member.vo.MessagesDto;
import kr.or.ddit.member.vo.SmsRequestVO;


public class SmsService {

    private static final String SERVICE_ID = "ncp:sms:kr:288377874061:camping"; // 여기 니 서비스 아이디
    private static final String ACCESS_KEY = "SnHfm2BNG6CJdHwZSC5e"; // 여기 니 엑세스 아이디  SnHfm2BNG6CJdHwZSC5e
    private static final String SECRET_KEY = "DgIpEpbosjIJOcQsaB3XS7dpifNkUkSx7Yba6yky"; // 여기 니 시크릿 키 DgIpEpbosjIJOcQsaB3XS7dpifNkUkSx7Yba6yky


    public String sendSms(String recipientPhoneNumber, String content) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        Long time = System.currentTimeMillis();
        List<MessagesDto> messages = new ArrayList<>();
        messages.add(new MessagesDto(recipientPhoneNumber));

        String contentUTF8 = new String(content.getBytes("UTF-8"), "UTF-8");
        SmsRequestVO smsRequestVO = new SmsRequestVO("SMS", "COMM", "82", "01071922536", contentUTF8, messages);
        String jsonBody = smsRequestVO.toJsonString();
        System.out.println(jsonBody);

        String endpoint = "https://sens.apigw.ntruss.com/sms/v2/services/" + SmsService.SERVICE_ID + "/messages";
        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        connection.setRequestProperty("x-ncp-apigw-timestamp", time.toString());
        connection.setRequestProperty("x-ncp-iam-access-key", SmsService.ACCESS_KEY);
        String sig = makeSignature(time);
        connection.setRequestProperty("x-ncp-apigw-signature-v2", sig);
        connection.setDoOutput(true);

        try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
            byte[] bodyBytes = jsonBody.getBytes(StandardCharsets.UTF_8);
            wr.write(bodyBytes);
        }

        int responseCode = connection.getResponseCode();
        InputStream inputStream;
        if (responseCode >= 200 && responseCode < 400) {
            inputStream = connection.getInputStream();
        } else {
            inputStream = connection.getErrorStream();
        }

        String responseJson = readInputStream(inputStream);
        for (Map.Entry<String, List<String>> entry : connection.getHeaderFields().entrySet()) {
            String key = entry.getKey();
            List<String> values = entry.getValue();
            
            System.out.println(key + ": " + values);
        }
        
        System.out.println(" * responseJson: " + responseJson);
        return responseJson;
    }

    private String readInputStream(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        return response.toString();
    }
    
    public String makeSignature(Long time) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {

        String space = " ";
        String newLine = "\n";
        String method = "POST";
        String url = "/sms/v2/services/"+ SmsService.SERVICE_ID +"/messages";
        String timestamp = time.toString();
        String accessKey = SmsService.ACCESS_KEY;
        String secretKey = SmsService.SECRET_KEY;

        String message = new StringBuilder()
                .append(method)
                .append(space)
                .append(url)
                .append(newLine)
                .append(timestamp)
                .append(newLine)
                .append(accessKey)
                .toString();

        SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(signingKey);

        byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
        String encodeBase64String = Base64.getUrlEncoder().encodeToString(rawHmac);

        return encodeBase64String;
    }
}