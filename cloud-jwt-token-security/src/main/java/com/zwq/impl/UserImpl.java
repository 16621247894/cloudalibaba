package com.zwq.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zwq.entity.UserVO;
import com.zwq.mapper.UserMapper;
import com.zwq.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserImpl extends ServiceImpl<UserMapper, UserVO> implements UserService {
}
