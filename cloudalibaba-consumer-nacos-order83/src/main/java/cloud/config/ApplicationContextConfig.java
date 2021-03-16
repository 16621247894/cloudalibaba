package cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced  //加上该注解赋予了负载均衡的能力  默认是轮询的方式
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
