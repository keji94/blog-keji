package com.keji.blog.service.user.impl;

import com.keji.blog.mapper.BlogUserMapper;
import com.keji.blog.dataobject.BlogUser;
import com.keji.blog.dataobject.BlogUserExample;
import com.keji.blog.result.BaseResult;
import com.keji.blog.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public BaseResult<List<BlogUser>> existUser(BlogUser user) {
        BlogUserExample example = new BlogUserExample();
        BlogUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        criteria.andUserPasswordEqualTo(user.getUserPassword());
        List<BlogUser> userList = userMapper.selectByExample(example);
        if (userList != null && userList.size() == 1){
            return BaseResult.ok(userList);
        }
        return BaseResult.makeFail();
    }

    public BlogUser showUserData(String userName) {
        BlogUserExample example = new BlogUserExample();
        BlogUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<BlogUser> list = userMapper.selectByExample(example);
        if (list != null && list.size() == 1){
            return list.get(0);
        }
        return null;
    }

    public BaseResult updateUser(BlogUser user) {
        BlogUserExample example = new BlogUserExample();
        BlogUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        try {
            userMapper.updateByExampleSelective(user,example);
        } catch (Exception e) {
            log.error("userMapper.updateByPrimaryKeySelective is error...",e);
            return BaseResult.makeFail();
        }
        return BaseResult.ok();
    }


}
