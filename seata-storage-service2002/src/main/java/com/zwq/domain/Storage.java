package com.zwq.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_storage")
public class Storage {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    @TableField(value = "product_id",fill = FieldFill.DEFAULT)
    private Long productId;
    @TableField(value = "total",fill = FieldFill.DEFAULT)
    private Long total;
    @TableField(value = "used",fill = FieldFill.DEFAULT)
    private Long used;
    @TableField(value = "residue",fill = FieldFill.DEFAULT)
    private BigDecimal residue;

}
