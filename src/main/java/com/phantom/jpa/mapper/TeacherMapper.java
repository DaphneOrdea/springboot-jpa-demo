package com.phantom.jpa.mapper;

import com.phantom.jpa.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : phantom
 * @desc :
 * @create : 2019/12/11 14:44
 */
public interface TeacherMapper extends JpaRepository<TeacherEntity,Integer> {

}
