package com.zwq.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.google.errorprone.annotations.NoAllocation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 工商银行
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("business_bank_account")
public class BusinessVO {

    @TableId(value = "business_id",type = IdType.AUTO)
    private int businessId;

    /**
     * 账户余额
     */
    @TableField(value = "business_amount",fill = FieldFill.DEFAULT)
    private int businessAmount;

    /**
     * 冻结金额
     */
    @TableField(value = "freezed_amount",fill = FieldFill.DEFAULT)
    private int freezedAmount;


}
