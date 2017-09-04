package com.keji.blog.controller.solr;

import com.keji.blog.dataobject.ResultModel;
import com.keji.blog.service.solr.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wb-ny291824 on 2017/8/14.
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/list")
    public String productSearch(String queryString, String catalog_name, String price,
                                String sort, Integer page, Model model) throws Exception {
        //调用服务查询商品列表
        ResultModel resultModel = productService.queryProduct(queryString, catalog_name, price, sort, page);
        //传递给页面
        model.addAttribute("queryString", queryString);
        model.addAttribute("catalog_name", catalog_name);
        model.addAttribute("price", price);
        model.addAttribute("sort", sort);
        model.addAttribute("page", page);
        model.addAttribute("result", resultModel);
        //返回逻辑视图
        return "product_list";
    }
}
