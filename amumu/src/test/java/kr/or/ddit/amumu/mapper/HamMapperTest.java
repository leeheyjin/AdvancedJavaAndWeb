package kr.or.ddit.amumu.mapper;

import kr.or.ddit.amumu.vo.HamVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class HamMapperTest {
    @Autowired
    private HamMapper hamMapper;

    @Test
    @DisplayName("햠 insert 테스트")
    public void insertTest() {
        HamVO hamVO = new HamVO();
        for (int i = 0; i < 10; i++) {
            hamVO.setHamContent("내용" + i);
            hamVO.setHamFile("/amumu/filename" + i + ".jpg");
            hamVO.setHamName("이름" + i);
            Assertions.assertEquals(1, hamMapper.insertHam(hamVO));
        }
    }

    @Test
    @DisplayName("안예린 delete")
    public void deleteTest() {
        HamVO hamVO = new HamVO();
        hamVO.setHamNum(6);
        Assertions.assertEquals(1, hamMapper.deleteHam(hamVO));
    }

    @Test
    public void getAll() {
        List<HamVO> list = hamMapper.listHam();
        Assertions.assertEquals(10, list.size());

    }
}
