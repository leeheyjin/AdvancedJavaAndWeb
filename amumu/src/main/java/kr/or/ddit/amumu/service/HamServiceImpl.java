package kr.or.ddit.amumu.service;

import kr.or.ddit.amumu.mapper.HamMapper;
import kr.or.ddit.amumu.vo.HamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HamServiceImpl implements HamService {

    @Autowired
    private HamMapper hamMapper;

    @Override
    public List<HamVO> listHam() {
        return hamMapper.listHam();
    }

    @Override
    public HamVO getHam(HamVO hamVO) {
        return hamMapper.getHam(hamVO);
    }

    @Override
    public int insertHam(HamVO hamVO) {
        return hamMapper.insertHam(hamVO);
    }

    @Override
    public int updateHam(HamVO hamVO) {
        return hamMapper.updateHam(hamVO);
    }

    @Override
    public int deleteHam(HamVO hamVO) {
        return hamMapper.deleteHam(hamVO);
    }
}
