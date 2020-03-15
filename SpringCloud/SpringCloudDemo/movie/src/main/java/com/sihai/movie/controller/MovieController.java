package com.sihai.movie.controller;

import com.sihai.movie.bean.Movie;
import com.sihai.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Classname MovieController
 * Description TODO
 * Date 2020/3/14 15:33
 *
 * @author by Zhangsihai
 */
@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @Value("${server.port}")
    int port;

    @GetMapping("getMovieById/{id}")
    public Map<String,Object> getMovieById(@PathVariable Integer id){
        System.out.println("port:"+port);
        Movie movie = movieService.getMovieById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("moive",movie);
        return map;
    }
}
