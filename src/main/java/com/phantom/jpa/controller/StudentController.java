package com.phantom.jpa.controller;

import com.phantom.jpa.entity.AccountEntity;
import com.phantom.jpa.entity.StudentEntity;
import com.phantom.jpa.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

/**
 * @author : phantom
 * @desc :
 * @create : 2019/12/9 9:43
 */
@Controller
public class StudentController {


    @Autowired StudentMapper studentMapper;

    @RequestMapping("/add")
    @ResponseBody
    public String add(){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName("张杰");
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountValue("ccccc");
        studentEntity.setAccountEntity(accountEntity);
        accountEntity.setStudentEntity(studentEntity);
        StudentEntity save = studentMapper.save(studentEntity );
        System.out.println("save = " + save);
        return "success";
    }

}
