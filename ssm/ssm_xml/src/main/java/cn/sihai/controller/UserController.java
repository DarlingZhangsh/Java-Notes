package cn.sihai.controller;

import cn.sihai.domain.User;
import cn.sihai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findById")
    public @ResponseBody User findById(){
        User user1 = userService.findById(1);

        return user1;
    }
}
