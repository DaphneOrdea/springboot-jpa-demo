package com.phantom.jpa.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @author : phantom
 * @desc :
 * @create : 2019/12/9 20:13
 */
@Entity
@Table(name = "student", schema = "hibernate-demo")
public class StudentEntity {
    private int id;
    private Integer age;
    private Date birthday;
    private String name;
    private String sex;
//    private Integer teacherId;
    private AccountEntity accountEntity;
    private TeacherEntity teacherEntity;

    @ManyToOne(targetEntity = TeacherEntity.class)
    @JoinColumn(name = "teacher_id")
    public TeacherEntity getTeacherEntity() {
        return teacherEntity;
    }

    public void setTeacherEntity(TeacherEntity teacherEntity) {
        this.teacherEntity = teacherEntity;
    }

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "studentEntity")//级联映射
    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键生成策略，自增
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sex", nullable = true, length = 4)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", age=" + age +
                ", birthday=" + birthday +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", accountEntity=" + accountEntity +
                ", teacherEntity=" + teacherEntity +
                '}';
    }
}
