package com.divyansh.SpringJDBC.repo;

import com.divyansh.SpringJDBC.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepo {
    public void save(Student s) {
        System.out.println("Added");
    }

    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        return students;
    }
}
