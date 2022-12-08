package com.nest.studentappnew_backend.dao;

import com.nest.studentappnew_backend.model.Students;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentDao extends CrudRepository<Students,Integer> {

    @Query(value = "SELECT `id`, `admno`, `college`, `name`, `rollno` FROM `students` WHERE `name` LIKE %:name%",nativeQuery = true)
    List<Students> Searchstudent (@Param("name") String name);

}
