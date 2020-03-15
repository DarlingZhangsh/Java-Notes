package user.controller.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * Classname MovieServiceFeign
 * Description TODO
 * Date 2020/3/14 18:59
 * @author by Zhangsihai
 */
//指定调用哪一个服务 服务名称必须与远程服务名称一致 当该接口里的方法无法返回结果时，将调用熔断方法MovieServiceFeignExceptionHandle
@FeignClient(value = "movie", fallback = MovieServiceFeignExceptionHandle.class )
public interface MovieServiceFeign {

    //与被调用服务端的映射方法声明一致 
    @GetMapping("getMovieById/{id}")
    public Map<String,Object> getMovieById(@PathVariable Integer id);
}
