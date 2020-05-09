package cn.sihai.service.impl;

import cn.sihai.dao.UserMapper;
import cn.sihai.domain.User;
import cn.sihai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
   private UserMapper userMapper;

    public User findById(int i) {
        return userMapper.selectByPrimaryKey(i);
    }
}
