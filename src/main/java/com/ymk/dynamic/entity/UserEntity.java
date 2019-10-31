package com.ymk.dynamic.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * mkyoung
 **/
@Data
@Entity
@NoArgsConstructor
@Table(name="tb_user")
public class UserEntity implements Persistable<String>, Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public UserEntity(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public boolean isNew() {
        return false;
    }
}