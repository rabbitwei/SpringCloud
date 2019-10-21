package cn.rabbit.client;

import cn.rabbit.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

/*
Feign 客户端， 通过 注解方式 访问 访问 productDataService 服务的 listProduct 路径，
 productDataService 既不是域名也不是ip地址，而是 数据服务在 eureka 注册中心的名称。
 */

//这里就是访问微服务，然后从微服务的指定路径获取到 数据
@FeignClient(value="PRODUCTDATASERVICE")        //表示使用 Feign 来访问 指定名称的微服务
public interface ProductClientFeign {
    @GetMapping("/listProduct")                 //访问微服务的哪个路径
    List<Product> listProduct();
}
