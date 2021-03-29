package com.zwq.cloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zwq.springcloud.common.entity.CommonResult;
import com.zwq.springcloud.common.entity.Payment;

public class CustomerBlockHandler {

    /**
     * 全局降级方法1  必须是static
     * @param exception
     * @return
     */
    public static CommonResult handlderException(BlockException exception) {
        return new CommonResult(4444, "自定义,global handlderException-------1");
    }

    /**
     * 全局降级方法2
     * @param exception
     * @return
     */
    public static CommonResult handlderException2(BlockException exception) {
        return new CommonResult(4444, "自定义,global handlderException-------2");
    }

}
