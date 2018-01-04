package com.wjl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

    public static void main(String args[]) {

        // 因为在pom 中引入了spring-boot-starter-web, 所以使用下面的方式启动
        SpringApplication.run(EurekaApplication.class, args);

        // 没有引入上面的包使用下面的方式进行启动
//        new SpringApplicationBuilder(EurekaApplication.class).web(true).run(args);

        System.out.println ("EurekaApplication  Start Success...");
    }
}
