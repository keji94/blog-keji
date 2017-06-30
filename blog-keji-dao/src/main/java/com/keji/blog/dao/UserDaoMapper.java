package com.keji.blog.dao;

import com.blog.keji.pojo.User;
import com.blog.keji.query.UserQueryVo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wb-ny291824 on 2017/6/29.
 */

@Repository
public interface UserDaoMapper {
    List<User> check(UserQueryVo userQueryVo);
}
