package com.zwq.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class TestPwd {

    public static void main(String[] args) {
        PasswordEncoder pwd=new BCryptPasswordEncoder();
        // 加密
        String encode=pwd.encode("123456");
        System.out.println("加密后的结果为:"+encode);
        // 验证
        boolean res=pwd.matches("123456",encode);
        System.out.println("验证结果:"+res);


    }
}
