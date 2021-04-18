package com.zwq.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zwq.entity.UserVO;
import com.zwq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("执行登录逻辑");
        // 1.根据用户名去查询数据库中的信息
        UserVO vo = userService.getOne(new QueryWrapper<UserVO>().eq("username", username));
        if (vo == null) {
            System.out.println("没有找到用户名");
            throw new UsernameNotFoundException("用户名在数据库中没有找到-------！");
        }

        // 比较密码  因为注册的时候密码已经在数据库中加密过的
        //passwordEncoder.matches()
        String pwd = passwordEncoder.encode("123");
       // System.out.println("pwd:"+pwd);
        //commaSeparatedStringToAuthorityList 里面是字符串 根据,分割   admin,normal是权限    ROLE_abc 是角色  必须ROLE_   表示下面有abc这个角色
        return new User(username, pwd, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal,ROLE_abc,/,/index"));
    }
}
