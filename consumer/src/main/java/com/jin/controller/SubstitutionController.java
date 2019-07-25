package com.jin.controller;

import com.jin.domain.HouseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/substitution")
public class SubstitutionController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/callHello")
    public String callHello(){
        //如果restTemplate 已配置LoadBalanced注解，则只能使用服务名，不能使用localhost
        //反之，则只能使用localhost
        String url="http://localhost:8081/house/hello";
        String url2="http://fangjia-provider/house/hello";
        String result= restTemplate.getForObject(
                url2,String.class
        );
        System.out.println("new request =====:"+result);
        return result;
    }

    @GetMapping("/save")
    public Long add(){
        HouseInfo info=new HouseInfo();
        info.setCity("上海");
        info.setAddress("虹口");
        info.setStreet("xx");
        Long id =restTemplate.postForObject(
                "http://localhost:8081/house/save",info,Long.class
        );
        return  id;
    }

}
