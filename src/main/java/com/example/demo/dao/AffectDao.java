package com.example.demo.dao;
import com.example.demo.bean.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AffectDao {
    private Connection connection;
    public AffectDao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/étudiants", "root", "");
            System.out.println("Connected to the database ");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database");
        }
    }
public void assignement(int id, int courseid){
        String sql ="insert into aff (id,courseid) values(?,?)";
        try(PreparedStatement prst= connection.prepareStatement(sql)){
             prst.setInt(1,id);
             prst.setInt(2,courseid);
             prst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
}
public List<Course> getCoursesbyStudentid(int id){
    List<Course> courseList = new ArrayList<>();
    String sql = "";
    try(PreparedStatement prst= connection.prepareStatement(sql); ResultSet res = prst.executeQuery()) {
              prst.setInt(1,id);
       try(ResultSet rs =prst.executeQuery()){
           while (rs.next()){
               int courseid=rs.getInt("courseid");
               String coursename = rs.getString("coursename");
               Course course = new Course(courseid,coursename);
               courseList.add(course);
           }
       }

    }catch (Exception e) {
        e.printStackTrace();
    }
    return courseList;
    }
}
