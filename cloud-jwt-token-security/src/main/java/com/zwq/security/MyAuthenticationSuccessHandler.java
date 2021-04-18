package com.zwq.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义登录成功的页面 可以跳转到外面
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private String url;

    public MyAuthenticationSuccessHandler(String url){
        this.url=url;
    }
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("获取的ip:"+httpServletRequest.getRemoteAddr());
        User principal = (User) authentication.getPrincipal();
        System.out.println(principal.getUsername());
        // 密码会输出null
        System.out.println(principal.getPassword());
        System.out.println(principal.getAuthorities());



        httpServletResponse.sendRedirect(url);
    }
}
