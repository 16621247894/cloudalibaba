package com.zwq.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sec_role_permission")
public class RolePermissionVO {

    @TableField(value = "role_id",fill = FieldFill.DEFAULT)
    private Long role_id;
    @TableField(value = "permission_id",fill = FieldFill.DEFAULT)
    private Long permission_id;
}
