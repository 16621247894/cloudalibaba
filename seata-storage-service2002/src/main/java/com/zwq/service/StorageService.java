package com.zwq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zwq.domain.Storage;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service

public interface StorageService extends IService<Storage> {

    /**
     * 减库存的方法
     *
     * @param productId 商品id
     * @param count     数量
     */
    @TwoPhaseBusinessAction(name = "decrease", commitMethod = "commitTcc", rollbackMethod = "cancel")
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

    void getInfo();
    /**
     * 确认方法、可以另命名，但要保证与commitMethod一致
     * context可以传递try方法的参数
     *
     * @param context 上下文
     * @return boolean
     */
    //boolean commitTcc(BusinessActionContext context);

    /**
     * 二阶段取消方法
     *
     * @param context 上下文
     * @return boolean
     */
    //boolean cancel(BusinessActionContext context);
}
