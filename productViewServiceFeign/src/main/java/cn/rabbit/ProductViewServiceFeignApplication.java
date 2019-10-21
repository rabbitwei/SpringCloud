package cn.rabbit;


import brave.sampler.Sampler;
import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient      //表示用于发现注册中心的微服务
@EnableFeignClients         // 表示用于使用 Feign 方式， 即表示该应用是 Feign 客户端
public class ProductViewServiceFeignApplication 
{
    public static void main( String[] args )
    {
        int port = 8012;
        if (!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(ProductViewServiceFeignApplication.class).run(args);
    }

    //链路追踪的设置
    //配置 Sampler 抽样策略： ALWAYS_SAMPLE 表示持续抽样
    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
