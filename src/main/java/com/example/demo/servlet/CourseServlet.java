package com.example.demo.servlet;

import com.example.demo.bean.Course;
import com.example.demo.dao.Coursedao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
private Coursedao cdao;
public void init(){cdao=new Coursedao();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String action =req.getParameter("action");
   if ("edit".equals(action)){
    int id = Integer.parseInt(req.getParameter("courseid"));
    Course course=cdao.getCoursebyid(id);
    req.setAttribute("course",course);
    req.getRequestDispatcher("updatecourse.jsp").forward(req,resp);
}else if ("delete".equals(action)){

    int id =Integer.parseInt(req.getParameter("courseid"));
    cdao.deletecourse(id);
    resp.sendRedirect(req.getContextPath()+"/CourseServlet");

}else {
    List<Course> courseList=cdao.getallCourses();
    req.setAttribute("courselist",courseList);
    req.getRequestDispatcher("CourseList.jsp").forward(req,resp);
}}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String action =req.getParameter("action");
    System.out.println("Action: " + action);
    if ("update".equals(action)){
        int id=Integer.parseInt(req.getParameter("courseid"));
        String name=req.getParameter("coursename");
        Course course=new Course(id,name);
        cdao.updatecourse(course);
    }else{
        System.out.println("jjjjj");

        String name = req.getParameter("coursename");
        Course course=new Course(name);
        cdao.CreateCourse(course);
    }
    resp.sendRedirect(req.getContextPath()+"/CourseServlet");
    }
}
