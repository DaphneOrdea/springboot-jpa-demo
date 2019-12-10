package com.phantom.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @author : phantom
 * @desc :
 * @create : 2019/12/9 20:12
 */
@Entity
@Table(name = "account", schema = "hibernate-demo")
public class AccountEntity implements Serializable {

    private String accountValue;

    @Id
    @JoinColumn(name = "student_id")
    @OneToOne(cascade = CascadeType.ALL)
    private StudentEntity studentEntity;

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    @Basic
    @Column(name = "account_value", nullable = true, length = 20)
    public String getAccountValue() {
        return accountValue;
    }

    public void setAccountValue(String accountValue) {
        this.accountValue = accountValue;
    }


    @Override
    public String toString() {
        return "AccountEntity{" +
                "accountValue='" + accountValue + '\'' +
                '}';
    }
}
