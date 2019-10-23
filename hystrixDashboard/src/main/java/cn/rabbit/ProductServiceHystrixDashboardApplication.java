package cn.rabbit;


import cn.hutool.core.util.NetUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication

//断路器监控启动类，主要就是@EnableHystrixDashboard 这个
@EnableHystrixDashboard
public class ProductServiceHystrixDashboardApplication
{
    public static void main( String[] args )
    {
        int port = 8020;
        if (!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用了，无法启动%n", port );
            System.exit(1);
        }
        new SpringApplicationBuilder(ProductServiceHystrixDashboardApplication.class).run(args);
    }
}
