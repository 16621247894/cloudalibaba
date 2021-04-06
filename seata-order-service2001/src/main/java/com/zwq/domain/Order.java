package com.zwq.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    /**
     * 主键Id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    @TableField(value = "user_id",fill = FieldFill.DEFAULT)
    private Long userId;
    @TableField(value = "product_id",fill = FieldFill.DEFAULT)
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
