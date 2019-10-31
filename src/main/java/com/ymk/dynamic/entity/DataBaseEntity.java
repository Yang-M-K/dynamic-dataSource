package com.ymk.dynamic.entity;

import lombok.Data;
import org.springframework.data.domain.Persistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * mkyoung
 **/
@Data
@Entity
@Table(name = "tbl_database")
public class DataBaseEntity implements Persistable<String>, Serializable{
        @Id
    @Column(name = "id")
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "driver")
    private String driver;

    @Column(name = "url")
    private String url;

    @Column(name = "type")
    private String type;

    @Override
    public boolean isNew() {
        return false;
    }

}
