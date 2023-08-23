package com.suin.zzang.service;

import com.suin.zzang.mapper.SusuMapper;
import com.suin.zzang.vo.SusuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SusuImpl implements Susu {
    @Autowired
    private SusuMapper susuMapper;

    @Override
    public List<SusuVO> listData() {
        return susuMapper.listData();
    }

    @Override
    public SusuVO oneData(SusuVO susuVO) {
        return susuMapper.oneData(susuVO);
    }

    @Override
    public int insertData(SusuVO susuVO) {
        return susuMapper.insertData(susuVO);
    }

    @Override
    public int updateData(SusuVO susuVO) {
        return susuMapper.updateData(susuVO);
    }

    @Override
    public int deleteData(SusuVO susuVO) {
        return susuMapper.deleteData(susuVO);
    }
}
