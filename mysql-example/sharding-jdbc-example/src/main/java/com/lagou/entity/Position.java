package com.lagou.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="position")
public class Position implements Serializable {

    @Id
    @Column(name = "id")

    /**
     * org.springframework.orm.jpa.JpaSystemException: The database returned no natively generated identity value;
     *
     * 如果在插入数据库时，明确的给id进行了赋值，那么这里则不能指定生成策略
     * 如果指定了，则会报错
     *
     */
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private String salary;

    @Column(name = "city")
    private String city;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
