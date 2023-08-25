package kr.or.ddit.amumu.service;

import kr.or.ddit.amumu.vo.HamVO;

import java.util.List;

public interface HamService {
    List<HamVO> listHam();

    HamVO getHam(HamVO hamVO);

    int insertHam(HamVO hamVO);

    int updateHam(HamVO hamVO);

    int deleteHam(HamVO hamVO);
}
