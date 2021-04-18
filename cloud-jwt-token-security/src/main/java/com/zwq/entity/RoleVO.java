package com.zwq.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sec_role")
public class RoleVO {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    @TableField(value = "name",fill = FieldFill.DEFAULT)
    private String name;
    @TableField(value = "description",fill = FieldFill.DEFAULT)
    private String description;
    @TableField(value = "create_time",fill = FieldFill.DEFAULT)
    private Long create_time;
    @TableField(value = "update_time",fill = FieldFill.DEFAULT)
    private Long update_time;
}
