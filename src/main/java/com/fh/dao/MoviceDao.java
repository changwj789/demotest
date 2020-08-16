package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.entity.po.MovieParam;
import com.fh.entity.vo.Movie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MoviceDao extends BaseMapper<Movie> {
    List<Movie> queryMovie(MovieParam movieParam);

    Long queryCount(MovieParam movieParam);
}
