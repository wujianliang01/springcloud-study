package com.wjl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConsumerApplication {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String args[]){

//        SpringApplication.run(EurekaConsumerApplication.class,args);
          new SpringApplicationBuilder(EurekaConsumerApplication.class).web(true).run(args);
        System.out.println("EurekaConsumerApplication Start Success...");

    }
}
