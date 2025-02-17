package com.suin.zzang.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.suin.zzang.service.Susu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.suin.zzang.vo.SusuVO;

/*
 * 테스트는 spring 버전 또는 boot냐 아니냐 여부에 따라 어노테이션이 달라진다
 */

//Junit5 사용
@ExtendWith(SpringExtension.class)
//Context설정파일 지정 classpath를 사용해도 됨
@ContextConfiguration("classpath:config/spring/database-context.xml")
public class SusuTest {

    @Autowired
    private SusuMapper susu;

    @Test
    @DisplayName("susu zzang")
    public void insertTest() {

        SusuVO susuVO;
        for (int i = 5; i <= 105; i++) {
            susuVO = new SusuVO();
            susuVO.setTitle("merong" + i);
            susuVO.setScont("content" + i);
            susuVO.setSname("suin" + i);
            assertEquals(1, susu.insertData(susuVO));
        }

    }
}
