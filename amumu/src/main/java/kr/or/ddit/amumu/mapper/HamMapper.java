package kr.or.ddit.amumu.mapper;

import kr.or.ddit.amumu.vo.HamVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HamMapper {
    // Get List
    List<HamVO> listHam();

    // Get One
    HamVO getHam(HamVO hamVO);

    // insert
    int insertHam(HamVO hamVO);

    // update
    int updateHam(HamVO hamVO);

    // delete
    int deleteHam(HamVO hamVO);
}
