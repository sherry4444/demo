package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/6.
 */
@Entity
@Table(name = "s_role", catalog = "demo")
public class SRole implements Serializable {

    private Integer id;
    private SUser SUser;
    private String name;

    public SRole() {
    }

    public SRole(Integer id, com.example.demo.entity.SUser SUser, String name) {
        this.id = id;
        this.SUser = SUser;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid", nullable = false)
    public com.example.demo.entity.SUser getSUser() {
        return SUser;
    }

    public void setSUser(com.example.demo.entity.SUser SUser) {
        this.SUser = SUser;
    }

    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
