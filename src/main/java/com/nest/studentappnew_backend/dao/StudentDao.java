package com.nest.studentappnew_backend.dao;

import com.nest.studentappnew_backend.model.Students;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentDao extends CrudRepository<Students,Integer> {

    @Query(value = "SELECT `id`, `admno`, `college`, `name`, `rollno` FROM `students` WHERE `name` LIKE %:name%",nativeQuery = true)
    List<Students> Searchstudent (@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `students` WHERE `id`=:id",nativeQuery = true)
    void deleteStudent(@Param("id") Integer id);

}
