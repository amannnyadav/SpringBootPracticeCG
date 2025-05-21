package org.cg.studentinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class StudentInfoApplication {
    public List<Student> students=new ArrayList<>();

    @GetMapping("/get")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/post")
    public String addStudent(@RequestBody Student student) {
        students.add(student);
        return "success";
    }

    @PutMapping("/put/{id}")
    public String editStudent(@PathVariable int id , @RequestBody Student student) {
        for(Student s : students) {
            if(s.getId()==id) {
                s.setId(student.getId());
                s.setName(student.getName());
                s.setAge(student.getAge());
            }
        }
        return "Student updated!";
    }


    @DeleteMapping("/delete/{id}")
    public String delStudent(@PathVariable int id) {
        boolean removed = students.removeIf(student -> student.getId() == id);
        if (removed) {
            return "Successfully deleted";
        } else {
            return "Student not found";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentInfoApplication.class, args);
    }

}
