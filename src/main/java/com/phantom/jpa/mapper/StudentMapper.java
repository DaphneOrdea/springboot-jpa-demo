package com.phantom.jpa.mapper;

import com.phantom.jpa.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : phantom
 * @desc :
 * @create : 2019/12/9 9:44
 */
public interface StudentMapper extends JpaRepository<StudentEntity,Integer>{


}
