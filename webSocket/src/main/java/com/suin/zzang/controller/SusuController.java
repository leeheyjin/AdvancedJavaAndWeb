package com.suin.zzang.controller;

import com.suin.zzang.service.Susu;
import com.suin.zzang.vo.SusuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rest")
public class SusuController {
    @Autowired
    private Susu susuSVC;

    // restful 방식을 적용하면 기본 다섯가지: get(리스트, 하나), post, put, delete
    @ResponseBody
    @GetMapping(value = "/susus", produces = "application/json;charset=utf-8")
    public List<SusuVO> getSusus() {
        return susuSVC.listData();
    }

    @ResponseBody
    @GetMapping(value = "/susu/{title}", produces = "application/json;charset=utf-8")
    public SusuVO getSusu(@PathVariable String title) {
        SusuVO susuVO = new SusuVO();
        susuVO.setTitle(title);
        return susuSVC.oneData(susuVO);
    }

    @ResponseBody
    @PostMapping(value = "/susu", produces = "application/json;charset=utf-8")
    public String postSusu(@RequestBody SusuVO susuVO) {
        return Integer.toString(susuSVC.insertData(susuVO));
    }

    @ResponseBody
    @PutMapping(value = "/susu", produces = "application/json;charset=utf-8")
    public String putSusu(@RequestBody SusuVO susuVO) {
        return Integer.toString(susuSVC.updateData(susuVO));
    }

    @ResponseBody
    @DeleteMapping(value = "/susu/{title}", produces = "application/json;charset=utf-8")
    public String deleteSusu(@PathVariable String title) {
        SusuVO susuVO = new SusuVO();
        susuVO.setTitle(title);
        return Integer.toString(susuSVC.deleteData(susuVO));
    }

}
