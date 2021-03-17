package com.zwq.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
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
        System.out.println("调用B");
        log.info(Thread.currentThread().getName()+" \t\t testB");
        return  "Test B.......";
    }

    @GetMapping("/testD")
    public String testD()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {e.printStackTrace();}
        log.info(Thread.currentThread().getName()+"\t"+"...testD 测试RT");
        return "------testD 测试RT";
    }


}
