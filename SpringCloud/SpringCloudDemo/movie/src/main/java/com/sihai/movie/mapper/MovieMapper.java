package com.sihai.movie.mapper;

import com.sihai.movie.bean.Movie;
import org.springframework.stereotype.Repository;

/**
 * Classname MovieMapper
 * Description TODO
 * Date 2020/3/14 16:16
 *
 * @author by Zhangsihai
 */
@Repository
public class MovieMapper {

    public Movie getMovieById(Integer id){
        Movie movie = new Movie();
        movie.setId(id);
        movie.setName("唐人街探案3");
        return movie;
    }
}
