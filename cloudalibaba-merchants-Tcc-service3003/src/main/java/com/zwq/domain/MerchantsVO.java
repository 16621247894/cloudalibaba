package com.zwq.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("merchants_bank_account")
public class MerchantsVO {

    @TableId(value = "merchants_id",type = IdType.AUTO)
    private int merchantsId;

    /**
     * 账户余额
     */
    @TableField(value = "merchants_amount",fill = FieldFill.DEFAULT)
    private int merchantsAmount;

    /**
     * 冻结金额
     */
    @TableField(value = "freezed_amount",fill = FieldFill.DEFAULT)
    private int freezedAmount;
}
