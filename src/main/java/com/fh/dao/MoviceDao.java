package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.entity.vo.Movie;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MoviceDao extends BaseMapper<Movie> {
}
