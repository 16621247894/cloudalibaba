package com.zwq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zwq.domain.BusinessVO;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

import java.util.Map;

/**
 * 这里定义tcc的接口
 * 一定要定义在接口上
 * 我们使用springCloud的远程调用
 * 那么这里使用LocalTCC便可
 *
 * @author zhuwuqing
 */
@LocalTCC
public interface BusinessService extends IService<BusinessVO> {
    /**
     * 定义两阶段提交
     * name = insert为一阶段try方法
     * commitMethod = commit 为二阶段确认方法
     * rollbackMethod = rollback 为二阶段取消方法
     * BusinessActionContextParameter注解 可传递参数到二阶段方法
     *
     * @param params -入参
     * @return String
     */
    @TwoPhaseBusinessAction(name = "businessTransfer", commitMethod = "commitBusinessTcc", rollbackMethod = "rollbackBusinessTcc")
    boolean businessTransfer(BusinessActionContext businessActionContext,
                             @BusinessActionContextParameter(paramName = "params") Map<String, Object> params
    ) throws Exception;

    /**
     * 确认方法、可以另命名，但要保证与commitMethod一致
     * context可以传递try方法的参数
     *
     * @param context 上下文
     * @return boolean
     */
    boolean commitBusinessTcc(BusinessActionContext context) throws Exception;

    /**
     * 二阶段取消方法
     *
     * @param context 上下文
     * @return boolean
     */
    boolean rollbackBusinessTcc(BusinessActionContext context) throws Exception;
}
