package com.phantom.jpa.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author : phantom
 * @desc :
 * @create : 2019/12/9 20:13
 */
@Entity
@Table(name = "teacher", schema = "hibernate-demo")
public class TeacherEntity {
    private int id;
    private String name;
    private String birthday;
    private Set<StudentEntity> studentEntitySet = new HashSet<>();

    //fetch =FetchType.EAGER急加载
    @OneToMany(targetEntity = StudentEntity.class,mappedBy = "teacherEntity" )
    public Set<StudentEntity> getStudentEntitySet() {
        return studentEntitySet;
    }

    public void setStudentEntitySet(Set<StudentEntity> studentEntitySet) {
        this.studentEntitySet = studentEntitySet;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "birthday", nullable = true, length = 30)
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherEntity that = (TeacherEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(birthday, that.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthday);
    }
}
