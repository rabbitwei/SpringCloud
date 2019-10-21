package cn.rabbit.controller;


import cn.rabbit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


//表示返回的结果是 json 数据
@RestController         //@RestController 是 @ResponseBody 和 @Controller 的集合
public class ProductController {
    @Resource
    private ProductService productService;

    @RequestMapping("/listProduct")
    public Object listProduct() {
        return productService.listProduct();
    }
}
