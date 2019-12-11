package com.phantom.jpa.controller;

import com.phantom.jpa.entity.AccountEntity;
import com.phantom.jpa.entity.StudentEntity;
import com.phantom.jpa.entity.TeacherEntity;
import com.phantom.jpa.mapper.StudentMapper;
import com.phantom.jpa.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author : phantom
 * @desc :
 * @create : 2019/12/9 9:43
 */
@Controller
public class StudentController {


    @Autowired 
    StudentMapper studentMapper;
    
    @Autowired
    TeacherMapper teacherMapper;

    @RequestMapping("/add")
    @ResponseBody
    public String add(){
//        StudentEntity studentEntity = new StudentEntity();
//        studentEntity.setName("张杰");
//        AccountEntity accountEntity = new AccountEntity();
//        accountEntity.setAccountValue("ccccc");
//        studentEntity.setAccountEntity(accountEntity);
//        accountEntity.setStudentEntity(studentEntity);
//        StudentEntity save = studentMapper.save(studentEntity );
//        System.out.println("save = " + save);
        List<TeacherEntity> all = teacherMapper.findAll();
        for (TeacherEntity teacherEntity : all) {
            Set<StudentEntity> studentEntitySet = teacherEntity.getStudentEntitySet();
            for (StudentEntity studentEntity : studentEntitySet) {
                System.out.println(teacherEntity.getName()+" 对应的学生 " + studentEntity.getName());
            }
        }
        return "success";
    }

}
