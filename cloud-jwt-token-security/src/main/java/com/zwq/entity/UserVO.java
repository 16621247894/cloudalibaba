package com.zwq.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sec_user")
public class UserVO implements UserDetails {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    @TableField(value = "username",fill = FieldFill.DEFAULT)
    private String username;
    @TableField(value = "password",fill = FieldFill.DEFAULT)
    private String password;
    @TableField(value = "nickname",fill = FieldFill.DEFAULT)
    private String nickname;
    @TableField(value = "phone",fill = FieldFill.DEFAULT)
    private String phone;
    @TableField(value = "email",fill = FieldFill.DEFAULT)
    private String email;
    @TableField(value = "birthday",fill = FieldFill.DEFAULT)
    private Long birthday;
    @TableField(value = "sex",fill = FieldFill.DEFAULT)
    private int sex;
    @TableField(value = "status",fill = FieldFill.DEFAULT)
    private int status;
    @TableField(value = "create_time",fill = FieldFill.DEFAULT)
    private Long create_time;
    @TableField(value = "update_time",fill = FieldFill.DEFAULT)
    private Long update_time;

    /**
     * 权限
     */
    @TableField(exist = false)
    private Set<String> permissionValueList;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

