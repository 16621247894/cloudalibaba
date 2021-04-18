package com.zwq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zwq.entity.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserVO> {


}
