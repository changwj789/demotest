package com.fh.controller;

import com.fh.common.DataTableResult;
import com.fh.entity.po.MovieParam;
import com.fh.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @RequestMapping("queryMovie")
    public DataTableResult queryMovie(MovieParam movieParam){
        return movieService.queryMovie(movieParam);
    }
}
