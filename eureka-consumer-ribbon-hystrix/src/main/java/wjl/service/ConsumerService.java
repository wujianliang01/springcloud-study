package wjl.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *@Author:WuJianLiang
 *@Description:
 *@Date: Created in Administrator-No such property: code for class: Script1-17:24 2018/1/2
 */
@Service
public class ConsumerService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 进行容错降级（fallbackMethod 后面的是容错要调用的方法）
     * @return
     */

    @HystrixCommand(fallbackMethod = "fallback")
    public String consumerRibbonHystrix(){

        return restTemplate.getForObject("http://eureka-client/disconver", String.class);

    }

    /**
     * 调用失败后进行降级到这个方法
     * @return
     */

    public String fallback(){
        return "fallback..........";
    }

}
