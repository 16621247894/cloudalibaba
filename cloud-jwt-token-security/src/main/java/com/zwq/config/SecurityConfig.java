package com.zwq.config;


import com.zwq.security.MyAccessDeniedHandler;
import com.zwq.security.MyAuthenticationFailureHandler;
import com.zwq.security.MyAuthenticationSuccessHandler;
import com.zwq.security.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * EnableWebSecurity 是开启SpringSecurity
 * EnableGlobalMethodSecurity 开启注解模式,securedEnabled是表示securedEnabled角色注解，prePostEnabled是表示prePostEnabled注解
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    //声明bean
    @Bean
    public PasswordEncoder getPw() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        //自动建表 第一次开启时开启，第二次的时候关闭， 因为第二次创建的时候表已经存在了 persistent_logins
        //jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

    /**
     * 做记住我来使用dataSource和jdbcTokenRepository,userDetailService
     */
    @Autowired
    private DataSource dataSource;
    @Autowired
    private PersistentTokenRepository jdbcTokenRepository;
    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;

    /**
     * 配置自定义登录页面  http.formLogin().loginPage("/views/login.html");
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 自定义登录页面
        http.formLogin()
                .loginPage("/toLogin")
                //必须和form表单提交的接口地址一样
                .loginProcessingUrl("/login")
                //设置用户名密码参数
                .usernameParameter("loginName").passwordParameter("password")
                // 默认页面
                .defaultSuccessUrl("/")
                // 登录成功跳转的页面  重定向页面 必须post请求
                //.successForwardUrl("/")
                // 自定义登录成功拦截器
                //.successHandler(new MyAuthenticationSuccessHandler("http://www.baidu.com"))
                // 登录失败的页面 需要下面放行才可以
                .failureForwardUrl("/fail")
        //自定义登录失败处理器 重定向页面 如果是外面的路径 不需要设置放行 如果是内部的需要设置放行处理
        //.failureHandler(new MyAuthenticationFailureHandler("/failResp"))
        ;

        // 注销  logoutUrl注销的方法，前端和要这个一致
        http.logout().logoutUrl("/myLogout")
                //注销成功跳转的页面
                .logoutSuccessUrl("/toLogin");


        // 前端提交的请求方式必须是post  如果不是 需要在后端设置
        // 授权
        // 所有的请求都必须登录 像拦截器
        http.authorizeRequests()
                // 放行 不需要认证的配置  toLogin是页面  /login是登录的接口
                .antMatchers("/toLogin", "/fail", "/failResp").permitAll()
                // 静态页面css js放行
                //.antMatchers("/css/**", "/js/**").permitAll()
                // 图片放行
                .antMatchers("/**/**.png").permitAll()
                .antMatchers("/test/**").permitAll()
                //放行的第二种写法
                .antMatchers("/**/**.png", "/**/**.jpg").access("permitAll")

                //配置/admin 需要admin权限 大小写严格区分   hasRole是拥有admin角色
                //.antMatchers("/toAdmin").hasRole("admin")
                // hasAnyAuthority拥有admin权限  可以多个权限,  hasAnyAuthority("admin","admin1")
                //.antMatchers("/toAdmin").hasAnyAuthority("admin")
                // 拥有abc这个角色
                //.antMatchers("/list").hasRole("abc")
                // 基于ip访问
                //.antMatchers("/list").hasIpAddress("127.0.0.1")
                // 第二种写法
                //.antMatchers("/list").access("hasRole('abc')")

                //regexMatchers 是正则表达式  我这里不用 跳过
                //.regexMatchers()
                // MVC
                //.mvcMatchers()
                // 拦截所有请求 必须放在最后 从上往下  authenticated必须被认证
                .anyRequest().authenticated();
        //自定义access方法
        //.anyRequest().access("@myServiceImpl.hasPermission(request,authentication)");
        // authenticated就对应 被认证过
        // rememberMe 是记住我
        // anonymous 是匿名 和permitAll 差不多，但是有的是匿名需要访问。 必须商品页面是可以匿名访问的
        // fullyAuthenticated 对应的是 必须输入密码和用户名的

        //异常处理 没有权限
        http.exceptionHandling().accessDeniedHandler(myAccessDeniedHandler);



        // 记住我  多少天内不需要登录  存储到jdbc中
        http.rememberMe()
                // 设置数据源
                .tokenRepository(jdbcTokenRepository)
                // 设置前端发送过来的请求的参数
                .rememberMeParameter("remember")
                // 默认是2周 超时时间 超过这个时间需要重新登录
                .tokenValiditySeconds(10)
                // 自定义登录逻辑
                .userDetailsService(userDetailService)
        ;
        // 关闭cors  跨站请求伪造 相当于防火墙的意思
        //http.csrf().disable();

    }




}
