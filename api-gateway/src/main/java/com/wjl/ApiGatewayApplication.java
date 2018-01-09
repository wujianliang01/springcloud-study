package com.wjl;

import com.wjl.fifter.AccessFifter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WuJianLiang
 * @Date: Created in 2018-01-04 16:25
 * @Description: 构建服务网关
 **/

@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayApplication {

    public static void main(String args[]){

       new SpringApplicationBuilder(ApiGatewayApplication.class).web(true).run(args);

       System.out.println("ApiGatewayApplication  Start  Success......");

    }

    @Bean
    public AccessFifter accessFifter(){
        return  new AccessFifter();
    }

}
