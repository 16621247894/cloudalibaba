package com.zwq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwq.domain.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface StorageMapper extends BaseMapper<Storage> {

    void decrease(@Param("productId") Long productId, @Param("count")Integer count);
}
