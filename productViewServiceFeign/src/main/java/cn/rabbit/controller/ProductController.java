package cn.rabbit.controller;

import cn.rabbit.pojo.Product;
import cn.rabbit.service.ProductServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//注解@RefreshScope作用： 让在application.properties里自定义的变量也能通过@Value 注解正常注入
@RefreshScope
public class ProductController {
    //增加这个属性，就可以从 configServer 去获取 version 信息了。
    @Value("${version}")
    private String version;

    @Autowired
    private ProductServiceFeign productServiceFeign;

    @RequestMapping("/listProduct")
    public String listProduct(Model m) {
        List<Product> products = productServiceFeign.listProduct();
        m.addAttribute("ps", products);

        m.addAttribute("version", version);
        return "listProduct";
    }
}
