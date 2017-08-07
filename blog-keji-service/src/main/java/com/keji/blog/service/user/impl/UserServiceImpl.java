package com.keji.blog.service.user.impl;

import com.keji.blog.mapper.BlogUserMapper;
import com.keji.blog.pojo.BlogUser;
import com.keji.blog.result.BaseResult;
import com.keji.blog.service.user.UserService;
import com.keji.blog.util.BlogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wb-ny291824 on 2017/6/29.
 */
@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private BlogUserMapper userMapper;

    public BaseResult register(BlogUser user) {
        try {
            userMapper.insert(user);
        } catch (Exception e) {
            log.error("userMapper.insert is error...",e);
            return BaseResult.makeFail("注册失败");
        }
        return BaseResult.ok();
    }


}
