package com.ibm.demo.restgraphqlapp.servlets;


import com.ibm.demo.restgraphqlapp.dao.StudentRepository;
import com.ibm.demo.restgraphqlapp.dto.Student;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/student")
public class StudentsRepositoryEntrypoint {

    @Resource
    private StudentRepository studentRepository;

    @GetMapping("/read")
    @Transactional
    public Student getStudent(@RequestParam final Integer id) {
        return studentRepository.findById(id).get();
    }

    @GetMapping("/add")
    @Transactional
    public Student addStudent(@RequestParam final Integer id, @RequestParam final String name) {
        Student student = new Student(id, name);
        return studentRepository.save(student);
    }


}
