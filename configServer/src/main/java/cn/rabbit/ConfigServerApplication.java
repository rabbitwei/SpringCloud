package cn.rabbit;


import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication      //表示这是一个 SpringBootApplication 应用
@EnableEurekaClient         //Eureka客户端
@EnableDiscoveryClient      //表示用于发现 eureka 注册中心的微服务。
@EnableConfigServer         //这个注解表示本 springBoot 是个配置服务器。
public class ConfigServerApplication
{
    public static void main( String[] args )
    {
        int port = 8030;        //默认端口是8030
        if (!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(ConfigServerApplication.class).run(args);
    }
}
