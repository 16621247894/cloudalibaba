package com.zwq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

import java.net.UnknownHostException;

@EnableAsync
@SpringBootApplication
@EnableDiscoveryClient
public class StorageMian2002 {
    public static void main(String[] args)throws UnknownHostException {

        SpringApplication.run(StorageMian2002.class,args);
        // Springboot启动模板
        /*ConfigurableApplicationContext applicationContext = SpringApplication.run(StorageMian2002.class, args);
        Environment env = applicationContext.getEnvironment();

        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        System.out.println("\n----------------------------------------------------------\n\t" +
                "Application 工程启动成功 is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "\n" +
                "----------------------------------------------------------\n");*/

    }
}
