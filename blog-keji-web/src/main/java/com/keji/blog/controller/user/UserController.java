package com.keji.blog.controller.user;

import com.keji.blog.pojo.BlogUser;
import com.keji.blog.result.BaseResult;
import com.keji.blog.service.user.UserService;
import com.keji.blog.util.BlogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by wb-ny291824 on 2017/8/7.
 */
@Controller
@Slf4j
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private HttpServletRequest request;
    @Resource
    private HttpSession session;

    @RequestMapping("/register")
    @ResponseBody
    public BaseResult register(BlogUser user) {
        String ipAddr = BlogUtil.getIpAddr(request);
        user.setUserIp(ipAddr);
        user.setUserStatus(false);
        user.setUserCreated(new Date());
        user.setUserUpdated(new Date());
        BaseResult result = null;
        try {
            result = userService.register(user);
        } catch (Exception e) {
            log.error("userService.register is error",e);
            return result;
        }
        return  result;
    }

    @ResponseBody
    @RequestMapping("/login")
    public BaseResult login(BlogUser user){


        BaseResult<List<BlogUser>> result = userService.existUser(user);

        if (result.getStatus() != 200){
            return  result;
        }
        List<BlogUser> userList = result.getData();
        //登录成功，放入sessio
        session.setAttribute("username",userList.get(0).getUserNickname());

        String ipAddr = BlogUtil.getIpAddr(request);
        if (ipAddr != userList.get(0).getUserIp() ){
            //ip不同，做点事情
        }

        return BaseResult.ok();
    }

}
