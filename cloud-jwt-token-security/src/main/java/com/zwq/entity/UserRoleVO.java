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
@TableName("sec_user_role")
public class UserRoleVO {
    @TableField(value = "user_id",fill = FieldFill.DEFAULT)
    private Long user_id;
    @TableField(value = "role_id",fill = FieldFill.DEFAULT)
    private Long role_id;


}
