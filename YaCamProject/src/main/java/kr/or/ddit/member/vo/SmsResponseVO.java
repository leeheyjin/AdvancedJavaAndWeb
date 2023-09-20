package kr.or.ddit.member.vo;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class SmsResponseVO {
    private String requestId;
    private LocalDateTime requestTime;
    private String statusCode;
    private String statusName;
}