package com.ymk.dynamic.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@Table(name="tb_role")
public class UserRoleEntity implements Persistable<String>, Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "enname")
    private String enname;

    public boolean isNew() {
        return false;
    }
}
