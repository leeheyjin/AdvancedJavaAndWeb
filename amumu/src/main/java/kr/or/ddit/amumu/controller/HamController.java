package kr.or.ddit.amumu.controller;

import kr.or.ddit.amumu.service.HamService;
import kr.or.ddit.amumu.vo.HamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HamController {
    @Autowired
    private HamService hamService;

    @GetMapping("/rest/ham")
    public List<HamVO> getList() {
        return hamService.listHam();
    }

    @GetMapping("/rest/ham/{num}")
    public HamVO getHam(@PathVariable int num) {
        HamVO hamVO = new HamVO();
        hamVO.setHamNum(num);
        return hamService.getHam(hamVO);
    }

    @PostMapping("/rest/ham")
    public String insertHam(@RequestBody HamVO hamVO) {
        return String.valueOf(hamService.insertHam(hamVO));
    }

    @PutMapping("/rest/ham")
    public String updateHam(@RequestBody HamVO hamVO) {
        return String.valueOf(hamService.updateHam(hamVO));
    }

    @DeleteMapping("/rest/ham/{num}")
    public String deleteHam(@PathVariable int num) {
        HamVO hamVO = new HamVO();
        hamVO.setHamNum(num);
        return String.valueOf(hamService.deleteHam(hamVO));
    }
}
