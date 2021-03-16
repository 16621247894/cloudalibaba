package com.zwq.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @SentinelResource("dosomething")
    public void getInfo(String str){
        System.out.println("调用者"+str+"调用getInfo方法");
    }


    @GetMapping("info1")
    public String info1(){
        this.getInfo("info1");
        return "info1";
    }

    @GetMapping("info2")
    public String info2(){
        this.getInfo("info2");
        return "info2";
    }




}
