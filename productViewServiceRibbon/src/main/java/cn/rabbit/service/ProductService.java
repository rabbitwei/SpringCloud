package cn.rabbit.service;

import cn.rabbit.client.ProductClientRibbon;
import cn.rabbit.pojo.Product;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//服务类，数据从 ProductClientRibbon 中获取
@Service
public class ProductService {
    @Autowired
    private ProductClientRibbon productClientRibbon;

    public List<Product> listProudct() {
        return productClientRibbon.listProduct();
    }
}
