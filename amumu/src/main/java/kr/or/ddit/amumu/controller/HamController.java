package kr.or.ddit.amumu.controller;

import kr.or.ddit.amumu.service.HamService;
import kr.or.ddit.amumu.vo.HamVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
public class HamController {
    private HamService hamService;

    @Autowired
    public HamController(HamService hamService) {
        this.hamService = hamService;
    }

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
    public String insertHam(HamVO hamVO) throws Exception {
        // 디비에 저장할 파일경로
        String hamFile = "/kmerong/" + hamVO.getHamFile2().getOriginalFilename();
        hamVO.setHamFile(hamFile);
        log.debug("hamVO: " + hamVO);

        // 실제 저장될 물리적 경로
        String savePath = "/Users/leehyejin/Project/ddit/upload/amumu/" + hamVO.getHamFile2().getOriginalFilename();
        hamVO.getHamFile2().transferTo(new File(savePath));
        return String.valueOf(hamService.insertHam(hamVO));
    }

//    @PostMapping("/rest/ham")
//    public String insertHam(@RequestBody HamVO hamVO) {
//        return
//    }

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

    @PostMapping("/rest/ham2")
    public String insFile(MultipartFile fileTest) throws IOException { // formData.append("fileTest", $testFile2[0].files[0]);
        log.debug("filename: {}", fileTest.getOriginalFilename());
        log.debug("filename: {}", String.valueOf(fileTest.getSize()));
        String savePath = "/Users/ChoiSeoYeon/Desktop/choi/upload/" + fileTest.getOriginalFilename();
        fileTest.transferTo(new File(savePath));

        String webURL = "/uploads/" + fileTest.getOriginalFilename();

        return webURL;
    }
}
