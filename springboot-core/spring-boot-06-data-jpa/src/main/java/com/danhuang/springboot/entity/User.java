package com.danhuang.springboot.entity;

import javax.persistence.*;

//配置映射关系
//告诉jpa这是一个实体类（和数据表映射的类）
@Entity
@Table(name = "tbl_user")//指定和哪个数据表对应；如果省略默认表明就是user
public class User {

    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;

    @Column(name = "last_name",length = 50) //这是和数据表对应的一个列
    private String lastNmae;
    @Column //如果省略默认列名就是属性
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastNmae() {
        return lastNmae;
    }

    public void setLastNmae(String lastNmae) {
        this.lastNmae = lastNmae;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
