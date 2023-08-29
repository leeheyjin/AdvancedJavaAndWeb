package kr.or.ddit.amumu.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
public class HamVO {
    private int hamNum;
    private String hamName;
    private String hamContent;
    private String hamFile;
    private MultipartFile hamFile2;

}
