package user.controller.feign;

import org.springframework.stereotype.Component;
import user.bean.Movie;
import user.bean.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Classname MovieServiceFeignExceptionHandle
 * Description TODO
 * Date 2020/3/15 14:30
 *
 * @author by Zhangsihai
 */
@Component
public class MovieServiceFeignExceptionHandle implements MovieServiceFeign {
    @Override
    public Map<String, Object> getMovieById(Integer id) {
        User user = new User();
        user.setName("-----");
        user.setAge(0);
        Movie movie = new Movie();
        movie.setId(-1);
        movie.setName("------");
        Map<String, Object> map = new HashMap<>();
        map.put("user",user);
        map.put("movie",movie);
        return map;
    }
}
