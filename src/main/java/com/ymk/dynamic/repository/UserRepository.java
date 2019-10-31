package com.ymk.dynamic.repository;

/**
 * mkyoung
 **/
import com.ymk.dynamic.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseJpaRepository<UserEntity,String> {
}