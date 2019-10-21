package cn.rabbit.controller;

import cn.rabbit.pojo.Product;
import cn.rabbit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//控制器，把数据取出来放在 listProduct.html 中
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/listProduct")
    public String listProduct(Model m) {
        List<Product> products = productService.listProudct();
        m.addAttribute("ps", products);
        return "listProduct";
    }
}
