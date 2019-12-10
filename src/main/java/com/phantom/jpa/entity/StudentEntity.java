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
    private Integer teacherId;
    private AccountEntity accountEntity;


    @OneToOne(cascade = CascadeType.ALL,mappedBy = "studentEntity")
    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Basic
    @Column(name = "teacher_id", nullable = true)
    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return id == that.id &&
                Objects.equals(age, that.age) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(name, that.name) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(teacherId, that.teacherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, birthday, name, sex, teacherId);
    }


    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", age=" + age +
                ", birthday=" + birthday +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", teacherId=" + teacherId +
                ", accountEntity=" + accountEntity +
                '}';
    }
}
