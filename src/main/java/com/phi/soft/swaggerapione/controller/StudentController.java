package com.phi.soft.swaggerapione.controller;

import com.phi.soft.swaggerapione.dto.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/api")
public class StudentController {

    private ConcurrentMap<String,Student> students=new ConcurrentHashMap<>();

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") String id){
        return students.get(id);

    }

    @GetMapping("/")
    public List<Student> getAllStudents(){
        return new ArrayList<>(students.values());

    }

    @PostMapping("/")
    public Student saveStudent(@RequestBody Student student){
        students.put(student.getStudentId(),student);
        return student;

    }
}
