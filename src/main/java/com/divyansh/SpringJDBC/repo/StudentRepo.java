package com.divyansh.SpringJDBC.repo;

import com.divyansh.SpringJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        String sql = "INSERT INTO student(rollNo,name,marks) VALUES(?,?,?)";
        int rows = jdbc.update(sql,s.getRollNo(),s.getName(),s.getMarks());
        System.out.println(rows + " effected");

    }

    public List<Student> getAll() {
        String query = "SELECT * FROM student";

        // Mapping Each Row to a result object
        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setRollNo(rs.getInt("rollNo"));
                s.setName(rs.getString("name"));
                s.setMarks((rs.getInt("marks")));
                return s;
            }
        };

        return jdbc.query(query, mapper);
    }
}
