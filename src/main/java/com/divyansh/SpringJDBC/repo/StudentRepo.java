package com.divyansh.SpringJDBC.repo;

import com.divyansh.SpringJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) { // provided by Data Source
        this.jdbc = jdbc;
    }

    public void save(Student s) {
        String sql = "INSERT INTO student(rollNo,name,marks) VALUES(?.?,?)";
        int rows = jdbc.update(sql,s.getRollNo(),s.getName(),s.getAge());
        System.out.println(rows + " effected");

    }

    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        return students;
    }
}
