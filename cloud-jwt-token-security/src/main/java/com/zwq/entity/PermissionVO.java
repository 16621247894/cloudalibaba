package com.zwq.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sec_permission")
public class PermissionVO {
    /**
     * 主键Id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id ;
    @TableField(value = "name",fill = FieldFill.DEFAULT)
    private String name;
    @TableField(value = "url",fill = FieldFill.DEFAULT)
    private String url;
    @TableField(value = "type",fill = FieldFill.DEFAULT)
    private int type;
    @TableField(value = "permission",fill = FieldFill.DEFAULT)
    private String permission;
    @TableField(value = "method",fill = FieldFill.DEFAULT)
    private String method;
    @TableField(value = "sort",fill = FieldFill.DEFAULT)
    private Long sort;
    @TableField(value = "parent_id",fill = FieldFill.DEFAULT)
    private Long parent_id;



}
