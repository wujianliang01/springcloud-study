package wjl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EurekaConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumerRibbon")
    public String getEurekaConsumerInfo(){

        return restTemplate.getForObject("http://eureka-client/disconver", String.class);
    }

}
