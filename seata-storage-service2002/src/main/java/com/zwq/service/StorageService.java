package com.zwq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zwq.domain.Storage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface StorageService extends IService<Storage> {

    //需要一个扣减库存的方法
    void decrease(@Param("productId") Long productId, @Param("count")Integer count);
}
