package com.ipaye.studentdataapi.Controller;

import com.ipaye.studentdataapi.Model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){
        return new Student("Ramesh", "fadatare");
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Rabiu", "farhan"));
        students.add(new Student("Tony", "farhan"));
        students.add(new Student("Isak", "farhan"));
        students.add(new Student("Tony", "farhan"));
        students.add(new Student("John", "farhan"));

        return students;
    }

    @GetMapping("/student/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("firstName") String firstName,
                                       @PathVariable("lastName") String lastName){
        return new Student(firstName, lastName);
    }

    // build rest api to handle query parameters
    // http://localhost:8080/student?firstName=Ramesh&lastName=Fadatare
    @GetMapping("/student/query")
    public Student studentQueryPage(@RequestParam(name= "firstName") String firstName,
                                    @RequestParam(name="lastName") String lastName){
        return new Student(firstName, lastName);
    }



}
