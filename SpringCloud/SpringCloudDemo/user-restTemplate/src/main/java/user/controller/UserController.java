package user.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import user.bean.Movie;
import user.bean.User;
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
    UserService userService;


    @Autowired
    RestTemplate restTemplate;//远程调用

    @GetMapping("getUserByAge/{age}")
    public Map<String,Object> getMovieById(@PathVariable Integer age){
        User user = userService.getUserByAge(age);
        Map<String, Object> map = new HashMap<>();
        map.put("user",user);
        return map;
    }


    @HystrixCommand(fallbackMethod = "getMovieByIdHystrix") //真实方法无法返回结果时 将调用熔断方法 返回兜底数据
    @GetMapping("buyMovie/{id}/{age}")
    public Map<String,Object> getMovieById(@PathVariable Integer id, @PathVariable Integer age){
        //调用本地接口
        User user = userService.getUserByAge(age);
        //远程调用 先在启动类注入RestTemplate
        Map<String, Object> movie = restTemplate.getForObject("http://movie/getMovieById/"+id,Map.class);
        Map<String, Object> map = new HashMap<>();
        map.put("user",user);
        map.put("movie",movie);
        return map;
    }


    public Map<String,Object> getMovieByIdHystrix( Integer id,  Integer age){
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
