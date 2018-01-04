package wjl;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringCloudApplication
public class EurekaConsumerRibbonHystrixApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String args[]){

//        SpringApplication.run(EurekaConsumerApplication.class,args);
          new SpringApplicationBuilder(EurekaConsumerRibbonHystrixApplication.class).web(true).run(args);
          System.out.println("EurekaConsumerRibbonHystrixApplication Start Success...");

    }
}
