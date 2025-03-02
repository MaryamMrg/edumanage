package com.example.demo.dao;

import com.example.demo.bean.Course;
import com.example.demo.bean.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Coursedao {
    private Connection connection;

    public Coursedao() {
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/étudiants", "root", "");
            System.out.println("Connected to the database ");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database");
        }
    }

    public void CreateCourse(Course course) {
        String sql = "insert into courses (coursename) values(?)";
        try (PreparedStatement prst = connection.prepareStatement(sql)) {
            prst.setString(1, course.getCoursename());

            prst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Course> getallCourses() {
        List<Course> courseList = new ArrayList<>();

        String sql = "select *from courses";
        System.out.println("hete");
        try (PreparedStatement psrt = connection.prepareStatement(sql); ResultSet res = psrt.executeQuery()) {

            while (res.next()) {
                Course course = new Course();
                course.setCourseid(res.getInt("courseid"));
                course.setCoursename(res.getString("coursename"));
                courseList.add(course);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseList;
    }

    public Course getCoursebyid(int id) {
        Course course = null;
        String sql = "select *from courses where courseid=?";
        System.out.println("mmmmm");
        try (PreparedStatement psrt = connection.prepareStatement(sql)) {
            psrt.setInt(1, id);
            try (ResultSet res = psrt.executeQuery()) {
                if (res.next()) {
                    course = new Course();
                    course.setCourseid(res.getInt("courseid"));
                    course.setCoursename(res.getString("coursename"));
                    System.out.println("gggg");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return course;

    }
    public void updatecourse(Course course){
        String sql ="update courses set coursename=? where courseid=?";
        try(PreparedStatement prst=connection.prepareStatement(sql)){
            prst.setString(1,course.getCoursename());
            prst.setInt(2,course.getCourseid());
            prst.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void deletecourse(int id){
        String sql="delete from courses where courseid=?";
        try(PreparedStatement prst=connection.prepareStatement(sql)){
            prst.setInt(1,id);
            prst.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}