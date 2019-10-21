package cn.rabbit.client;

import cn.rabbit.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/*
Ribbon 客户端， 通过 restTemplate 访问 http://PRODUCTDATASERVICE/products ，
而 productDataService 既不是域名也不是ip地址，而是 数据服务在 eureka 注册中心的名称。
 */
@Component
public class ProductClientRibbon {
    @Autowired
    private RestTemplate restTemplate;

    @SuppressWarnings("unchecked")
    public List<Product> listProduct() {
        //注意看，这里只是指定了要访问的 微服务名称和访问的路径，但是并没有指定端口号到底是 8001, 还是 8002.
        return restTemplate.getForObject("http://PRODUCTDATASERVICE/listProduct", List.class);
    }
}
