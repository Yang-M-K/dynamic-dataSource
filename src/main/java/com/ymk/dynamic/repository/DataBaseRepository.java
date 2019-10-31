package com.ymk.dynamic.repository;

/**
 * mkyoung
 **/
import com.ymk.dynamic.entity.DataBaseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface DataBaseRepository extends BaseJpaRepository<DataBaseEntity,String> {
}