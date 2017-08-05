package com.keji.blog.controller.content;

import com.keji.blog.pojo.TbContentCategory;
import com.keji.blog.result.BaseResult;
import com.keji.blog.service.content.ContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-ny291824 on 2017/8/1.
 * 网站内容管理Controller
 */
@Controller
@ResponseBody
@Slf4j
@RequestMapping("/content")
public class ContentController {

    @Resource
    private ContentService contentService;

    /**
     * TODO 为tb_content_category表增加新字段url,使用逆向工程重新生成pojo和mapper文件
     * @return
     */
    @RequestMapping("/showCategory")
    public BaseResult<List<TbContentCategory>> showCategory() {
        BaseResult<List<TbContentCategory>> result = null;
        try {
            result= contentService.showCategory();
        } catch (Exception e) {
            log.error("contentService.showCategory() is error...",e);
            return BaseResult.makeFail();
        }
        return BaseResult.ok(result.getData());
    }

}
