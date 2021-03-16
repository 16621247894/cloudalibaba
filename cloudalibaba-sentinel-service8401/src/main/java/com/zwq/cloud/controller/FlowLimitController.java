package com.zwq.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @GetMapping("testA")
    public String getTest(){

        // 直接 例子
       /* try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        return  "Test A";
    }



    @GetMapping("testB")
    public String getTestB(){

        return  "Test B.......";
    }
}
