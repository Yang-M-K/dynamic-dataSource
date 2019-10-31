package com.ymk.dynamic.repository;

import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseJpaRepository<T extends Persistable<ID>, ID extends Serializable> extends JpaRepository<T, ID>,
        JpaSpecificationExecutor<T> {
}