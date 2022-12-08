package com.nest.studentappnew_backend.controller;

import com.nest.studentappnew_backend.dao.StudentDao;
import com.nest.studentappnew_backend.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class StudentController {

    @Autowired
    private StudentDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add", consumes = "application/json",produces = "application/json")
    public Map<String,String> Addstudent(@RequestBody Students s){
        System.out.println(s.getName().toString() );

        dao.save(s);
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Students> Viewstudent(){
        return (List<Students>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Students> Searchstudent(@RequestBody Students s){
        String name=String.valueOf(s.getName());
        System.out.println(name);

        return (List<Students>) dao.Searchstudent(s.getName());

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete",consumes = "application/json",produces = "application/json")
    public Map<String,String> Deletestudent(@RequestBody Students s){
        String id = String.valueOf(s.getId());
        System.out.println(id);
        dao.deleteStudent(s.getId());
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }
}
