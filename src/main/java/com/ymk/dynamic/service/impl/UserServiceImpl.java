package com.ymk.dynamic.service.impl;

import com.ymk.dynamic.entity.UserEntity;
import com.ymk.dynamic.entity.UserRoleEntity;
import com.ymk.dynamic.exception.ServiceException;
import com.ymk.dynamic.repository.UserRepository;
import com.ymk.dynamic.repository.UserRoleRepository;
import com.ymk.dynamic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * mkyoung
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<UserEntity> findAll() {
        throw new ServiceException("异常");
     /*   List<UserEntity> all = userRepository.findAll();
//        findRole();
        return all;*/
    }

    private void findRole(){
        List<UserRoleEntity> all = userRoleRepository.findAll();

        System.out.println(Arrays.deepToString(all.toArray()));
    }
}
