package com.zwq.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zwq.entity.UserVO;
import com.zwq.jwt.JWTSubject;
import com.zwq.jwt.JWTUtils;
import com.zwq.message.ReturnMessage;
import com.zwq.message.ReturnMessageUtil;
import com.zwq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

//@RestController
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /*@GetMapping("login")
    public String getInfo(String loginName, String password) {
        UserVO userVO = userService.getOne(new QueryWrapper<UserVO>().eq("username", loginName).eq("password", password));
        if (userVO == null) {
            System.out.println("用户登录失败");
            return "views/login";
            //return ReturnMessageUtil.error(CodeEnum.LOGINNAMEANDPWDERROR);
            //如果遇到了异常 会走全局异常
            //throw new NullPointerException("空指针异常");
            // return "登录失败";
        }

        // 登录成功返回token
        JWTSubject subject = new JWTSubject(loginName);
        // 1分钟有效期
        String jwtToken = JWTUtils.createJWT(UUID.randomUUID().toString(), "sxt-test-jwt",
                JWTUtils.generalSubject(subject), 1 * 60 * 10000);
        // 返回token
        return "views/main";
        //return ReturnMessageUtil.sucess(jwtToken);
    }*/
    @GetMapping("testNo")
    public ReturnMessage<Object> testNo(){
        System.out.println("用户可以直接访问");
        return ReturnMessageUtil.sucess("666啊老弟，我给你留灯");
    }


    @GetMapping("test")
    public ReturnMessage<Object> test(){
        System.out.println("必须登录获取token才可以");
        return ReturnMessageUtil.sucess("已经获取token可以正常访问");
    }
}
