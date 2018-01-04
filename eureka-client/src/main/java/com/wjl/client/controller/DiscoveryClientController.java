package com.wjl.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscoveryClientController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/disconver")
    public String getDiscoveryInfo() throws InterruptedException{

        // 添加这个是为了测试(容错降级的操作， 这个其实也是可以打断点进行操作)
//        Thread.sleep(5000L);
        // 获取服务列表清单
        String service =  "Server "+discoveryClient.getServices();

        System.out.println("eureka-client=======>>>>>>>>"+service);

        return service;
    }
}
