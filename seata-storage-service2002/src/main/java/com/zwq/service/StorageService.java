package com.zwq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zwq.domain.Storage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public interface StorageService extends IService<Storage> {

    //需要一个扣减库存的方法
    void decrease(@RequestParam("productId") Long productId, @Param("count")Integer count);
}
