package com.fh.service.impl;

import com.fh.common.DataTableResult;
import com.fh.dao.MoviceDao;
import com.fh.entity.po.MovieParam;
import com.fh.entity.vo.Movie;
import com.fh.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MoviceDao moviceDao;

    @Override
    public DataTableResult queryMovie(MovieParam movieParam) {
        List<Movie> list= moviceDao.queryMovie(movieParam);
        Long count= moviceDao.queryCount(movieParam);
        return new DataTableResult(movieParam.getDraw(),count,count,list);
    }
}
