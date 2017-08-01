package com.keji.blog.mapper;

import com.keji.blog.pojo.User;
import com.keji.blog.query.UserQueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wb-ny291824 on 2017/6/29.
 */

@Repository
public interface UserDaoMapper {
    List<User> check(UserQueryVo userQueryVo);
}
