package wjl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import wjl.service.ConsumerService;

@RestController
public class EurekaConsumerRibbonHystrixController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/consumerRibbonHystrix")
    public String getEurekaConsumerInfo(){

        return consumerService.consumerRibbonHystrix();
    }

}
