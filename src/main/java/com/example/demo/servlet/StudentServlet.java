package com.example.demo.servlet;

import com.example.demo.bean.Student;
import com.example.demo.dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
private StudentDao stdao;
public void init(){stdao=new StudentDao();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("act");

if ("edit".equals(action)){
    int id = Integer.parseInt(req.getParameter("id"));
    Student student=stdao.getStudentbyid(id);
    req.setAttribute("student",student);
    req.getRequestDispatcher("updateStudent.jsp").forward(req,resp);
} else if ("delete".equals(action)) {
    int id =Integer.parseInt(req.getParameter("id"));
    stdao.deleteStudent(id);
    resp.sendRedirect(req.getContextPath()+"/StudentServlet");

}else {
    List<Student> studentList=stdao.getallStudents();
    req.setAttribute("studentlist",studentList);
    req.getRequestDispatcher("StudentList.jsp").forward(req,resp);
}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action =req.getParameter("act");
        System.out.println("Action: " + action);
        if ("update".equals(action)){
            System.out.println("innnnnn");
            int id=Integer.parseInt(req.getParameter("id"));
            String name=req.getParameter("name");
            String email=req.getParameter("email");

            Student student=new Student(name,email);
            student.setId(id);
            stdao.updatestudent(student);
        }else{
            System.out.println("tttttttttttttttt");
            String name = req.getParameter("name");
            String email =req.getParameter("email");
            Student student=new Student(name,email);
            stdao.CreateStudent(student);
        }
        resp.sendRedirect(req.getContextPath()+"/StudentServlet");
    }
}
