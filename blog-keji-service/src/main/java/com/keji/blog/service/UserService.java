package com.keji.blog.service;

import com.blog.keji.pojo.User;
import com.blog.keji.query.UserQueryVo;
import com.keji.blog.dao.UserDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wb-ny291824 on 2017/6/29.
 */
@Service
public class UserService {

    @Autowired
    private UserDaoMapper userDaoMapper;

    public int check(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserQueryVo userQueryVo = new UserQueryVo();
        userQueryVo.setUser(user);
        List<User> users = userDaoMapper.check(userQueryVo);
        System.out.println(users);
        return 0;
    }
}
