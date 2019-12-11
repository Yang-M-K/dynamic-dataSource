package com.ymk.dynamic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ymk.dynamic.entity.UserEntity;

import java.util.List;

/**
 * mkyoung
 **/
public interface UserService extends IService<UserEntity>{

    List<UserEntity> findAll();

}
