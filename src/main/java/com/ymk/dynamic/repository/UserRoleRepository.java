package com.ymk.dynamic.repository;

/**
 * mkyoung
 **/
import com.ymk.dynamic.entity.UserRoleEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends BaseJpaRepository<UserRoleEntity,String> {
}