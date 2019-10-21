package cn.rabbit.controller;

import cn.rabbit.pojo.Product;
import cn.rabbit.service.ProductServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductServiceFeign productServiceFeign;

    @RequestMapping("/listProduct")
    public String listProduct(Model m) {
        List<Product> products = productServiceFeign.listProduct();
        m.addAttribute("ps", products);
        return "listProduct";
    }
}
