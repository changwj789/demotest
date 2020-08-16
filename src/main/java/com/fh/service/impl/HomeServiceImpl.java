package com.fh.service.impl;

import com.fh.dao.HomeDao;
import com.fh.entity.vo.Home;
import com.fh.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeDao homeDao;
    @Override
    public List<Home> finAllHome() {

        List<Home> list= homeDao.selectList(null);
        return list;
    }
}
