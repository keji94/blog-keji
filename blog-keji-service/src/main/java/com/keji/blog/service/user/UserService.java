package com.keji.blog.service.user;

import com.keji.blog.dataobject.BlogUser;
import com.keji.blog.result.BaseResult;

import java.util.List;

/**
 * Created by keji on 2017/7/31.
 */

public interface UserService {
    BaseResult register(BlogUser user);

    BaseResult<List<BlogUser>> existUser(BlogUser user);

    BlogUser showUserData(String userName);

    BaseResult updateUser(BlogUser user);
}
