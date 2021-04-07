package com.zwq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zwq.domain.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface AccountService extends IService<Account> {



    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
