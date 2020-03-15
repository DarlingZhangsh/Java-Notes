package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.bean.User;
import user.mapper.UserMapper;

/**
 * Classname MovieService
 * Description TODO
 * Date 2020/3/14 15:34
 *
 * @author by Zhangsihai
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    public User getUserByAge(Integer age) {
        return userMapper.getUserByAge(age);
    }
}
