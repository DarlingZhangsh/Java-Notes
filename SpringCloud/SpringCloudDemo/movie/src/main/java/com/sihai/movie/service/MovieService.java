package com.sihai.movie.service;

import com.sihai.movie.bean.Movie;
import com.sihai.movie.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classname MovieService
 * Description TODO
 * Date 2020/3/14 15:34
 *
 * @author by Zhangsihai
 */
@Service
public class MovieService {

    @Autowired
    MovieMapper movieMapper;


    public Movie getMovieById(Integer id) {
        return movieMapper.getMovieById(id);
    }
}
