package com.zwq.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_order")
public class Order {
    /**
     * 主键Id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    @TableField(value = "user_id",fill = FieldFill.DEFAULT)
    private Long userId;
    @TableField(value = "product_id",fill = FieldFill.DEFAULT)
    /**
     * 数量
     */
    private Long productId;
    @TableField(value = "count",fill = FieldFill.DEFAULT)
    private Integer count;
    @TableField(value = "money",fill = FieldFill.DEFAULT)
    private BigDecimal money;
    /**
     * 订单状态  0创建中    1已完成
     */
    @TableField(value = "status",fill = FieldFill.DEFAULT)
    private Integer status;
}
