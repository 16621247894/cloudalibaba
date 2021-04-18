package com.zwq.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
@Service
public interface MyService {


    boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
