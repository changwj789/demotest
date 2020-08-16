package com.fh.service;

import com.fh.common.DataTableResult;
import com.fh.common.ServerResponse;
import com.fh.entity.po.MovieParam;
import com.fh.entity.vo.Movie;

public interface MovieService {
    DataTableResult queryMovie(MovieParam movieParam);

    ServerResponse addMovie(Movie movie);

    ServerResponse updateMovie(Integer id);
}
