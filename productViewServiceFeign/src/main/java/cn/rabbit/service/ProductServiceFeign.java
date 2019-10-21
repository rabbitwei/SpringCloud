package cn.rabbit.service;

import cn.rabbit.client.ProductClientFeign;
import cn.rabbit.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceFeign {
    @Autowired
    private ProductClientFeign productClientFeign;

    public List<Product> listProduct() {
        return productClientFeign.listProduct();
    }
}
