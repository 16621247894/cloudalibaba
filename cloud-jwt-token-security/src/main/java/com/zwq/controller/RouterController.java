package com.zwq.controller;

import com.zwq.message.ReturnMessage;
import com.zwq.message.ReturnMessageUtil;
import com.zwq.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RouterController {

    @Autowired
    private RedisCache redisCache;

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @GetMapping("/toLogin")
    public String toLogin() {
        return "views/login";
    }

    @GetMapping({"/index", "/"})
    public String hello() {
        /*
        redisCache.set("xxx1","zwq");
        String xxx1 = redisCache.get("xxx1");
        System.out.println("获取的xxx1:" + xxx1);*/
        System.out.println("进入了index页面");


        return "index";
    }

    @PostMapping("/toMain")
    public String toMain() {
        System.out.println("进入了注销的controller");
        return "views/main";
    }

    @PostMapping("/fail")
    public String fail(){
        System.out.println("登录失败跳转页面");
        return "fail";
    }
    @GetMapping("/failResp")
    @ResponseBody
    public String failResp(){
        return "hehe，登录失败返回呵呵 ";
    }

    @GetMapping("/logout")
    public String logout() {
        System.out.println("进入了注销的controller");
        return "index";
    }

    @GetMapping("/toAdmin")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public String toAdmin() {
        return "views/main";
    }

    @GetMapping("/admin")
    @ResponseBody
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public String admin() {
        return "我是管理员";
    }

    /**
     * Secured 是判断有没有这个角色 ROLE_ 固定格式 必须大写   @Secured("ROLE_abc") 有没有abc这个角色
     * Secured 不支持支援配置   @Secured("/admin") 是无效的
     * @return
     */
    @Secured("ROLE_abc")
    @GetMapping("list")
    public String list(){
        return "views/list";
    }

    /**
     * 普通用户
     * PreAuthorize 表示访问方法或者类在执行之前先判断权限， 大多情况下都是使用这个注解
     * 参数和access方法参数取值相同，都是权限表达式
     * PostAuthorize 是执行之后再判断
     * @PreAuthorize("hasRole('abc')")  是否拥有abc这个角色  等同于@PreAuthorize("hasRole('ROLE_abc')")
     * @PreAuthorize("hasAnyAuthority('normal')") 有这个资源
     *
     * @return
     */
    //@PreAuthorize("hasRole('ROLE_abc')")
    @PreAuthorize("hasAnyAuthority('normal')")
    @GetMapping("/normal")
    @ResponseBody
    public String normal() {
        return "我是普通用户";
    }


    @GetMapping("myLogout")
    @ResponseBody
    public ReturnMessage<Object> myLogout(){
        // 自定义注销接口 可以做清除令牌的操作等  跳转到登录页面
        System.out.println("自定义注销controller");
        return ReturnMessageUtil.sucess("注销成功了 清除了令牌");
    }
}
