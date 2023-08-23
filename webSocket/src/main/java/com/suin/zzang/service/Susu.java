package com.suin.zzang.service;

import com.suin.zzang.vo.SusuVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface Susu {
    // 읽기 리스트(여러 줄)
    public List<SusuVO> listData();

    // 읽기 한줄
    public SusuVO oneData(SusuVO susuVO);

    // 입력
    public int insertData(SusuVO susuVO);

    // 수정
    public int updateData(SusuVO susuVO);

    // 삭제
    public int deleteData(SusuVO susuVO);
}
