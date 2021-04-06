package com.zwq.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwq.domain.Storage;
import com.zwq.mapper.StorageMapper;
import com.zwq.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StorageImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        storageMapper.decrease(productId,count);
    }
}
