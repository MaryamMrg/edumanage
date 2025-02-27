package com.example.demo.dao;


import com.example.demo.bean.Student;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


public class StudentDao {
    private Connection connection;
 public StudentDao(){
     try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/étudiants","root","");
         System.out.println("Connected to the database ");
     } catch (Exception e) {
         e.printStackTrace();
         System.out.println("Failed to connect to database");
     }
 }
public void CreateStudent(Student student){
     String sql ="insert into etuds(name,email)values(?,?)";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
        preparedStatement.setString(1,student.getName());
        preparedStatement.setString(2,student.getEmail());

        preparedStatement.executeUpdate();
    }catch (Exception e) {
        e.printStackTrace();
    }
}
public  List<Student> getallStudents(){
    List<Student> studentlist = new ArrayList<>();
    String sql ="select *from etuds";
    try(Statement stmt = connection.createStatement(); ResultSet res = stmt.executeQuery(sql)){
        while (res.next()) {
            Student student = new Student();
            student.setId(res.getInt("id"));
            student.setName(res.getString("name"));
            student.setEmail(res.getString("email"));


            studentlist.add(student);
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    return studentlist;
}

public  Student getStudentbyid(int id){
     Student student =null;
     String sql ="select * from etuds where id =?";
     try(PreparedStatement prest = connection.prepareStatement(sql)){
         System.out.println("eeeeeeeeee");
         prest.setInt(1,id);
         try(ResultSet res =prest.executeQuery()){
             if(res.next()){
                 student=new Student();
                 student.setId(res.getInt("id"));
                 student.setName(res.getString("name"));
                 student.setEmail(res.getString("email"));
             }

         }

     }catch (Exception e){
         System.out.println("not found");
     }
return student;
}
public void updatestudent(Student student){
String sql= "update etuds set name=?,email=? where id=?";
    System.out.println("nnnnn");
try(PreparedStatement stmt =connection.prepareStatement(sql)){
    System.out.println("tttttttttttttt");
    stmt.setString(1,student.getName());
    stmt.setString(2,student.getEmail());
    stmt.setInt(3, student.getId());
    stmt.executeUpdate();
}catch (Exception e){
    e.printStackTrace();
}

}
public  void deleteStudent(int id){
     String sql ="delete from etuds where id=?";
     try(PreparedStatement pres= connection.prepareStatement(sql)){
         pres.setInt(1,id);
         pres.executeUpdate();
     }catch (Exception e){
         e.printStackTrace();
         System.out.println("not found");
     }
}
}
