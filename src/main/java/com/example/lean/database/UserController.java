package com.example.lean.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/add")
    public Response add(@RequestParam("userId") String userId,
                        @RequestParam("userName") String userName, @RequestParam("sex") String sex,
                        @RequestParam("age") int age){

        User user=User.builder().userId(userId).userName(userName).sex(sex).age(age).build();

        userDao.insertUser(user);
        return new Response("test");
    }


    @GetMapping("/get")
    public Response get(@RequestParam("userId") String userId){

        User user= userMapper.queryUserByUserid(userId);
        return new Response(user.toString());
    }
}
