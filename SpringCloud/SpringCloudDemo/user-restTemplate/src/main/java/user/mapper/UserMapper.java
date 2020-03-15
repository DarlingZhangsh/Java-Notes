package user.mapper;

import org.springframework.stereotype.Repository;
import user.bean.User;

/**
 * Classname MovieMapper
 * Description TODO
 * Date 2020/3/14 16:16
 *
 * @author by Zhangsihai
 */
@Repository
public class UserMapper {


    public User getUserByAge(Integer age) {
        User user = new User();
        user.setAge(age);
        user.setName("darling");
        return user;
    }
}
