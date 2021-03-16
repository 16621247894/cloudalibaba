package cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    // 2个方法不一样 参数前有没有/
/*
    @GetMapping("consumer/payment/nacos{id}")
    public String paymentInfo(@PathVariable("id") Long id){

        return restTemplate.getForObject(serverUrl+"/payment/nacos/"+id,String.class);
    }*/
    @GetMapping("consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id){

        return restTemplate.getForObject(serverUrl+"/payment/nacos/"+id,String.class);
    }


    @GetMapping("test")
    public String test(){
        System.out.println("hehe");
        return "xxx";
    }
}
