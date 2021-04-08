package com.zwq.controller;

import com.zwq.domain.CommonResult;
import com.zwq.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public CommonResult update(@RequestParam("productId") Long productId,@RequestParam("count") Integer count ){
        storageService.decrease(productId,count);
        return new CommonResult(200,"扣减库存成功");

    }

    /**
     * 测试异步请求  Async当启动类上没有加EnableAsync 是同步请求 加了EnableAsync是异步请求 ，并不能直接加在controller层
     * @Async 用在controller 会造异步的成线程不安全问题，直接忽略返回结果
     * @Async 应该用在impl层 返回值为void类型 不需要返回值
     *
     * @return
     */
    @GetMapping("testAsync")
    public CommonResult AsyncTest(){
        // 会造成县城不安全 使用for循环
        storageService.getInfo();
        return new CommonResult(200,"请求成功");
    }


}
