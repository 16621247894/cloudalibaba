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
public class Account {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    @TableField(value = "user_id",fill = FieldFill.DEFAULT)
    private Long userId;
    @TableField(value = "total",fill = FieldFill.DEFAULT)
    private BigDecimal total;
    @TableField(value = "used",fill = FieldFill.DEFAULT)
    private BigDecimal used;
    @TableField(value = "residue",fill = FieldFill.DEFAULT)
    private BigDecimal residue;

}
