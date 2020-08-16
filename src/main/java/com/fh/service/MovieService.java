package com.fh.service;

import com.fh.common.DataTableResult;
import com.fh.entity.po.MovieParam;

public interface MovieService {
    DataTableResult queryMovie(MovieParam movieParam);
}
