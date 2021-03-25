package com.zwq.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    {/*
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {e.printStackTrace();}
        log.info(Thread.currentThread().getName()+"\t"+"...testD 测试RT");
        */
        int age=10/0;
        log.info(Thread.currentThread().getName()+"\t"+"...testD 测试异常比例");
        return "------testD 测试RT";
    }

    /**
     *
     * @param p1 p1参数 作为热点数量
     * @param p2 p2参数
     *           SentinelResource 最好喝getmapping一样，对sentinel暴露的资源名   deal_testHotkey就是兜底方法
     * @return
     */
    @GetMapping("testHotkey")
    @SentinelResource(value = "testHotkey",blockHandler = "deal_testHotkey")
    //@SentinelResource(blockHandler = "deal_testHotkey")  // 例子1
    //@SentinelResource(value = "testHotkey")           //例子2
    // 例子1 和例子2  不要使用  禁止使用  例子2这样用户效果差，  例子1不会执行监控到。   资源名一定要testHotkey  不要用/testHotkey

    public String testHotkey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        log.info(Thread.currentThread().getName()+"调用");
        return "------testHotkey testHotkey";
    }

    /**
     * 默认提示报错是 Blocked by Sentinel (flow limiting)
     * @param p1
     * @param p2
     * @param blockException
     * @return
     */
    public String deal_testHotkey(String p1, String p2, BlockException blockException){
        return "deal_testHotkey 兜底方法";
    }
}


