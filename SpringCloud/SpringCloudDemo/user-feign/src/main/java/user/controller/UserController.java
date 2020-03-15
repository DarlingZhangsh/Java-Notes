package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import user.bean.User;
import user.controller.feign.MovieServiceFeign;
import user.service.UserService;

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
public class UserController {
    @Autowired
    UserService userService;//本地接口

    @Autowired
    MovieServiceFeign movieServiceFeign;//Feign接口，用于远程调用



    @GetMapping("getUserByAge/{age}")
    public Map<String,Object> getMovieById(@PathVariable Integer age){
        User user = userService.getUserByAge(age);
        Map<String, Object> map = new HashMap<>();
        map.put("user",user);
        return map;
    }

    @GetMapping("buyMovie/{id}/{age}")
    public Map<String,Object> getMovieById(@PathVariable Integer id, @PathVariable Integer age){
        //调用本地接口
        User user = userService.getUserByAge(age);
        Map<String, Object> movie = movieServiceFeign.getMovieById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("user",user);
        map.put("movie",movie);
        return map;
    }
}
