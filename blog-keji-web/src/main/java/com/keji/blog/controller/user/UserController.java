package com.keji.blog.controller.user;

import com.keji.blog.pojo.BlogUser;
import com.keji.blog.result.BaseResult;
import com.keji.blog.service.user.UserService;
import com.keji.blog.util.BlogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by wb-ny291824 on 2017/8/7.
 */
@Controller
@Slf4j
@ResponseBody
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private HttpServletRequest request;
    @Resource
    private HttpSession session;

    @RequestMapping("/register")
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


    @RequestMapping("/login")
    public BaseResult login(BlogUser user){
        BaseResult<List<BlogUser>> result = userService.existUser(user);

        if (result.getStatus() != 200){
            return  result;
        }
        List<BlogUser> userList = result.getData();
        String nickname = userList.get(0).getUserNickname();
        //登录成功，放入sessio
        session.setAttribute("username",nickname);
        String ipAddr = BlogUtil.getIpAddr(request);
        if (ipAddr != userList.get(0).getUserIp() ){
            //ip不同，做点事情
        }
        return BaseResult.ok();
    }

    @RequestMapping("/showUserData")
    public BaseResult showUserData(@RequestBody String userName) {
        if (userName == null) {
            return BaseResult.makeFail("参数错误");
        }

        BlogUser user = userService.showUserData(userName);

        if (user == null){
            return BaseResult.makeFail("系统错误");
        }
        return BaseResult.ok(user);
    }

    @RequestMapping("/updateUser")
    public BaseResult updateUser(BlogUser user, MultipartFile pic) {
        if (user == null){
            return BaseResult.makeFail("参数错误");
        }
        if (pic == null){
            return BaseResult.makeFail("参数错误");
        }

        //处理图片
        BaseResult<String> resultFile = handlePic(pic);
        if (resultFile.getStatus() != 200){
            return BaseResult.makeFail("上传失败");
        }
        user.setUserPicture(resultFile.getData());
        try {
            BaseResult result = userService.updateUser(user);
        } catch (Exception e) {
            log.error("userService.updateUser is error...");
            return BaseResult.makeFail();
        }
        return BaseResult.ok();
    }

    /**
     * 上传存到磁盘之后，页面的展示还是用图片服务器吧。
     * @param pic
     * @return
     */
    private BaseResult<String> handlePic(MultipartFile pic) {

        //原文件名称
        String originalFilename = pic.getOriginalFilename();
        //新文件名称
        String newName =UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        //写入磁盘
        File uploadPic = new File("D:/develop/upload/temp/" + newName);

        if (!uploadPic.exists()){
            uploadPic.mkdirs();
        }

        //向磁盘写文件
        try {
            pic.transferTo(uploadPic);
        } catch (IOException e) {
            log.error("pic.transferTo is error ...",e);
            return BaseResult.makeFail();
        }
        return BaseResult.ok(newName);
    }
}
