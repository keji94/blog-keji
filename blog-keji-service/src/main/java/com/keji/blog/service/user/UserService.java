package com.keji.blog.service.user;

import com.keji.blog.pojo.BlogUser;
import com.keji.blog.result.BaseResult;

import java.util.List;

/**
 * Created by keji on 2017/7/31.
 */

public interface UserService {
    BaseResult register(BlogUser user);

    BaseResult<List<BlogUser>> existUser(BlogUser user);
}
