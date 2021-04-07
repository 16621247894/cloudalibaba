package com.zwq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwq.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountMapper extends  BaseMapper<Account> {
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);

}
