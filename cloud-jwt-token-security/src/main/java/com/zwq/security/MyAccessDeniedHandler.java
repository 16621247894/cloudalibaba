package com.zwq.security;

import com.zwq.jwt.JWTUtils;
import com.zwq.message.CodeEnum;
import com.zwq.message.ReturnMessage;
import com.zwq.message.ReturnMessageUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定义未授权做的事情
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse resp, AccessDeniedException e) throws IOException, ServletException {
        //响应状态
        resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        // json数据

        resp.setHeader("Content-type","application/json;charset=utf-8");
        PrintWriter writer=resp.getWriter();
        ReturnMessage<Object> error = ReturnMessageUtil.error(CodeEnum.SC_FORBIDDEN);
        writer.write(JWTUtils.generalSubject(error));
        writer.flush();
        writer.close();
    }
}
