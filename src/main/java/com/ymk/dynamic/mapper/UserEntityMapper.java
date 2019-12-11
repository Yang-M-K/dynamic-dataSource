package com.ymk.dynamic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ymk.dynamic.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserEntityMapper extends BaseMapper<UserEntity> {
}
