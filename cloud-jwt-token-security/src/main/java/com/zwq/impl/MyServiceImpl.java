package com.zwq.impl;

import com.zwq.service.MyService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * 自定义权限
 */
@Service
public class MyServiceImpl implements MyService {
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        // 获取主体
        Object obj=authentication.getPrincipal();
        if(obj instanceof UserDetails){
            UserDetails userDetails=(UserDetails) obj;
            // 拿到权限列表 看有没有包含请求过来的url地址
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            // request.getRequestURI() 就是请求的url 接口的方法requestMapping里面的，   authorities就是UserDetails里面自定义封装的权限信息
            // new User(username, pwd, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal,ROLE_abc,/,/index"));
            System.out.println("request.getRequestURI():"+request.getRequestURI());
            return authorities.contains(new SimpleGrantedAuthority(request.getRequestURI()));
        }
        return false;
    }
}
