package com.dept.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author WH1707008
 * @date 2018/7/26 15:25
 * Description:
 * 创建一个实体类
 * 如何进行持久化？
 * 1、使用@Entity进行实体类的持久化操作，当JPA检测到我们的实体类当中
 * 有@Entity注解的时候，会在数据库中生成对应的表结构信息。
 * 如何指定主键以及主键的生成策略？
 * 2、使用@Id指定主键
 **/

@Entity
public class Cat implements Serializable {
    /**
     * 使用@Id指定主键
     * 使用@GeneratedValue(strategy = GenerationType.IDENTITY)指定主键的生成策略
     *mysql默认的是自增长
     * */
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    /**名字*/
    @Column(name="catName")
    private String catName;
    /**年龄*/
    @Column(name="catAge")
    private int catAge;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getCatAge() {
        return catAge;
    }

    public void setCatAge(int catAge) {
        this.catAge = catAge;
    }
}
